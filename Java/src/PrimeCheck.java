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
import java.util.Random;

public class PrimeCheck {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the number to be cheked");
        double num = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the number of checks to be performed");
        double checks = Double.parseDouble(scan.nextLine());
        
        int max = (int)num;
        int min = 1;
        int k = 0;
        
        for(int i = 0 ; i<checks ; i++){
            int random = rand.nextInt((max-min)+1)+min;
            System.out.print(" "+random+"\n");
            if(Math.pow(random,num-1)%num == 1){
                k+=1;
            }
        }
        if(k<checks-1){
            System.out.println("The number is not prime "+k);
        }
        else{
            System.out.println("The number is most probably prime "+k);
        }
    }
}
