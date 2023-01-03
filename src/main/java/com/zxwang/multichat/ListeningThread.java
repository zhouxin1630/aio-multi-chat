package com.zxwang.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListeningThread extends Thread {
    private AioServer server;
    private ServerSocket serverSocket;
    private boolean isRunning;

    public ListeningThread(AioServer server, ServerSocket serverSocket) {
        this.server = server;
        this.serverSocket = serverSocket;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            if (serverSocket.isClosed()) {
                isRunning = false;
                break;
            }

            try {
                Socket socket = serverSocket.accept();
                new ConnectionThread(server, socket).start();
            } catch (IOException e) {
                System.err.println("ERROR: accept failed!\n" + e.toString());
            }
        }
    }
}
