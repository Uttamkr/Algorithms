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
public class SelectionSort {
    static int[] array = new int[]{4,2,5,1,25,6,74,212,12,44};
    
    public void Sort(){
        int min,j,temp,index=0;
        for(int i =0 ; i<array.length;i++){
            min = array[i];
            index = i;
            for(j = i+1; j<array.length; j++){
                //find min
                if(min>array[j]){
                    min = array[j];
                    index = j;
                }
            }
            
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
            
        }
    }
    
    public static void main(String[] args){
        
        SelectionSort one = new SelectionSort();
        System.out.println(Arrays.toString(array));
        one.Sort();
        System.out.println("Sorted: "+Arrays.toString(array));
    }
}
