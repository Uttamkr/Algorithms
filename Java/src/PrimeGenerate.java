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

public class PrimeGenerate {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine()),i;
        int[] is_prime = new int[n+1];
        
        //add 2 to the prime list
        is_prime[2] = 1;
        //remove its multiples from the list
        for(i = 4;i<=n;i+=2){
            is_prime[i] = 2;
        }
        
        for(i = 3;i<=n;i+=2){
            //check number
            if(is_prime[i]!=2)
                is_prime[i] = 1;
            
            //remove its multiples
            for(int m = i*i; m<=n ; m+=i ){
                is_prime[m] = 2;
            }
        }
        
        for(i = 2 ; i<=n;i++){
            if(is_prime[i] == 1)
                System.out.println(i);
        }
        
    }
}
