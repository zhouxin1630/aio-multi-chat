package com.zxwang.multichat;

import java.io.IOException;
import java.net.ServerSocket;

public class AioServer extends Thread {
    private ServerSocket serverSocket;
    private IMessageHandler handler;

    public AioServer(int port, IMessageHandler handler) throws IOException {
        this.handler = handler;
        this.serverSocket = new ServerSocket(port);
    }

    public void onStart() {
        // 启动监听连接线程
        new ListeningThread(this, serverSocket).start();
    }
}
