import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class binpacking {

    public static void packing(List<Integer> items, int n, int cap) {
        List<Integer> bin1 = new ArrayList<>();
        List<Integer> bin2 = new ArrayList<>();
        List<Integer> bin3 = new ArrayList<>();

        int bin1Cap = 0;
        int bin2Cap = 0;
        int bin3Cap = 0;

        Collections.sort(items);

        while (bin1Cap < cap && !items.isEmpty()) {
            if (bin1Cap <= 0) {
                bin1.add(items.get(0));
                bin1Cap += items.get(0);
                items.remove(0);
            } else if (bin1Cap < cap) {
                int largest = largestFit(items, bin1Cap, cap);
                if (largest == 0) {
                    break;
                }
                bin1.add(largest);
                bin1Cap += largest;
                items.remove(Integer.valueOf(largest));
            }
        }

        while (bin2Cap < cap && !items.isEmpty()) {
            if (bin2Cap <= 0) {
                bin2.add(items.get(0));
                bin2Cap += items.get(0);
                items.remove(0);
            } else if (bin2Cap < cap) {
                int largest = largestFit(items, bin2Cap, cap);
                if (largest == 0) {
                    break;
                }
                bin2.add(largest);
                bin2Cap += largest;
                items.remove(Integer.valueOf(largest));
            }
        }

        while (bin3Cap < cap && !items.isEmpty()) {
            if (bin3Cap <= 0) {
                bin3.add(items.get(0));
                bin3Cap += items.get(0);
                items.remove(0);
            } else if (bin3Cap < cap) {
                int largest = largestFit(items, bin3Cap, cap);
                if (largest == 0) {
                    break;
                }
                bin3.add(largest);
                bin3Cap += largest;
                items.remove(Integer.valueOf(largest));
            }
        }

        System.out.println("Bin 1: " + bin1);
        System.out.println("Bin 2: " + bin2);
        System.out.println("Bin 3: " + bin3);
        System.out.println("Remaining Items: " + items);
    }

    public static int largestFit(List<Integer> items, int curcap, int cap) {
        int largest = 0;
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i) + curcap <= cap) {
                largest = items.get(i);
                break;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        List<Integer> bin = new ArrayList<>();
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