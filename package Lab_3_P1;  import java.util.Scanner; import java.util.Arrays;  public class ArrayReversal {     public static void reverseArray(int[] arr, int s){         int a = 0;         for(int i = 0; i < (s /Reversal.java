//package Lab_3_P1

import java.util.Scanner;
import java.util.Arrays;

public class ArrayReversal {
    public static void reverseArray(int[] arr, int s){
        int a = 0;
        for(int i = 0; i < (s / 2); i++){
            a = arr[i];
            arr[i] = arr[s - i - 1];
            arr[s - i - 1] = a;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter array size");
        int s = inp.nextInt();
        int[] arr = new int[s];

        System.out.println("Enter array elements");
        for(int i = 0; i < s; i++){
            arr[i] = inp.nextInt();
        }
        
        reverseArray(arr, s);
    }
}
