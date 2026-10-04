package lw02.prelab;

import java.util.*; //22

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner (Main.class.getResourceAsStream("transactions.txt")) ;

        LinkedList <String[]> transactions = new LinkedList<>();
        LinkedList <String[]> customersData = new LinkedList<>();

        Queue <String[]> process = new LinkedList<>(); //process transa
        Stack <String[]> failed = new Stack<>(); 

        while (sc.hasNext()) {
            while(sc.hasNext()){  
            String[] transaction = new String[3];
            transaction[0] = sc.next(); //name
            transaction[1] = sc.next(); //type
            transaction[2] = sc.next(); //amount
            transactions.add(transaction); //add array ke linkedlist
        }

        process.addAll(transactions);
        
        while (!process.isEmpty()){ //kalo kita udah abis nge poll berarti loop nya berhenti
            String[] transaction = process.poll(); //udah dapet 1 transaksi yang isi nama, type dan amount
            String name = transaction[0]; //name itu single value, dan transaction[0] itu juga single value, jadi name itu gaperlu ditambah array
            String type = transaction[1]; 
            int amount = Integer.parseInt(transaction [2]);

            String[] customer = null; //kita anggap gaada culu customernya
            for (String[] data : customersData){ //diasumsikan customer datanya ada di raisa
                if (data[0].equals (name)) { //ambil name dari transcation, apakah ada di customerData atau belum
                    customer = data; 
                    break;
                }
            }
            
            if (customer==null){ //if belum ada
                customer = new String[2]; 
                customer[0] = name;
                customer[1] = "0";
                customersData.add(customer);  
            }

            int balance = Integer.parseInt(customer[1]);
            if (type.equals ("DEPOSIT")){
                balance += amount;
                customer[1] = String.valueOf(balance);
            }else{
                if (balance < amount){
                        failed.push(transaction);
                }else{
                    balance -= amount;
                    customer[1] = String.valueOf(balance); //untuk update balance (yang awalnya integer) menjadi string
                }
            }
        }
        System.out.println("=== Final Balances ===");
        for(String[] customer : customersData){
            System.out.println(customer[0] + ": " + customer[1]);
        }

        System.out.println("=== Final Transaction ===");
            while (!failed.isEmpty()) {
                String[] transaction = failed.pop();
                System.out.println(transaction[0] + transaction[1] + transaction[2]);
        }
    }
}
}