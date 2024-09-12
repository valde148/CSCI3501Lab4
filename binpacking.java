import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
            if (bin1Cap <= 0 && n - 1 < items.size()) {
                bin1.add(items.get(n - 1));
                bin1Cap += items.get(n - 1);
                items.remove(n - 1);
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
            if (bin2Cap <= 0 && n - 1 < items.size()) {
                bin2.add(items.get(n - 1));
                bin2Cap += items.get(n - 1);
                items.remove(n - 1);
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
            if (bin3Cap <= 0 && n - 1 < items.size()) {
                bin3.add(items.get(n - 1));
                bin3Cap += items.get(n - 1);
                items.remove(n - 1);
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