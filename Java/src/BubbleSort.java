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
public class BubbleSort {
    public static int[] array = {22,41,12,10,32,45,98,78,55}; 
    public void Sort(){
        int temp = 0;
        for(int i = 0; i<array.length; i++){
            for(int j = i+1; j<array.length; j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        BubbleSort one = new BubbleSort();
        one.Sort();
        System.out.println("Sorted Array: "+Arrays.toString(array));
    }
}
