package resteasy;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.xml.ws.spi.http.HttpExchange;

/**
 * Created by msg on 2017/2/6.
 */
public class HttpInterceptor implements ContainerRequestFilter, ReaderInterceptor {

    @Context
    HttpExchange httpRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Request request = requestContext.getRequest();
        
    }

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        MultivaluedMap<String, String> headers = context.getHeaders();
        System.out.println(headers.get("X-Real-IP"));
        return null;
    }
}
