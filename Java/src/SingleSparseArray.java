/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
public class SingleSparseArray {
    
    RowHead RowHeadSentinal = new RowHead(0);
    RowHead RowHeadBottomSentinal = new RowHead(12000);
    RowHead LastRow = RowHeadSentinal;
    
    

    
    
    class RowHead{
        int rowNumber;
        RowHead nextRow;
        ValueCell topValue = new ValueCell(0);
        ValueCell CellBottomSentinal = new ValueCell(12000);
        
        
        public RowHead(int row){
            this.rowNumber = row;
        }
    }
    
    void CreateRow(int row){
        RowHead temp  = new RowHead(row);
        RowHead Pointer = RowHeadSentinal;
        if(RowHeadSentinal.nextRow == null){                                        // If Row is empty
           RowHeadSentinal.nextRow = temp;
            temp.nextRow = RowHeadBottomSentinal;
        }else{
            Pointer = Pointer.nextRow;
            while(Pointer.nextRow.rowNumber < row){
                Pointer = Pointer.nextRow;
            }
            temp.nextRow = Pointer.nextRow;
            Pointer.nextRow = temp;
            temp.topValue.nextValue = temp.CellBottomSentinal;
        }
    }
    
    class ValueCell{
        int columnNumber;
        ValueCell nextValue;
        int value;
        
        public ValueCell(int value){
            this.columnNumber = value;
        }
    }
    
    int getValue(int row,int column){
        RowHead temp = new RowHead();
        while(temp.rowNumber != row){
            temp = temp.nextRow;
            if(temp == null)
                return 0;
        }
        
        ValueCell tempCell = temp.topValue;
        while(tempCell.columnNumber != column){
            tempCell = tempCell.nextValue;
            if(tempCell == null){
                return 0;
            }
        }
        
        
        return tempCell.value;
    }
    
    void setValue(int value,int row,int column){
        RowHead temp = RowHeadSentinal;
        while(temp.nextRow.rowNumber < row){
            temp = temp.nextRow;
        }
        //create row
        if(temp.nextRow.rowNumber > row){
            temp = new RowHead(row);
        }
        
        ValueCell tempCell = temp.topValue;
        ValueCell NewCell = new ValueCell(value);
        while(tempCell.nextValue.columnNumber < column){
            tempCell = tempCell.nextValue;
        }
        
        
        NewCell.nextValue = tempCell.nextValue;
        tempCell.nextValue = NewCell;
    }
    
    public static void main(String[] args){
        SingleSparseArray one = new SingleSparseArray();
        one.setValue(10, 1, 1);
        int res = one.getValue(1,1);
        System.out.println("The result is : "+res);
        
    }
}
