package dushenin.oleksii.microservices.movies.conf.web;

import dushenin.oleksii.microservices.common.Context;
import dushenin.oleksii.microservices.common.ContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class ContextInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        final String correlationId = ContextHolder.getContext().map(Context::getCorrelationId).orElse(null);

        final HttpHeaders headers = request.getHeaders();
        headers.add(ContextHolder.CORRELATION_ID, correlationId);

        return execution.execute(request, body);
    }

}
