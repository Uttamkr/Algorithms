/*
 **  **
 * @author Uttam Kumar
 */
public class SinglyLinkedList {
    
    public static Node sentinal = new Node(0);
    public static Node last = sentinal;
    static Node bottom_sentinal = new Node(1000);                                          // Inserting a bottom sentinal
    
    protected static class Node{
        private int value;
        private Node next;
        
        public Node(int data){
            this.value = data;
        }
        
        public static void insert(int data){                                               // Insert at the end of the linked list
            Node cell = new Node(data);
            cell.next = bottom_sentinal;
            last.next = cell;
            last = cell;
            
        }
        
        public static void dispList(){                                                     // Display the contents of the list
            Node temp = sentinal.next;
            while(temp != bottom_sentinal){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
        
        public static void insertAfterValue(int value,int newVal){                                  //Insert after a given value
            Node temp = sentinal.next;
            while(temp.value != value){
                temp = temp.next;
                last = temp;
            }
            temp = temp.next;
            Node cell = new Node(newVal);
            last.next = cell;
            cell.next = temp;
            
            System.out.println("Inserting "+newVal+" after "+value+".");
            Node.dispList();
        }
        
        public static void sortedInsert(int val){                                                   //Insert into Linked list in a sorted order
            Node temp = sentinal.next;
            while(true){                                                                  // Loop is not required as list has a botom sentinal
                if((temp.value < val) && (temp.next.value > val)){
                    last = temp;
                    Node.insertAfterValue(temp.value,val);
                    return;
                }
                temp = temp.next;
            }
        }
        
        public static void deleteFromLast(){
            Node temp = sentinal.next;
            while(temp.next.next != bottom_sentinal){
                temp = temp.next;
            }
            temp.next = bottom_sentinal;
            System.out.println("List after deleting the last cell :");
            Node.dispList();
        }
        
        
        
        
    }                                                                                       // End of Class Node
    
    public static void main(String[] args){
        
        Node.insert(10);
        Node.insert(11);
        Node.insert(12);
        Node.insert(13);
        Node.insert(14);
        
        Node.insert(16);
        Node.insert(17);
        Node.insert(18);
        
        Node.dispList();
        
        Node.insertAfterValue(12,12);
        
        
        int value = 15;
        Node.sortedInsert(value);
        
        Node.deleteFromLast();
        
        
    }
}
