package dushenin.oleksii.microservices.common.web;

import dushenin.oleksii.microservices.common.Context;
import dushenin.oleksii.microservices.common.ContextHolder;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.*;
import java.io.IOException;

import static dushenin.oleksii.microservices.common.ContextHolder.CORRELATION_ID;

public class ContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest servletRequest = (HttpServletRequest) request;
        final String correlationId = (String) servletRequest.getAttribute(CORRELATION_ID);
        ContextHolder.setContext(new Context(correlationId));

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
