/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import Interfaces.Stack;

public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>( ); // an empty list
    
    public LinkedStack( ) { } // new stack relies on the initially empty list
    
    @Override
    public int size( ) { return list.size( ); }
    
    @Override
    public boolean isEmpty( ) { return list.isEmpty( ); }
    
    @Override
    public void push(E element) { list.addFirst(element); }
    
    @Override
    public E top( ) { return list.first( ); }
    
    @Override
    public E pop( ) { return list.removeFirst( ); }
}