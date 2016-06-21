package objectssockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private ServerSocket server; // server socket
    private Socket connection; // connection to client
    private int PORT = 12345;
    private ReceiveMessageThread thread;

    public Server() {
    }
 
    public void runServer() {
        try {
            server = new ServerSocket(PORT); 
            waitForConnection();
            getStreams(); 
            thread = new ReceiveMessageThread(connection, input, "hilo de espera");
            thread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException {
        System.out.println("Waiting for connection...\n");
        connection = server.accept(); // allow server to accept connection
        System.out.println("Connection received from: " + connection.getInetAddress().getHostName());
    }

    // get streams to send and receive objects
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }

    // process connection with client
    public void sendMessage(String message) throws IOException, ClassNotFoundException {
        output.writeObject(message);
    }

    // close streams and socket
    public void closeConnection() {
        System.out.println("\nTerminating connection");
        try {
            output.close(); // close output stream
            connection.close(); // close socket
            server.close(); // clse server socket
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
//
//    public static void main(String[] args) {
//        new Server(12345).runServer();
//    }
}
