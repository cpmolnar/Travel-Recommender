/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Comparators.TravelDestinationComparator;
import Interfaces.Queue;
import Interfaces.Stack;
import java.util.Comparator;

/**
 * Class containing various sort algs
 * @author Carl
 * @param <K> Type contained in the sorting alg
 */
public class Sort<K> {
    
    /** 
     * Merge contents of sorted queues S1 and S2 into empty queue S. 
     * @param <K> Type contained in the queue
     * @param S1 First queue to merge
     * @param S2 Second queue to merge
     * @param S Queue to merge into
     * @param comp Comparator for comparing elements
     */
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {
        while (!S1.isEmpty( ) && !S2.isEmpty( )) {
            if (comp.compare(S1.first( ), S2.first( )) < 0)
                S.enqueue(S1.dequeue( )); // take next element from S1
            else
                S.enqueue(S2.dequeue( )); // take next element from S2
        }
        while (!S1.isEmpty( ))
            S.enqueue(S1.dequeue( )); // move any elements that remain in S1
        while (!S2.isEmpty( ))
            S.enqueue(S2.dequeue( )); // move any elements that remain in S2
    }

    /** 
     * Merge-sort contents of queue. 
     * @param <K> Type contained in the queue
     * @param S Queue to sort
     * @param comp comparator for comparing elements
     */
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size( );
        if (n < 2) return; // queue is trivially sorted
        
        // divide
        Queue<K> S1 = new LinkedQueue<>( ); // (or any queue implementation)
        Queue<K> S2 = new LinkedQueue<>( );
        
        while (S1.size( ) < n/2)
            S1.enqueue(S.dequeue( )); // move the first n/2 elements to S1
        while (!S.isEmpty( ))
            S2.enqueue(S.dequeue( )); // move remaining elements to S2
        
        // conquer (with recursion)
        mergeSort(S1, comp); // sort first half
        mergeSort(S2, comp); // sort second half
        // merge results
        merge(S1, S2, S, comp); // merge sorted halves back into original
    }
    
    /** 
     * Quick-sort contents of a queue.
     * @param <K> Type contained in the queue
     * @param S Queue to sort
     * @param comp comparator for comparing elements
     */
    public static <K> void quickSort(Queue<K> S, TravelDestinationComparator comp) {
        int n = S.size( );
        if (n < 2) return; // queue is trivially sorted
        
        // divide
        K pivot = S.first( ); // using first as arbitrary pivot
        Queue<K> L = new LinkedQueue<>( );
        Queue<K> E = new LinkedQueue<>( );
        Queue<K> G = new LinkedQueue<>( );
        while (!S.isEmpty( )) { // divide original into L, E, and G
            K element = S.dequeue( );
            double c = comp.similarity(pivot) - comp.similarity(element);
            if (c < 0) // element is less than pivot
                L.enqueue(element);
            else if (c == 0) // element is equal to pivot
                E.enqueue(element);
            else // element is greater than pivot
                G.enqueue(element);
        }
        // conquer
        quickSort(L, comp); // sort elements less than pivot
        quickSort(G, comp); // sort elements greater than pivot
        // concatenate results
        while (!L.isEmpty( ))
            S.enqueue(L.dequeue( ));
        while (!E.isEmpty( ))
            S.enqueue(E.dequeue( ));
        while (!G.isEmpty( ))
            S.enqueue(G.dequeue( ));
    }
    
    /**
     * Runs a quick sort across all comparators from least to most important
     * @param <K> Type contained in the queue
     * @param S Queue to sort
     * @param comps comparators for comparing elements
     */
    public static <K> void multikeySort(Queue<K> S, Stack<TravelDestinationComparator> comps) {
        while(!comps.isEmpty()) {
            quickSort(S, comps.pop());
        }
    }
}
