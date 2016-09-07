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
import java.util.Arrays;

public class PrimeFactor {
    
    int[] factors = new int[50];
    int i = 0;
    public static PrimeFactor one = new PrimeFactor();
    
    void add(int fac){
        factors[i++]=fac;
    }
    
    void calcFactors(int num){
        
        while(num%2==0){
            one.add(2);      
            num/=2;
        }
        
        int temp = 3;
        //double stop_at = Math.sqrt(num);                                          Not working. taking stop_at = initial_num/2
        int stop_at = num;
        
        while(temp<=stop_at){
            while(num%temp==0){
                one.add(temp);
                
                num/=temp;
            }
            temp+=2;
        }
        System.out.print("Prime Factors are "+ Arrays.toString(factors));
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        one.calcFactors(num);
    }   
    
}
