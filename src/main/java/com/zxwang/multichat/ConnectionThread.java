package com.zxwang.multichat;

import java.net.Socket;

public class ConnectionThread extends Thread {
    private boolean isRunning;
    private Socket clientSocket;
    private AioServer server;

    public ConnectionThread(AioServer server, Socket socket) {
        this.isRunning = true;
        this.clientSocket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        while (isRunning) {
            if (clientSocket.isClosed()) {
                isRunning = false;
                break;
            }
        }
    }
}
