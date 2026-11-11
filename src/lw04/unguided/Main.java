package lw04.unguided;

import java.util.*;

public class Main {
    public static void bubbleSort(int[] A, int n, int dari, int sampai) {
        for (int i = dari; i < sampai; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j] < A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
 
    public static int[] binarySearch(int[] A, int n, int target) {
        int low = 0;
        int high = n - 1;
        int steps = 0;
 
        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;                      
 
            if (A[mid] == target) {
                return new int[]{mid, steps};
            } else if (A[mid] > target) { 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, steps};
    }
 
    public static void printArray(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(A[i]);
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
 
        int n = sc.nextInt();
        int[] shelf = new int[n];
        for (int i = 0; i < n; i++) {
            shelf[i] = sc.nextInt();
        }
 
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();
 
        bubbleSort(shelf, n, 0, 2);
 
        int[] afterTwo = new int[n];
        for (int i = 0; i < n; i++) {
            afterTwo[i] = shelf[i];
        }
 
        bubbleSort(shelf, n, 2, n - 1);
 
        System.out.println("==== After 2 Passes ====");
        printArray(afterTwo, n);
 
        System.out.println("==== Fully Sorted ====");
        printArray(shelf, n);
 
        System.out.println("==== Search Results ====");
        for (int i = 0; i < m; i++) {
            int[] hasil = binarySearch(shelf, n, targets[i]);
 
            if (hasil[0] == -1) {
                System.out.println(targets[i] + ": NOT FOUND (steps: " + hasil[1] + ")");
            } else {
                System.out.println(targets[i] + ": FOUND at index " + hasil[0] + " (steps: " + hasil[1] + ")");
            }
        }
    }
}
    
