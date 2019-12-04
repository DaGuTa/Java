package Dz6.Server;

import Dz6.Client.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public Server(int port) {
        try {
            server = new ServerSocket(port);



            Scanner scan = new Scanner(System.in);
            socket = server.accept();

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                Resender resend = new Resender();
                resend.start();

                String str = "";
                while (!str.equals("/exit")) {
                    str = scan.nextLine();
                    out.writeUTF(str);
                }
                resend.setStopService();


        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Resender extends Thread{
        private boolean stopService;

        public void setStopService() {
            stopService = true;
        }

        @Override
        public void run() {
            try {
                while (!stopService){
                    String str = in.readUTF();
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
