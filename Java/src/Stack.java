/*
 Implementation of a Stack Push/Pop functionalities using a Singly Linked List
 *
 * @author Uttam Kumar
 */
public class Stack {
    
    Cell TopSentinal = new Cell(0);
    
    public class Cell{
        int value;
        Cell next;
        
        public Cell(int value){
            this.value = value;
            this.next = null;
        }
        
    }
        public void Push(int value){
            Cell temp = new Cell(value);
            
            temp.next = TopSentinal.next;
            TopSentinal.next = temp;
        }
        
        public int Pop(){
            int returnVal = TopSentinal.next.value;
            
            TopSentinal.next = TopSentinal.next.next;
            
            return returnVal;
        }
    
    
    public static void main(String[] args){
        Stack one = new Stack();
        one.Push(5);
        one.Push(19);
        
        System.out.println("Top: "+ one.Pop()+"\nSecond: "+one.Pop());
    }
}
