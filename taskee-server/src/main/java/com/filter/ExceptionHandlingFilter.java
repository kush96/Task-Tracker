//package com.filter;
//
//import com.dto.response.ResponseMessage;
//import com.google.gson.Gson;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(1)
//public class ExceptionHandlingFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        Gson gson = new Gson();
//            filterChain.doFilter(servletRequest, servletResponse);
//
//    }
//
//}
