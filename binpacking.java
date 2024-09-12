//Armando Valdez & Jaden Rainey
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class binpacking{

    public static void packing(List<Integer> items, int n, int cap){
        List<Integer> bin1 = new ArrayList<Integer>(n);
        List<Integer> bin2 = new ArrayList<Integer>(n);
        List<Integer> bin3 = new ArrayList<Integer>(n);

        int bin1Cap = 0;
        int bin2Cap = 0;
        int bin3Cap = 0;

        Collections.sort(items);

        for (int i = 0; bin1Cap < cap;){
            if (bin1Cap <= 0){
                bin1.set(i, items.get(i));
                items.remove(i);
            } else if (bin1Cap < cap){
                int largest = largestFit(items, bin1Cap, cap);
                if (largest == 0){ 
                    break;
                }
                bin1.set(i, largest);
                items.remove(largest);
            } 
        }
        for (int i = 0; bin2Cap < cap;){
            if (bin2Cap <= 0){
                bin2.set(i, items.get(i));
                items.remove(i);
            } else if (bin2Cap < cap){
                int largest = largestFit(items, bin2Cap, cap);
                if (largest == 0){ 
                    break;
                }
                bin2.set(i, largest);
                items.remove(largest);
            } 
        }
        for (int i = 0; bin3Cap < cap;){
            if (bin3Cap <= 0){
                bin3.set(i, items.get(i));
                items.remove(i);
            } else if (bin3Cap < cap){
                int largest = largestFit(items, bin3Cap, cap);
                if (largest == 0){ 
                    break;
                }
                bin3.set(i, largest);
                items.remove(largest);
            } 
        }

        System.out.println("Bin 1: " + bin1);
        System.out.println("Bin 2: " + bin2);
        System.out.println("Bin 3: " + bin3);
        System.out.println("Remaining Items: " + items);
    }

    public static int largestFit(List<Integer> items, int curcap, int cap){
        int largest = 0;
        for (int i = items.size() - 1; i > 0; i--){
            if (items.get(i) + curcap <= cap){
                largest = items.get(i);
                break;
            }
        }
        return largest;
    }
    public static void main(String[]args){
        // Scanner s = new Scanner(System.in);
        // System.out.println("Bin Enter: ");

        // int amountBin = s.nextInt();
        
        // System.out.println("Enter ")
        List <Integer> bin = new ArrayList<Integer>(8);
        bin.add(20);
        bin.add(8);
        bin.add(12);
        bin.add(4);
        bin.add(8);
        bin.add(15);
        bin.add(9);
        bin.add(3);
        bin.add(1);
        bin.add(10);
        packing(bin, 8, 20);

    }
} 