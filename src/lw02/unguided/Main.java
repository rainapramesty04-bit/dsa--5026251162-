package lw02.unguided;

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));
 
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foodsData = new LinkedList<>();
        LinkedList<String[]> drinksData = new LinkedList<>();
        LinkedList<String[]> success = new LinkedList<>();
 
        Queue<String[]> process = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();
 
        while (sc.hasNext()) {
            String[] order = new String[4];
            order[0] = sc.next(); 
            order[1] = sc.next(); 
            order[2] = sc.next(); 
            order[3] = sc.next(); 
            orders.add(order);
        }
 
        foodsData.add(new String[]{"Bakso", "2"});
        foodsData.add(new String[]{"Sate", "1"});
        foodsData.add(new String[]{"Soto", "2"});
 
        drinksData.add(new String[]{"EsTeh", "4"});
        drinksData.add(new String[]{"EsJeruk", "2"});
 
        process.addAll(orders);
 
        while (!process.isEmpty()) { 
            String[] order = process.poll(); 
            String name = order[0];
            String food = order[1];
            String drink = order[2];
            String table = order[3];
 
            String[] foodRecord = null;
            String[] drinkRecord = null;
            boolean foodAvailable = true;  
            boolean drinkAvailable = true;
 
            if (!food.equals("-")) {
                for (String[] data : foodsData) {
                    if (data[0].equals(food)) {
                        foodRecord = data;
                        break;
                    }
                }
                int stock = Integer.parseInt(foodRecord[1]);
                foodAvailable = stock > 0;
            }
 
            if (!drink.equals("-")) {
                for (String[] data : drinksData) {
                    if (data[0].equals(drink)) {
                        drinkRecord = data;
                        break;
                    }
                }
                int stock = Integer.parseInt(drinkRecord[1]);
                drinkAvailable = stock > 0;
            }
 
            if (foodAvailable && drinkAvailable) {
                if (foodRecord != null) {
                    int stock = Integer.parseInt(foodRecord[1]);
                    foodRecord[1] = String.valueOf(stock - 1);
                }
                if (drinkRecord != null) {
                    int stock = Integer.parseInt(drinkRecord[1]);
                    drinkRecord[1] = String.valueOf(stock - 1);
                }
                success.add(order);
            } else {
                failed.push(order);
            }
        }
 
        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : success) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
 
        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for (String[] food : foodsData) {
            System.out.println(food[0] + " : " + food[1]);
        }
 
        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] drink : drinksData) {
            System.out.println(drink[0] + " : " + drink[1]);
        }
 
        System.out.println();
        System.out.println("=== Failed Orders ===");
        while (!failed.isEmpty()) { 
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}
 
