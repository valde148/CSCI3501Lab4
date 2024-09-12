import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class binpacking {

    public static void packing(List<Integer> items, int n, int cap) {
        List<Integer> bin1 = new ArrayList<>(); // Create 3 bins
        List<Integer> bin2 = new ArrayList<>();
        List<Integer> bin3 = new ArrayList<>();

        List<Integer> curBin = bin1; // Current bin starting at bin 1
        int curBinCap = 0; // Current bin capacity

        Collections.sort(items); // Sort the items in ascending order

        for (int i = 0; i < 3; i++) { // Loop through the 3 bins
            while (curBinCap < cap && !items.isEmpty()) { 
                if (curBinCap <= 0 && n - 1 < items.size()) { // If the current bin is empty and the next item fits
                    curBin.add(items.get(n - 1)); // Add the item to the bin
                    curBinCap += items.get(n - 1); // Update the current bin capacity
                    items.remove(n - 1); // Remove the item from the list
                } else if (curBinCap < cap) {
                    int largest = largestFit(items, curBinCap, cap); // Find the largest item that fits
                    if (largest == 0) { // If no items fit break loop go to next bin
                        break;
                    }
                    curBin.add(largest); // Add the item to the bin
                    curBinCap += largest; // Update the current bin capacity
                    items.remove(Integer.valueOf(largest)); // Remove the item from the list
                }
            }
            if (i == 0) { // Update the current bin and reset the current bin capacity
                bin1 = curBin;
                curBin = bin2;
                curBinCap = 0;
            } else if (i == 1) {
                bin2 = curBin;
                curBin = bin3;
                curBinCap = 0;
            } else {
                bin3 = curBin;
            }
        }

        System.out.println("Bin 1: " + bin1);
        System.out.println("Bin 2: " + bin2);
        System.out.println("Bin 3: " + bin3);
        System.out.println("Remaining Items: " + items);
    }

    public static int largestFit(List<Integer> items, int curcap, int cap) {
        int largest = 0; 
        for (int i = items.size() - 1; i >= 0; i--) { // Loop through the items in descending order
            if (items.get(i) + curcap <= cap) {
                largest = items.get(i); // Find the largest item that fits
                break;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        List<Integer> items = new ArrayList<>();
        System.out.println("Enter the items separated by spaces: ");
        String[] inputItems = sc.nextLine().split(" ");
        for (String item : inputItems) {
            items.add(Integer.parseInt(item));
        }
        System.out.println("Enter the bin capacity: ");
        int cap = sc.nextInt();
        packing(items, n, cap);
        sc.close();
    }
}