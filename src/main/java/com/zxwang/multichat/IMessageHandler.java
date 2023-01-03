package com.zxwang.multichat;

import java.net.ServerSocket;

public interface IMessageHandler {
    void onReceive(Message message, ServerSocket serverSocket);
}
