/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
import java.util.*;
public class Solution {
    
    
   public static void main(String[] args){
        //Scanner class to input elements
        Scanner scan = new Scanner(System.in);
        
        int left = 0;
        int right = 0;
        int queries = 0;
        int length = 0 ;
        //taking inputs
        ArrayList<Integer> ar = new ArrayList<>();
        String[] input = (scan.hasNextLine())?scan.nextLine().split(" "):new String[1000];
        for(String incoming : input){
            try{
                ar.add(Integer.parseInt(incoming));
            }catch(Exception e){
                
            }
        }
        try{
            length = ar.get(0);
            queries = ar.get(1);
        }catch(Exception e){
            System.out.println(e);
        }
        ArrayList<Integer> arr = new ArrayList<>(length);
        input = (scan.hasNextLine())?scan.nextLine().split(" "):new String[1000];
        for(String incoming : input){
            try{
                arr.add(Integer.parseInt(incoming));
            }catch(Exception e){
                
            }
        }
        
        
        while(queries!=0){
            //Adding substring elements to HashMap for all queries
            HashMap<Integer,Integer> temp = new HashMap<>();
            int sum = 0;
            ArrayList<Integer> tt = new ArrayList<>();
            input = (scan.hasNextLine())?scan.nextLine().split(" "):new String[1000];
            for(String incoming : input){
                try{
                    tt.add(Integer.parseInt(incoming));
                }catch(Exception e){
                
                }
            }
            try{
                left = tt.get(0);
                right = tt.get(1);
            }catch(Exception e){
                System.out.println(e);
                left = 0;
                right = 0;
            }

            for(int i = left-1;i<right;i++){
                int k = arr.get(i);
                int inp = (temp.containsKey(k))?temp.get(k)+1:1;
                temp.put(arr.get(i),inp);
            }
            //Calculating values for all substrings
            for(Map.Entry<Integer,Integer> entry : temp.entrySet()){
                sum+= entry.getKey()*entry.getValue()*entry.getValue();
            }
            System.out.println(sum);
            queries--;
        }
    
    }
}
/*
for(Map.Entry<Integer,Integer> entry : temp.entrySet()){
                
                    sum+= entry.getKey()*entry.getValue()*entry.getValue();
                
            }
*/