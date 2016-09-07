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
public class CountingSort {
    static int[] array = {4,2,3,1,2,4,5,6,3,1,2};
    public int[] Sort(){
        int[] result = new int[array.length];
        int[] count = new int[7];
        int i = 0,counter = 0;
        
        while(i<array.length){
            System.out.println(i+" "+array[i]);
            count[array[i]]+=1;
            i++;
        }
        
        for(i = 1; i<count.length;i++){
            int temp = count[i];
            while(temp!=0){
                result[counter++] = i;
                temp--;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args){
        CountingSort one = new CountingSort();
        int[] result = one.Sort();
        
        System.out.println("The Sorted array is: "+Arrays.toString(result));
    }
}
