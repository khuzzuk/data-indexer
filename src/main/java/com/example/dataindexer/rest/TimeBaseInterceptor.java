package com.example.dataindexer.rest;

import com.example.dataindexer.time.CurrentTimeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@Component
@Slf4j
public class TimeBaseInterceptor implements HandlerInterceptor {
    private CurrentTimeService currentTimeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        int hour = currentTimeService.getCurrentTime().getHour();
        if (hour > 10 && hour < 13) {
            log.info("Processing request");
        } else {
            log.warn("Processing request, but you should apply only between 10AM-1PM");
        }
        return true;
    }
}
