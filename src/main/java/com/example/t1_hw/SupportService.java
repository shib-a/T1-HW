package com.example.t1_hw;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SupportService {
    private ConcurrentHashMap<String, String> helpMessages;
    private Random random;
    private static SupportService instance;
    public SupportService(){
        if (instance == null){
            helpMessages = new ConcurrentHashMap<>();
            helpMessages.put(UUID.randomUUID().toString(), "У тебя все получится");
            helpMessages.put(UUID.randomUUID().toString(), "Выше нос!");
            random = new Random();
        }

    }
    public void addMessage(String message){
        helpMessages.put(UUID.randomUUID().toString(), message);
    }
    public String getMessage(String uuid){
        return helpMessages.get(uuid);
    }
    public String getRandomMessage(){
        var messageIds = helpMessages.keySet().toArray(new String[0]);
        return helpMessages.get(messageIds[random.nextInt(messageIds.length)]);
    }
}
