//Armando Valdez & Jaden Rainey
import java.util.Scanner;

public class BinPacking {

    // this method packs items into bins by using first fit decreasing
    // it also handles left overs
    public static void packing(int[] items, int n, int cap) {
        //we are using array as bins. 
        int[] bin1 = new int[n];
        int[] bin2 = new int[n];
        int[] bin3 = new int[n];
        int[] leftovers = new int[n]; //stores items leftover 

        //it sums each bin to track the total amount of space in bins
        int binsum1 = 0;
        int binsum2 = 0;
        int binsum3 = 0;
        int bin1Index = 0;
        int bin2Index = 0;
        int bin3Index = 0;
        int leftoverIndex = 0; // its for bins and leftovers

        // sort the items in descending order using bubble sort 
        // which is first fit decreasing
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items[j] < items[j + 1]) {
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }

        //placing each item in the first available bin 
        for (int i = 0; i < n; i++) {
            int x = items[i]; // x will be the current item

            if (binsum1 + x <= cap) { //placing in all three bins
                bin1[bin1Index++] = x;
                binsum1 += x;
            } else if (binsum2 + x <= cap) { 
                bin2[bin2Index++] = x;
                binsum2 += x;
            } else if (binsum3 + x <= cap) {
                bin3[bin3Index++] = x;
                binsum3 += x;
            } else { // what ever is left over 
                leftovers[leftoverIndex++] = x;
            }
        }

        // Output the contents 
        System.out.print("Bin1: [");
        for (int i = 0; i < bin1Index; i++) {
            System.out.print(bin1[i]);
            if (i < bin1Index - 1) 
            System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Bin2: [");
        for (int i = 0; i < bin2Index; i++) {
            System.out.print(bin2[i]);
            if (i < bin2Index - 1) 
            System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Bin3: [");
        for (int i = 0; i < bin3Index; i++) {
            System.out.print(bin3[i]);
            if (i < bin3Index - 1) 
            System.out.print(", ");
        }
        System.out.println("]");

        // Output any leftover items 
        if (leftoverIndex > 0) {
            System.out.print("Leftover items: [");
            for (int i = 0; i < leftoverIndex; i++) {
                System.out.print(leftovers[i]);
                if (i < leftoverIndex - 1) 
                System.out.print(", ");
            }
            System.out.println("]");
        } else {
            System.out.println("No leftover items.");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // the input for bin capacity
        System.out.println("Enter B: ");
        int b = s.nextInt();

        // this will be the input for number of items
        System.out.println("Enter N: ");
        int n = s.nextInt();

        // the acutal input of the items
        int[] items = new int[n];
        System.out.println("Enter the items: ");
        for (int i = 0; i < n; i++) {
            items[i] = s.nextInt();
        }

        //calling the packing function in order to distribute items into bins
        packing(items, n, b);
    }
}

//when writing this program it came with alot of 