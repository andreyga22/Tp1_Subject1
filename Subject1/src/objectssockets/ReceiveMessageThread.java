/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectssockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alelizmu
 */
public class ReceiveMessageThread extends Thread {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server; // server socket
    private Socket connection; // connection to client
    private final boolean disconnect = false;
    private final int PORT = 12345;

    public ReceiveMessageThread(Socket connection, ObjectOutputStream output, ObjectInputStream input) {
        this.connection = connection;
        this.input = input;
        this.output = output;
    }

    private void processConnection() throws IOException, InterruptedException, ClassNotFoundException {
        while (!disconnect) {
            System.out.println(input.readObject());
        }
    }

    // close streams and socket
    private void closeConnection() {
        System.out.println("\nTerminating connection");
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket  
            server.close(); // clse server socket
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    private void waitForConnection() throws IOException {
        System.out.println("Waiting for connection...\n");
        connection = server.accept(); // allow server to accept connection
        System.out.println("Connection received from: " + connection.getInetAddress().getHostName());
    }
    
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information   
        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());
    }
    
    @Override
    public void run() {
        try {
            getStreams();
            waitForConnection();
            processConnection();
        } catch (IOException | InterruptedException | ClassNotFoundException ex) {
            Logger.getLogger(ReceiveMessageThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(); // close connection
        }
    }
}
