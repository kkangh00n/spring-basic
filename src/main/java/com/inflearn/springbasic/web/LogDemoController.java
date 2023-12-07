package com.inflearn.springbasic.web;

import com.inflearn.springbasic.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public LogDemoController(LogDemoService logDemoService, ObjectProvider<MyLogger> myLogger) {
        this.logDemoService = logDemoService;
        this.myLoggerProvider = myLogger;
    }


    @RequestMapping("log-demo")
    @ResponseBody
    public String logdemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = this.myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller Test");
        logDemoService.logic("testId");
        return "ok";
    }
}
