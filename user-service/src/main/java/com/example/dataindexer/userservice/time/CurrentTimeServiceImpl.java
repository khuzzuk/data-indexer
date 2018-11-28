package com.example.dataindexer.userservice.time;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class CurrentTimeServiceImpl implements CurrentTimeService {
    @Override
    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }
}
