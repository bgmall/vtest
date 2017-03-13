package resteasy;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import org.jboss.resteasy.plugins.server.embedded.SimpleSecurityDomain;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;
import org.jboss.resteasy.test.TestPortProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import io.netty.util.concurrent.DefaultThreadFactory;

import static org.jboss.resteasy.test.TestPortProvider.generateURL;

/**
 * Created by msg on 2016/12/29.
 */
public class JDKHttpServer {

    private HttpServer httpServer;

    private HttpContextBuilder httpContextBuilder;

    private Executor httpExecutor = Executors.newSingleThreadExecutor(new DefaultThreadFactory("http-server"));

    private Executor executor = Executors.newFixedThreadPool(1);

    public void start(int port, int requestQueueLength) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(port), requestQueueLength);
        httpServer.setExecutor(httpExecutor);
        httpContextBuilder = new HttpContextBuilder();
        httpContextBuilder.getDeployment().getDefaultContextObjects().put(Executor.class, executor);
        httpContextBuilder.getDeployment().getActualResourceClasses().add(SimpleResource.class);
        httpContextBuilder.bind(httpServer);
        HttpContext context = httpServer.createContext("/");
        httpServer.start();
    }

    public void stop() {
        if (httpContextBuilder != null) {
            httpContextBuilder.cleanup();
        }
        if (httpServer != null) {
            httpServer.stop(0);
        }
    }

    public static void main(String[] args) throws IOException {
        int port = TestPortProvider.getPort();
        System.out.println(port);
        JDKHttpServer jdkHttpServer = new JDKHttpServer();
        // port, queueLength
        jdkHttpServer.start(port, 10);

        Client client = ClientBuilder.newClient();
        {
            Response response = client.target(generateURL("/basic")).request().get();
            System.out.println("status=" + response.getStatus());
            System.out.println("response content=" + response.readEntity(String.class));
        }
//        {
//            Response response = client.target(generateURL("/basic")).request().put(Entity.entity("basic", "text/plain"));
//            System.out.println("status=" + response.getStatus());
//            response.close();
//        }
//        {
//            Response response = client.target(generateURL("/queryParam")).queryParam("param", "hello world").request().get();
//            System.out.println("status=" + response.getStatus());
//            System.out.println("response content=" + response.readEntity(String.class));
//        }
//        {
//            Response response = client.target(generateURL("/uriParam/1234")).request().get();
//            System.out.println("status=" + response.getStatus());
//            System.out.println("response content=" + response.readEntity(String.class));
//        }
//
//        {
//            Response response = client.target(generateURL("/matrixParam;name=zhang;author=shi")).request().get();
//            System.out.println("status=" + response.getStatus());
//            System.out.println("response content=" + response.readEntity(String.class));
//        }
    }
}
