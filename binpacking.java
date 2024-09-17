//Armando Valdez & Jaden Rainey
//The conclusion is at the bottom of the code 
import java.util.Scanner;

public class binpacking {

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
//Conclusion
//in order for me to run this program I had to use java script terminal in order for it to work
//I used the command java binpacking.java in order for it to run, then it will ask you to Enter 
// bin capacity(B) and after that the number of items(N) then lastely to enter the items in.
//after that it will run and will attempt to pack the items into bins that i have named bin1,
//bin2, and bin3 but also print out the left over.
//the documentation and explanation of the algorithm. this algorithm will use first fit decreasing
// in order to pack the items in bins and such. It will first set up the items in decreasing order. 
// By sorting the items it helps place the largest items into the bins first. Once that is complete
//the algorithm will try to place the items into bin1 that has enouh remaining space. Whatever can't
//fit then it is placed in leftovers. It does come up with a close enough solution. Meaning that
//it doesn't guarantee an optimal solution. This algorithm focuses on filling the bins but could
// leave small amounts of unsued space. It takes more effect with smaller items or when the item
//distribution is uneven. 
//This is an example of optimal soultion, when running the terminal we get Enter B: 20 next we
//get enter N: 8, after that we get Enter the items: 12 4 8 15 9 3 1 10. We get a Bin1: [15, 4 ,1]
//Bin2:[12, 8] Bin3:[10, 9] Leftover items: [3]
//Then for the non opitmal example, I used the example Enter B: 10, Enter N: 5 Enter the items:
//9 7 3 2 1 8, we get Bin1:[9, 1] Bin2: [7, 3] Bin3: [2] and No leftover items. In this case
// the algorithm fails to pack the items efficiently since it prioritizes filling the bins with
// large items first.
//Compute the efficiency of your algorithm in terms of Big-O, the efficiency of the algorithm
//can be understood in terms of how much time it takes to process the input as the number of
//items increases. First, the algorithm sorts the items from largest to smallest, using a sorting
//method called bubble sort. This sorting process is not the fastest, and it takes longer as the
//number of items increases, specifically, the time it takes grows roughly with the square of the
//number of items. After sorting, the it tries to place each item into the first bin that has 
//enough space. However, in the worst case, the algorithm may check bin for each item, which 
//also takes time that grows with the square of the number of items. The overall time the 
// algorithm takes depends heavily on the number of items, and in the worst case, the time grows
//as the number of items increases. we used a faster sorting method, the algorithm would run more 
//efficiently, but as it stands, the algorithm is slower when dealing with large inputs.