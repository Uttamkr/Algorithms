/*

    **Program to generate random numbers based on Linear Congruential Generators**
 
     * @author Uttam Kumar
 
 */
import java.util.Scanner;

public class LCG {
    
    int gen = 15;                                                                   // Number of random numbers to be generated
    void gen(int x,int a,int b,int m){
        gen--;
        x = (x*a+b)%m;                                                              // Basic generation calculation
        System.out.print(x+" ");
        while(gen!=0)
            gen(x,a,b,m);
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the values for X,A,B and M");
        
        /*
        int a[] = new int[10];
        String lines = scan.nextLine();
        String[] str = lines.trim().split("\\s+");
        for(int i = 0; i < 2 ; i++)
            a[i] = Integer.parseInt(str[i]);
        */
        
        int x = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        int m = scan.nextInt();
        
        LCG one = new LCG();                                                         // Object for class LCG
        
        one.gen(x,a,b,m);
        
        
    }
}
