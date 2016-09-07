/*
 *Program to implement Merge Sort Algorithm
 *
 * @author Uttam Kumar
 */
import java.util.Arrays;
public class MergeSort {
    static int[] array = {21, 33, 45, 11, 10, 9, 54, 66, 78, 98};
    static int[] resultArray = new int [array.length];
    
    public void Merge(int low, int middle, int high){
        
        int l1=low,l2=middle+1,i=low;
        
        for(;l1<=middle && l2<=high;i++){
            
            if(array[l1]<=array[l2]){
                resultArray[i] = array[l1++];
            }else{
                resultArray[i] = array[l2++];
            }
        }   
        while(l1<=middle){
            resultArray[i++] = array[l1++];
        }
        while(l2<=high){
            resultArray[i++] = array[l2++];
        }
        i--;
        for(i=low;i<=high;i++){
            array[i] = resultArray[i];
        }
    }
    
    public void Sort(int low, int high){
        if(low<high){
            int middle = low+(high-low)/2;
            Sort(low,middle);
            Sort(middle+1,high);
            Merge(low,middle,high);
        }
        
    }
    
    public static void main(String[] args){
        System.out.println("Before Sorting: "+Arrays.toString(array) );
        MergeSort one = new MergeSort();
        one.Sort(0,array.length-1);
        System.out.println("After Sorting: "+Arrays.toString(array) );
    }
}
