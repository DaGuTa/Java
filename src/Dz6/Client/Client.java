package Dz6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(String ipAddress, int port){
        Scanner scan = new Scanner(System.in);
        try {
            socket = new Socket(ipAddress, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Resender resend = new Resender();
            resend.start();

            String str = "";
            while (!str.equals("/exit")) {
                str = scan.nextLine();
                out.writeUTF(str);
            }

            System.out.println("Тормозим поток");
            resend.setStopService();
            resend.join();
            System.out.println("Поток остановлен");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            System.out.println("Закрываем сокет");
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Resender extends Thread{
        private boolean stopService;

        public void setStopService() {
            stopService = true;
            System.out.println("Клиент будет закрыт");
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
            System.out.println("Поток закрыт");
        }
    }

}
