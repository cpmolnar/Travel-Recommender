/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Carl
 * @param <K>
 * @param <V>
 */
public interface Map<K,V> {

    /**
     *
     * @return
     */
    int size( );

    /**
     *
     * @return
     */
    boolean isEmpty( );

    /**
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     *
     * @param key
     * @param value
     * @return
     */
    V put(K key, V value);

    /**
     *
     * @param key
     * @return
     */
    V remove(K key);

    /**
     *
     * @return
     */
    Iterable<K> keySet( );

    /**
     *
     * @return
     */
    Iterable<V> values( );

    /**
     *
     * @return
     */
    Iterable<Entry<K,V>> entrySet( );
}
