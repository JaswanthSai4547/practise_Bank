package test;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ListIterator;

public class Methods
{

    BufferedReader sc2 = new BufferedReader(new InputStreamReader(System.in));
    int id = 0;
    File f = new File("/home/ee213130/Documents/bank.txt");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    ListIterator li = null;

    public void create_account(Bank b) throws Exception {
        try {
                System.out.println(":) Welcome To MY world - Axis Bank :)\nenter your name:");
                b.setName(sc2.readLine());
                System.out.println("enter phone number:");
                b.setPn(Integer.parseInt(sc2.readLine()));
                System.out.println("enter address:");
                b.setAddress(sc2.readLine());
                System.out.println("enter ac no");
                b.setAc_no(Long.parseLong(sc2.readLine()));
                System.out.println("enter email:");
                b.setEmail(sc2.readLine());
                b.setBalance(0);

                Bank.getBankobj().add(b);

                oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(Bank.getBankobj());
                oos.close();

                System.out.println("account is created :)");
        }catch (Exception exc){
            System.out.println("file not found");
        }
    }

    public void display() throws Exception
    {
        if(f.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(f));
            Bank.setBankobj((ArrayList<Bank>) ois.readObject());
            ois.close();
            System.out.println("-----------------------");
            li = Bank.getBankobj().listIterator();
            while (li.hasNext()){
                Bank b = (Bank) li.next();
                System.out.println("Name : " + b.getName());
                System.out.println("phone : " + b.getPn());
                System.out.println("address : " + b.getAddress());
                System.out.println("email : " + b.getEmail());
                System.out.println("balance : " + b.getBalance());
                System.out.println("Transaction History");
                System.out.println("a/c no : " + b.getAc_no());
                for (int j = 0; j < b.getTransaction_list().size(); j++)
                    System.out.println(b.getTransaction_list().get(j));
                System.out.println("--------------------");
            }
        }else {
            System.out.println("file not found");
            System.out.println("---------------------");
        }
    }



    public void credit(Transaction t) throws Exception
    {
        if(f.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(f));
            Bank.setBankobj((ArrayList<Bank>) ois.readObject());
            ois.close();

            System.out.println("enter account number :");
            long temp = Long.parseLong(sc2.readLine());
            li = Bank.getBankobj().listIterator();
            while (li.hasNext()){
                Bank b = (Bank) li.next();
                if (temp == b.getAc_no()) {
                    System.out.println("enter amount :");
                    double temp1 = Double.parseDouble(sc2.readLine());
                    b.setBalance(b.getBalance() + temp1);
                    id += 1;
                    t.setTran_id('c' + Integer.toString(id));
//                    System.out.println("enter date:");
                    t.setDate(LocalDate.now());
//                    System.out.println("enter time:");
                    t.setTime(LocalTime.now());
                    t.setBalance(b.getBalance());
                    b.getTransaction_list().add(t);
                    System.out.println("amount credited successfully :)");
                    System.out.println("Available balance : " + b.getBalance());

                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(Bank.getBankobj());
                    oos.close();
                    break;
                }
            }
        }else {
            System.out.println("file not found");
        }
    }
    public void debit(Transaction t) throws Exception
    {
        if(f.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(f));
            Bank.setBankobj((ArrayList<Bank>) ois.readObject());
            ois.close();

            System.out.println("enter account number :");
            long temp = Long.parseLong(sc2.readLine());
            System.out.println("enter amount :");
            double temp1 = Double.parseDouble(sc2.readLine());
            li = Bank.getBankobj().listIterator();
            while (li.hasNext()){
                Bank b = (Bank) li.next();
                if (temp == b.getAc_no()) {
                    if (temp1 <= b.getBalance()) {
                        b.setBalance(b.getBalance() - temp1);
                        id += 1;
                        t.setTran_id('d' + Integer.toString(id));
//                        System.out.println("enter date:");
                        t.setDate(LocalDate.now());
//                        System.out.println("enter time:");
                        t.setTime(LocalTime.now());
                        t.setBalance(b.getBalance());
                        b.getTransaction_list().add(t);
                        System.out.println("successfully debited : " + temp1 + "/-");
                        System.out.println("available balance : " + b.getBalance() + "/-");
                    } else {
                        System.out.println("insufficient balance :(");
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(Bank.getBankobj());
                    oos.close();
                    break;
                }
            }

        }else {
            System.out.println("file  not found");
        }
    }
    public void delete() throws Exception
    {
        if(f.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(f));
            Bank.setBankobj((ArrayList<Bank>) ois.readObject());
            ois.close();

            System.out.println("enter account number :");
            long temp = Long.parseLong(sc2.readLine());
            li = Bank.getBankobj().listIterator();
            while (li.hasNext())
            {
                Bank b = (Bank) li.next();
                if (temp == b.getAc_no())
                {
                    li.remove();
                    System.out.println("deleted successfully");
                    break;
                }
            }

            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(Bank.getBankobj());
            oos.close();
        }else {
            System.out.println("file not found");
        }
    }
}