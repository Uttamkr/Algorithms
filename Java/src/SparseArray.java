/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
public class SparseArray {
    
    RowHead RowHeadSentinal = new RowHead(0);                                     // Sentinals for Row Heads
    RowHead RowHeadBottomSentinal = new RowHead(12000);
    RowHead RowHeadLast = RowHeadSentinal;
    
    
    ColumnHead ColumnHeadSentinal = new ColumnHead(0);                            // Sentinals for Column Heads
    ColumnHead ColumnHeadBottomSentinal = new ColumnHead(12000);
    
    /*
    Cell CellRowSentinal = new Cell(0);
    Cell CellRowBottomSentinal = new Cell(12000);
    
    Cell CellColumnSentinal = new Cell(0);
    Cell CellColumnBottomSentinal = new Cell(12000);
    
    */
    class RowHead{
        int rowNumber;
        RowHead nextRowHead;
        Cell TopValue;
        
        public RowHead(int row){
            this.rowNumber = row;
            this.nextRowHead = null;
        }
        
        public void CreateRowHead(int row){
            RowHead temp = new RowHead(row);
            
            RowHead Pointer = RowHeadSentinal.nextRowHead;
            
            if(Pointer == null){
                RowHeadSentinal.nextRowHead = temp;
                RowHeadLast = temp;
                return;
            }
            
            while(Pointer.rowNumber < row){                                                      // Place row at required place
                Pointer = Pointer.nextRowHead;
            }
            
            if(Pointer.nextRowHead == null){
                Pointer.nextRowHead = RowHeadBottomSentinal;
            }
            
            temp.nextRowHead = Pointer.nextRowHead;
            Pointer.nextRowHead = temp;
        }
    }    
    
    class ColumnHead{
        int columnNumber;
        ColumnHead nextColumnHead;
        Cell TopValue;
        
        public ColumnHead(int col){
            this.columnNumber = col;
            this.nextColumnHead = null;
        }
        
        public void CreateColumnHead(int col){
            ColumnHead temp = new ColumnHead(col);
            ColumnHead Pointer = ColumnHeadSentinal.nextColumnHead;
            
            while(Pointer.nextColumnHead.columnNumber < col){                                                      // Place Column at required place
                Pointer = Pointer.nextColumnHead;
            }
            if(Pointer.nextColumnHead == null){
                Pointer.nextColumnHead = ColumnHeadBottomSentinal;
            }
            temp.nextColumnHead = Pointer.nextColumnHead;
            Pointer.nextColumnHead = temp;
        }
        
    }
    
    public class Cell{
        int value;
        Cell nextRowCell;
        int rowNo;
        int colNo;
        Cell nextColumnCell;
        
        public Cell(int data){
            this.value = data;
            this.nextRowCell = null;
            this.rowNo = this.colNo = 0;
            this.nextColumnCell = null;
        }
        

    }
    
        public void CreateCell(int data,int row,int col){
            
            RowHead tempRow = RowHeadSentinal.nextRowHead;
        
            if(RowHeadSentinal.nextRowHead == null){
                tempRow.CreateRowHead(row);
            }else{

                while(tempRow.rowNumber != row){                                                   // Find the specified Row
                    tempRow = tempRow.nextRowHead;

                    if(tempRow.nextRowHead == RowHeadBottomSentinal){                                           //  specified row is not found
                        System.out.println("Cannot Find the specified Row number");

                    //Create Row 
                    tempRow.CreateRowHead(row);

                    }
                }
            }
            
            ColumnHead tempCol = ColumnHeadSentinal.nextColumnHead;
            
            while(tempCol.columnNumber != col){                                                   // Find the specified Row
                tempCol = tempCol.nextColumnHead;
                
                if(tempCol.nextColumnHead == ColumnHeadBottomSentinal){                                           //  specified row is not found
                    System.out.println("Cannot Find the specified Column number");
                    
                //Create Column 
                tempCol.CreateColumnHead(col);
                    
                }
            }
            
            
            //assign row and column links
            
            Cell temp = new Cell(data);
            temp.colNo = col;
            temp.rowNo = row;
            
            Cell tempCell = tempRow.TopValue.nextRowCell;
            
            while(tempCell.nextRowCell.rowNo != row-1){
                tempCell = tempCell.nextRowCell;
            }
            
            temp.nextRowCell = tempCell.nextRowCell;
            
            tempCell = tempCol.TopValue.nextColumnCell;
            
            while(tempCell.nextColumnCell.colNo != row-1){
                tempCell = tempCell.nextColumnCell;
            }
            
            temp.nextColumnCell = tempCell.nextColumnCell;
        }
        
    
    public int getValue(int row,int col){
        RowHead temp = RowHeadSentinal.nextRowHead;
        
        while(temp.rowNumber != row){                                                   // Find the specified Row
            temp = temp.nextRowHead;
            if(temp == RowHeadBottomSentinal){
                System.out.println("Cannot Find the specified Row number");
                return -1;
            }
        }
        
        Cell tempCell = temp.TopValue;
        
        while(tempCell.colNo != col){                                                   // Find the specified Row
            tempCell = tempCell.nextColumnCell;
            if(tempCell.nextColumnCell == null){
                System.out.println("Cannot Find the specified Column number");
                return -1;
            }
        }
              
        return tempCell.value;
    }
    
    public static void main(String[] args){
        SparseArray one = new SparseArray();
        one.CreateCell(10, 1, 1);
        int res = one.getValue(1, 1);
        System.out.println("The result is "+res);
    }
    
}
