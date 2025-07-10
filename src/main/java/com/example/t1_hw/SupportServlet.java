package com.example.t1_hw;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import jakarta.servlet.http.*;

public class SupportServlet extends HttpServlet {
    private SupportService supportService;

    @Override
    public void init() {
        supportService = new SupportService();
    }
    public SupportServlet(SupportService service){
        this.supportService = service;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String message = supportService.getRandomMessage();
        out.append(message);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        try(BufferedReader in = request.getReader()){
            String message = in.readLine();
            supportService.addMessage(message);
            out.append(message);
        } catch (IOException e){
            response.setStatus(500);
            out.append("Error:").append(e.getMessage());
        }

    }

}