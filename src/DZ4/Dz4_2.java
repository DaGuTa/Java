package DZ4;

import java.util.Scanner;

public class Dz4_2 {
    public static void main(String[] args) {
        Scanner inStr = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        System.out.print(passValidation(inStr.nextLine()));

    }
    public static boolean passValidation(String passwd){
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
        return passwd.matches(regex);
    }

}
