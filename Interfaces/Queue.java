/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Travel.AbstractTravelDestination;

/**
 * A queue implementation. Stores elements that can be enqueued (added) and dequeued (removed).
 * @param <E> The type of the element stored in the queue.
 */
public interface Queue<E> extends Cloneable {
    /**
     * Returns the number of elements in the queue.
     * @return The number of elements in the queue.
     */
    int size( );
    
    /**
     * Returns whether the queue is empty.
     * @return True if the queue is empty.
     */
    boolean isEmpty( );
    
    /**
     * Inserts an element at the front of the queue.
     * @param e The element to insert in the queue.
     */
    void enqueue(E e);
    
    /**
     * Returns the first element in the queue.
     * @return The first element in the queue.
     */
    E first( );
    
    /**
     * Returns and removes the first element in the queue.
     * @return The element removed from the queue.
     */
    E dequeue();
}