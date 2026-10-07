package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner rgs = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Set<String> registered = new LinkedHashSet<>();
 
        while (rgs.hasNext()) {
            String id = rgs.next();
            registered.add(id); 
        }
        rgs.close();

        Set<String> checkedIn = new LinkedHashSet<>();
        int rejected = 0;

        Scanner chk = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        System.out.println("===== Event Check-In Results =====");

        while (chk.hasNext()) {
            String id = chk.next();

        if (!registered.contains(id)) {
                System.out.println(id + ": Rejected (not registered)");
                rejected++;
            } else if (checkedIn.contains(id)) {
                System.out.println(id + ": Rejected (already checked in)");
                rejected++;
            } else {
                checkedIn.add(id);
                System.out.println(id + ": Checked in");
            }
        }
        chk.close();

        int registeredCount = registered.size();
        int successCount = checkedIn.size();
        int absentCount = registeredCount - successCount;
 
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registeredCount);
        System.out.println("Successful check-ins: " + successCount);
        System.out.println("Absent students: " + absentCount);
        System.out.println("Rejected attempts: " + rejected);
    }
}

