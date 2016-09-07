/*

 **Finding GCD of two numbers using Euclid's algorithm. Implementation of recursive and non-recusive approach**

 * @author Uttam Kumar
 */

import java.util.Scanner;
public class EuclidGCD {
    
    static EuclidGCD one = new EuclidGCD();
    
    //non-recursive
    static int findGcd(int num1,int num2){
        while(num2!=0){
            int rem = num1%num2;
            num1 = num2;
            num2 = rem;
        }
        return num1;
    }
    
     //recursive GCD
     void recursiveGcd(int num1,int num2){
         if(num2==0){
             System.out.println(num1);
         }
         else{
             one.recursiveGcd(num1, num1%num2);
         }
     }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter two digits\n");
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        System.out.print("The GCD of "+num1+" and "+num2+" is ");
        int result = one.findGcd(num1,num2);
        
    }
}
