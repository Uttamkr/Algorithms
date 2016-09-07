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
public class QuickSort {
    static int[] array = new int[]{5,4,2,6,2,7,6,3};
    
    public static QuickSort one = new QuickSort();
    
    void Sort(int left, int right){
        
        if(left>=right)
            return;
        int middle = left+(right-left)/2;
        int pivot = array[middle];
        int temp = 0;
        
        int i= left;
        int j = right;
        
        while(i<=j){
            while(array[i]<pivot)
                i++;
            while(array[j]>pivot)
                j--;
            if(i<=j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if(left<j)
            one.Sort(left, j);
        if(right>i)
            one.Sort(i, right);
    }
    
    public static void main(String[] args){
        int left = 0;
        int right = array.length-1;
        one.Sort(left,right);
        System.out.println("Sorted: "+ Arrays.toString(array));
    }
}
