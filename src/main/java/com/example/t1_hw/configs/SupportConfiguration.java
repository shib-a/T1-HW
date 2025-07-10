package com.example.t1_hw.configs;

import com.example.t1_hw.*;

@Configuration
public class SupportConfiguration {

    @Instance
    public SupportServlet supportServlet(){
        return new SupportServlet(supportService());
    }
    @Instance
    public SupportServiceImpl supportService(){
        return new SupportServiceImpl();
    }
}
