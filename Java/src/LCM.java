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

public class LCM {
    static EuclidGCD EuclidObject = new EuclidGCD();
    static LCM one = new LCM();
    
    static void findLCM(int num1,int num2){
        int gcd;
        gcd = EuclidGCD.findGcd(num1,num2);
        System.out.println(num1/gcd*num2);
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter two numbers\n");
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        one.findLCM(num1,num2);
    }
}
