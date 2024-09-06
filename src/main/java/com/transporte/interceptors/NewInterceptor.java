package com.transporte.interceptors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.transporte.constants.Constants;
import com.transporte.models.ResponseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component("newInterceptor")
@Slf4j
public class NewInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        log.info("Entra al preHandler");
        HandlerMethod controller = ((HandlerMethod)handler);
        log.info("LoadingInterceptor: preHandle() entrando ... " + controller.getMethod().getName());
        log.info("request: " + request);
        log.info("uri: " + request.getRequestURI());
        request.setAttribute("start", start);
        /*ResponseService responseService = new ResponseService(Constants.RESPONSE_TYPE_ERROR, Constants.NO_AUTENTICACION, null);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.OK.value());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String apiErrorAsJson = objectMapper.writeValueAsString(responseService);
        response.getWriter().write(apiErrorAsJson);*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;
        log.info("Tiempo transcurrido: " + result + " milisegundos");
        log.info("LoadingTimeInterceptor: postHandle() saliendo ... " + ((HandlerMethod)handler).getMethod().getName());
    }
}
