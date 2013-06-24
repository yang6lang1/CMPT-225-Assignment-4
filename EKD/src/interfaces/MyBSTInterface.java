/**
 * Filename: MyQueueInterface.java
 * Author: AL
 * Student Number:
 * Lab:
 * Date of creation: June 2012
 * Description: Java interface of a Queue
 */

package interfaces;

import exceptions.*;
import app.KeyedItem;

public interface MyBSTInterface<T extends KeyedItem<KT>,KT extends Comparable<? super KT>> {

	public T retrieve(T element) 
			throws ElementNotFoundInTreeException,EmptyTreeException;
	// Description: Finds, in the BST, the element that matches the search key value(s) of 
    //			 	the parameter element and returns it. element is a dummy element.
    // Precondition: BST is not empty and the element exists in the BST.
    // Postcondition: The BST is not modified.
	// Exception: Throws the exception EmptyTreeException if the BST is empty.
	// Exception: Throws the exception ElementNotFoundInTreeException if element is not 
    //            found in the BST.
	
	public void insert(T element) throws ElementAlreadyExistsException;

	// Description Inserts an element into a BST. Each element in the BST has a
    //             distinctunique search key.
    // Precondition: element is not already in the BST. No duplicated elements allowed.
    // Postcondition: If element does not already exist in the BST, then it
    //                has been added to the BST at its proper location, based on
    //                the element's search key. Otherwise, an exception is thrown.
	// Exception: Throws the exception ElementAlreadyExistsException if element is 
    //            already exists in the BST.

	public void remove(T element)
			throws ElementNotFoundInTreeException,EmptyTreeException;
	// Description: Removes, from the BST, the element that matches the search key value(s)
	//				of the parameter element. element is a dummy element.
	// Precondition: BST is not empty and the element exists in the BST.
	// Exception: Throws the exception EmptyTreeException if the BST is empty.
	// Exception: Throws the exception ElementNotFoundInTreeException if element is not 
	//            found in the BST.
		
	public void removeAll();
	// Description Removes all elements from the BST.
	// Postcondition BST is empty.
	
	public int size();
	// Description: Returns the number of elements currently stored in the BST.
	// Postcondition: Returns 0 if empty otherwise returns the number of elements.
}