package resteasy;

import org.jboss.resteasy.security.smime.EnvelopedOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by msg on 2016/12/29.
 */
@Path("/")
public class SimpleResource implements BasicResource {

//    private
//    @Context
//    Executor executor;

    @GET
    @Path("basic")
    @Produces("text/plain")
    public String getBasic() throws InterruptedException, ExecutionException {
        return executeAsync(() -> "basic");
    }

    @PUT
    @Path("basic")
    @Consumes("text/plain")
    public void putBasic(String body) {
        System.out.println(body);
    }

    @GET
    @Path("queryParam")
    @Produces("text/plain")
    public String getQueryParam(@QueryParam("param") String param) throws InterruptedException, ExecutionException {
        System.out.println("query param: " + param);
        return executeAsync(() -> param);
    }

    @GET
    @Path("uriParam/{param}")
    @Produces("text/plain")
    public int getUriParam(@PathParam("param") int param) {
        return param;
    }

    @GET
    @Path("header")
    public Response getHeader() {
        return Response.ok().header("header", "headervalue").build();
    }

    @GET
    @Path("matrixParam")
    @Produces("text/plain")
    public String getMatrixParam(@MatrixParam("name") String name, @MatrixParam("author") String author) {
        return name + author;
    }

    @GET
    @Path("unblock")
    @Produces("text/plain")
    // 需要前端支持, 类似ajax client
    public void getUnblockBasic(@Suspended final AsyncResponse response) {
        executeUnblockAsync(() -> {
            Response res = Response.ok("basic").type(MediaType.TEXT_PLAIN).build();
            response.resume(res);
        });
    }

    public EnvelopedOutput getEncryptedBasic() {
        try (InputStream inStream = new FileInputStream("myapp")) {
 *CertificateFactory cf = CertificateFactory.getInstance("X.509");
 *X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
 *} catch (CertificateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private <R> R executeAsync(Supplier<R> supplier) throws ExecutionException, InterruptedException {
//        CompletableFuture<R> completableFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(60000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return supplier.get();
//        }, executor);
//        return completableFuture.get();
//    }
}
