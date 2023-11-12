package com.moaaz.bug.service.interfaces;

public interface MessageService {

    public void sendMessageForTester(int testerId , int developerId);

    public void sendMessageForDeveloper(int testerId , int developerId);
}
