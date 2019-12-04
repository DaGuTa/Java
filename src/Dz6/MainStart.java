package Dz6;

import Dz6.Client.Client;
import Dz6.Server.Server;

import java.util.Scanner;

public class MainStart {
    public static void main(String[] args) {
        int port = 9999;
        String ipAddress = "localhost";
        Scanner in = new Scanner(System.in);

        System.out.println("В каком режиме будем работать? \n S(erver) / C(lient)");
        char answer = Character.toLowerCase(in.nextLine().charAt(0));
        switch (answer){
            case ('s'):
                new Server(port);
                break;
            case ('c'):
                new Client(ipAddress, port);
                break;
            default:
                System.out.printf("Не правильный выбор.");
                break;
        }

    }
}
