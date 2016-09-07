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



public class RandomizeArray {
    static String[] names = new String[10];
    
    void printNames(int win){
    for(int i=0; i<win; i++){
            System.out.println(names[i]);
        }
    }
    
    void getWinners(int win,int n){
        Random random = new Random();
        int j;
            for(int i=0; i<n; i++){
            j = random.nextInt(n+1);

            String temp = names[i];
            names[i] = names[j];
            names[j] = temp;
        }
            
        RandomizeArray one = new RandomizeArray();
        one.printNames(win);
    }
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of registrations made.");
        int n = Integer.parseInt(scan.nextLine());
        System.out.print("Enter the names of"+ n +" people\n");
        for(int i = 0; i<n; i++){
            names[i] = scan.nextLine();
        }
        System.out.print("Enter the number of winners:");
        int win = Integer.parseInt(scan.nextLine());
        
        RandomizeArray one = new RandomizeArray();
        
        one.getWinners(win,n);
    }
}
