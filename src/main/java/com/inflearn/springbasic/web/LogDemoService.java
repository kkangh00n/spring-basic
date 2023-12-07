package com.inflearn.springbasic.web;

import com.inflearn.springbasic.common.MyLogger;
import org.springframework.stereotype.Service;

@Service
public class LogDemoService {

    private final MyLogger myLogger;

    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String id){
        myLogger.log("service id = " + id);
    }
}
