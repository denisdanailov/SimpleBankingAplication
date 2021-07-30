package BankingApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount("XYZ", "BA001");
        bankAccount.showMenu();
    }

}
