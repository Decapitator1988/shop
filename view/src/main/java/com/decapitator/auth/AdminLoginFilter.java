package com.decapitator.auth;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AdminLoginFilter implements Filter {

    @Inject
    private AuthBean authBean;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                             FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (authBean.getRole()!=null){

            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        authBean.setRequestedPage(request.getRequestURI());
        response.sendRedirect(request.getContextPath()+"/login.xhtml");
    }

    @Override
    public void destroy() {

    }
}
