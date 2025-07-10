package com.example.t1_hw;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SupportServiceImpl implements SupportService{
    private ConcurrentHashMap<String, String> helpMessages;
    private Random random = new Random();
    {
        helpMessages = new ConcurrentHashMap<>();
        helpMessages.put(UUID.randomUUID().toString(), "У тебя все получится");
        helpMessages.put(UUID.randomUUID().toString(), "Выше нос!");
    }
    public SupportServiceImpl(){
    }
    @Override
    public void addMessage(String message){
        helpMessages.put(UUID.randomUUID().toString(), message);
    }
    @Override
    public String getMessage(String uuid){
        return helpMessages.get(uuid);
    }
    @Override
    public String getRandomMessage(){
        var messageIds = helpMessages.keySet().toArray(new String[0]);
        return helpMessages.get(messageIds[random.nextInt(messageIds.length)]);
    }
}
