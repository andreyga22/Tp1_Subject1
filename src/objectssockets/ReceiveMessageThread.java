/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectssockets;

import Main.Controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alelizmu
 */
public class ReceiveMessageThread extends Thread {

//    private ObjectOutputStream output;
    private ObjectInputStream input;
//    private ServerSocket server; // server socket
    private Socket connection; // connection to client
    private boolean disconnect = false;
    private final int PORT = 12345;
    private Controller controller;

    public ReceiveMessageThread(Socket connection, ObjectInputStream input, String name, Controller controller) {
        super(name);
        this.controller = controller;
        this.connection = connection;
        this.input = input;
    }

    private void processConnection() throws IOException, InterruptedException, ClassNotFoundException {
        while (!disconnect) {
            String text = (String) input.readObject();
            receiveMessage(text);
        }
    }

    // close streams and socket
    public void closeConnection() {
        System.out.println("\nTerminating connection");
        try {
            disconnect = true;
            input.close(); // close input stream
            connection.close(); // close socket  
//            server.close(); // clse server socket
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    private void waitForConnection() throws IOException {
//        System.out.println("Waiting for connection...\n");
//        connection = server.accept(); // allow server to accept connection
//        System.out.println("Connection received from: " + connection.getInetAddress().getHostName());
//    }
//    private void getStreams() throws IOException {
//        input = new ObjectInputStream(connection.getInputStream());
//    }
    @Override
    public void run() {
        try {
//            getStreams();
//            waitForConnection();
            processConnection();
        } catch (IOException | InterruptedException | ClassNotFoundException ex) {
            Logger.getLogger(ReceiveMessageThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void receiveMessage(String text) {
        controller.writeInTextField(text);
    }
}