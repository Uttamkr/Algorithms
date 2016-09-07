/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
import java.util.Scanner;
public class OneDimensionalArray {
    
    public int n = 10;
    private int[] numArray = new int[n];
    
    public static OneDimensionalArray one = new OneDimensionalArray();
    
    public static void main(String[] args){
        one.insertArray();
        System.out.println("The standard deviation of the array is "+one.stdDeviation());
        
    }
    public void insertArray(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        one.n = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the elements of the array");
        for(int i = 0;i<n;i++)
            one.numArray[i] = Integer.parseInt(scan.nextLine());
        
    }
    public int findSum(){
        int sum = 0;
        for(int i = 0; i<= n ; i++)
            sum+= one.numArray[i];
        
        return sum;
    }
    
    public int Average(){
        int sum = one.findSum();
        return sum/n;
    }
    
    public int variance(){
        int avg = one.Average();
        int var = 0;
        
        for(int i = 0; i<n; i++)
            var+= Math.pow((one.numArray[i]-avg),2);
        return var/n;
    }
    
    public double stdDeviation(){
        return Math.sqrt(one.variance());
    }
    
}
