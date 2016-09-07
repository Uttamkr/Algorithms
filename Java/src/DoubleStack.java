/*
 Double Stack Implementation using a 1D array

 * @author Uttam Kumar
 */

public class DoubleStack {
    static int[] StackStorage = new int[10];
    int nextLeft = 0;
    int nextRight = StackStorage.length -1;
    
    public void pushLeft(int value){
        if(nextLeft != nextRight){
            StackStorage[nextLeft++] = value;
        }else{
            System.out.println("Stack Storage Full");
        }
        
    }
    
    public void pushRight(int value){
        if(this.nextLeft != this.nextRight){
            StackStorage[this.nextRight--] = value;
        }else{
            System.out.println("Stack Storage Full");
        }
        
    }
    
    public int popLeft(){
        return StackStorage[--this.nextLeft];
    }
    
    public int popRight(){
        return StackStorage[++this.nextRight];
    }
    
    public static void main(String[] args){
        DoubleStack one = new DoubleStack();
        one.pushLeft(5);
        one.pushRight(10);
        
        System.out.println("Left: "+one.popLeft()+"\nRight: "+one.popRight());
    }
}
