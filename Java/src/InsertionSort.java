/*
Implement Insertion Sort using 1D array
 *
 * @author Uttam Kumar
 */
import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {

    public static int[] Array = new int[20];
    static int n = 0;
    
    public void Sort(){
        int j;
        int key;
        int i;
        
        for(j = 1; j<n ; j++){
            key = Array[j];
            for(i = j-1 ; i>=0 && Array[i]>key ; i--){
                Array[i+1] = Array[i];
            }
            Array[i+1] = key;
        }
    }
    
    public static void main(String[] args){
        InsertionSort one = new InsertionSort();
        System.out.println("Enter the size of the array.");
        Scanner scan = new Scanner(System.in);
        
        n = Integer.parseInt(scan.nextLine());
        
        for(int i=0; i<n ; i++){
            Array[i] = Integer.parseInt(scan.nextLine());
        }
        one.Sort();
        System.out.println("The sorted array is:");
        System.out.println(Arrays.toString(Array));
    }
}
