/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
public class TriangularArray {
    
    
        int numRows;
        int[] Values;
        
        public TriangularArray(int numRows){
            int NumRows = numRows;
            Values = new int[NumRows*(NumRows-1)/2];
        }
        
        public int getIndex(int row, int column){
            return row*(row-1)/2+column;
        }
        
        public void setValue(int value,int index){
            Values[index] = value;
        }
        
        public int getValue(int index){
            return Values[index];
        }
        
    
    
    public static void main(String[] args){
        TriangularArray one = new TriangularArray(4);
        one.setValue(10, one.getIndex(2, 3));
        int result = one.getValue(one.getIndex(2,3));
        System.out.println("The result is: "+result);
    }
}
