/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * A singly linked list. Each node contains an element of type T and a link to the next node.
 * @param <T> The object class contained within the list.
 * @author Carl
 */
public class SinglyLinkedList<T> {
    protected static class Node<T> {
        protected T element;
        protected Node<T> next;
        
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
        
        public T getElement( ) { 
            return element; 
        }
        
        public Node<T> getNext( ) { 
            return next; 
        }
        
        public void setNext(Node<T> next) { 
            this.next = next; 
        }
    }
    
    // instance variables of the SinglyLinkedList
    protected Node<T> head = null; // head node of the list (or null if empty)
    protected Node<T> tail = null; // last node of the list (or null if empty)
    protected int size = 0; // number of nodes in the list
    
    public SinglyLinkedList( ) { } // constructs an initially empty list
    
    // access methods
    public int size( ) { return size; }
    
    public boolean isEmpty( ) { return size == 0; }
    
    public T first( ) { // returns (but does not remove) the first element
        if (isEmpty( )) 
            return null;
        return head.getElement( );
    }
    
    public T last( ) { // returns (but does not remove) the last element
        if (isEmpty( ))
            return null;
        return tail.getElement( );
    }
    
    // update methods
    public void addFirst(T element) { // adds element e to the front of the list
        head = new Node<>(element, head); // create and link a new node
        if (size == 0)
            tail = head; // special case: new node becomes tail also
        size++;
    }
    
    public void addLast(T element) { // adds element e to the end of the list
        Node<T> newest = new Node<>(element, null); // node will eventually be the tail
        if (isEmpty( ))
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }
    
    public T removeFirst( ) { // removes and returns the first element
        if (isEmpty( )) 
            return null; // nothing to remove
        T answer = head.getElement( );
        head = head.getNext( ); // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    }
    
    /**
     * Removes the last element from the list.
     * This implementation is not efficient because it uses an assignment function 2n times
     * to find the element before the tail.
     * @return The element removed from the list.
     */
    public T removeLast( ) { // removes and returns the first element
        if (isEmpty( )) 
            return null; // nothing to remove
        T answer = tail.getElement( );
        
        Node<T> current = head;
        Node<T> previous = null;
        
        while(current != tail) {
            previous = current;
            current = current.getNext();
        }
        
        tail = previous; // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    }
}
