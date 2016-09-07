/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int[] array = {4,24,63,12,53,12,34,4512,434,23,53,1};
    
    int Search(int value){
        int min = 0;
        int max = array.length-1;
        
        while(min<=max){
            int mid = (min+max)/2;
            System.out.println(array[mid]+" at "+mid+" low: "+min+" max "+max);
            if(array[mid]==value){
                return mid;
            }else if(value<array[mid]){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        BinarySearch one = new BinarySearch();
        System.out.println("Enter the value to be searched");
        int value = Integer.parseInt(scan.nextLine());
        int index = one.Search(value);
        if(index==-1){
            System.out.println("The value is not found in the array");
        }
        else{
            System.out.println("The item is found at the "+(index+1)+" place");
        }
    }
}
