/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/** Interface for a key-value pair.
 * @param <K>
 * @param <V> */
public interface Entry<K,V> {

    /**
     *
     * @return
     */
    K getKey( ); // returns the key stored in this entry

    /**
     *
     * @return
     */
    V getValue( ); // returns the value stored in this entry
}