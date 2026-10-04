package lw03.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Problem 1
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List<String> playlist = new ArrayList<>(); 

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String operation = line.substring(0, line.indexOf(" ")); 
            String details = line.substring(line.indexOf(" ") + 1);
        
            if(operation.equals("ADD")){
                String song = details;
                playlist.add(song);
            
            }else if (operation.equals("INSERT")){
                int index = Integer.parseInt(details.substring(0, details.indexOf(" ")));
                String song = details.substring (details.indexOf(" ") + 1);
                playlist.add(index, song);
            }else {
                String song = details;

                if(playlist.contains(song)){
                    playlist.remove(song);
                }
            
            }
        
        }
        System.out.println("=== Problem 1 ===");
        System.out.println("Total songs: " + playlist.size());

        int nomor = 1;

        for(String abc : playlist){
            System.out.println(nomor + ". " + abc);
            nomor++;
        }

        //Problem 2
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new HashSet<>();

        int duplicate = 0;

        while(sc2.hasNext()){
            String name = sc2.next();
             if(participants.contains(name)){ //cek apakah udah ada
                duplicate++;
            }else{
                participants.add(name);
            }
        }
        System.out.println("=== Problem 2 ===");
        System.out.println("Total participants: " + participants.size());   

        int num = 1;
        for (String name : participants){
            System.out.println(num + ". " + name);
            num++; //increment
        }

        System.out.println("Duplicate participants: " + duplicate);

        sc2.close();

        //Problem 3
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new HashMap<>();

        int failed = 0;

        while(sc3.hasNext()){
            String line = sc3.nextLine();
            String[] parts = line.split(" ");

            String type = parts[0];
            String product = parts[1];
            Integer quantity = Integer.parseInt(parts[2]);

            if(type.equals("ADD")){
                if(inventory.containsKey(product)){
                    inventory.put(product, inventory.get(product) + quantity);

                }else{
                    inventory.put(product, quantity);
                }
            }else{
                if(inventory.containsKey(product) && inventory.get(product) >= quantity){   
                    inventory.put(product, inventory.get(product) - quantity);
                }else{
                    failed++;
                }
            }
                    
        }

        System.out.println("=== Problem 3 ===");

        for (String product : inventory.keySet()){
            System.out.println(product + ": " + inventory.get(product));
        }
        System.out.println("Failed sales: " + failed);
    }
}

