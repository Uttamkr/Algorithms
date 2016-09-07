/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
public class DoublyLinkedList {
    
    public static Node sentinal  = new Node(0);
    public static Node last = sentinal;
    public static Node bottom_sentinal = new Node(1000);
    
    public static class Node{
        private int value;
        private Node next;
        private Node prev;
        
        public Node(int value){
            this.value = value;
            this.next = this.prev = null;
        }
        
        public static void insertAtEnd(int value){
            Node cell = new Node(value);
            last.next = cell;
            last = cell;
            bottom_sentinal.prev = cell;
            cell.next = bottom_sentinal;
        }
        
        public static void insertAfterValue(int value,int newValue){
            Node cell = new Node(newValue);
            Node temp = sentinal.next;
            System.out.println("Inserting "+newValue+" after "+value);
            
            while(temp.value != value){
                temp = temp.next;
            }
            temp.next.prev = cell;
            cell.next = temp.next;
            temp.next = cell;
            cell.prev = temp;
            
            
        }
        public static void dispList(){
            Node temp = sentinal.next;
            while(temp != bottom_sentinal){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }
    
    public static void main(String[] args){
        Node.insertAtEnd(17);
        Node.insertAtEnd(16);
        Node.insertAtEnd(16);
        Node.insertAtEnd(12);
        Node.insertAtEnd(13);
        Node.insertAtEnd(14);
        Node.insertAtEnd(15);
        Node.dispList();
        
        Node.insertAfterValue(13, 25);
        Node.dispList();
        
    }
}
