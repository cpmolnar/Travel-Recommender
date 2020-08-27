/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * An Interface for element-containing Positions.
 * @param <E> The object contained in the position
 */
public interface Position<E> {
    /**
    * Returns the element stored at this position.
    *
    * @return the stored element
    * @throws IllegalStateException if position no longer valid
    */
    E getElement( ) throws IllegalStateException;
}