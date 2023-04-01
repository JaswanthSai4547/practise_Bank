package test;

import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Methods m = new Methods();
            while (true) {
                try {

                    System.out.println("1.create account");
                    System.out.println("2.display");
                    System.out.println("3.credit");
                    System.out.println("4.debit");
                    System.out.println("5.delete");
                    System.out.println("6.exit");
                    System.out.println("enter your choice:");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            m.create_account(new Bank());
                            break;
                        case 2:
                            m.display();
                            break;
                        case 3:
                            m.credit(new Transaction());
                            break;
                        case 4:
                            m.debit(new Transaction());
                            break;
                        case 5:
                            m.delete();
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.out.println("invalid input");
                    }
                }catch (Exception exc){
                    System.out.println("invlid injf");
                }
            }
        }
    }