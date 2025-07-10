package com.example.t1_hw;

import java.util.UUID;

public interface SupportService {
    public void addMessage(String message);
    public String getMessage(String id);
    public String getRandomMessage();
}
