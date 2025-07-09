package com.example.t1_hw;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import jakarta.servlet.http.*;

public class SupportServlet extends HttpServlet {
    private ArrayList<String> helpMessages;
    private Random random;

    public void init() {
        helpMessages = new ArrayList<>();
        helpMessages.add("У тебя все получится");
        helpMessages.add("Выше нос!");
        random = new Random();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        int randomIndex = random.nextInt(helpMessages.size());
        out.println(helpMessages.get(randomIndex));
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try(BufferedReader in = request.getReader()){
            String message = in.readLine();
            helpMessages.add(message);
        } catch (IOException e){
            response.setStatus(500);
        }
    }
    public ArrayList<String> getHelpMessages(){
        return this.helpMessages;
    }

}