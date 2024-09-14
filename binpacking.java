//Armando Valdez & Jaden Rainey
import java.util.Scanner;
import java.util.Collections;

public class binpacking{

    public static void packing(int[] items, int n, int cap){
        int[] bin1 = new int[n];
        int [] bin2= new int[n];
        int[] bin3 = new int[n];

        int binsum = 0;
        int binsum2 = 0;
        int binsum3 = 0;
        int binindex =;
        int binindex2 =0;
        int binindex3 = 0;

        for(int i = 0; i<n -1; i++){
            for(int j = 0; j < n -i -1; j++){
                if (items[j] < items[j+1]){
                    int t = items[j];
                    items[j] = items[j+1];
                    items[j+ 1] = t;
                }
            }
        }
        for(int i = 0; i< n; i++){
            int x = items[i];

            if(binsum + x <= cap){
                bin1[binindex++] = x;
                binsum1 = binsum2 + x;
            }

            else if(binsum2 + x <= cap){
                bin2[binindex2 ++] = x;
                binsum2 = binsum2 +x;
            }
            else if(binsum3 + x <= cap){
                bin3[binindex3++] = x;
                binsum3 += x;
            }
        }


    System.out.println("Bin 1: ");
    for(int i = 0; i < binindex; i++){
        System.out.print(bin1[i] +" ");
    }
    System.out.println("unused space: " + (cap- binsum));

    System.out.println("Bin 2: ");
    for(int i = 0; i < binindex2; i++){
        System.out.print(bin2[i] + " ");
    }
    System.out.println("unused space: " + (cap - binsum2));

    System.out.println("Bin 3: ");
    for(int i = 0; i < binindex3; i++){
        System.out.print(bin3[i] + " ");
    }
    System.out.println("unused space: " + (cap - binsum3));

    }


    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        System.out.println("Bin Cap Enter: ");
        int b = s.nextInt();

        System.out.println("Number items: ");
        int n = s.nextInt();
        
        int[] y = new int[n];

        System.out.println("items: ");
        for(int i = 0; i < n; i++){
            y[i] = s.nextInt();
        }
        packing(y, n, bc)
    }



} 