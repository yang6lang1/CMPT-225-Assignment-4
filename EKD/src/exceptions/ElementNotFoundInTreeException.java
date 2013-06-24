/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author AlexYang
 */
public class ElementNotFoundInTreeException extends Exception 
{ 
    // Default constructor
    public ElementNotFoundInTreeException( ) 
    {
    } // end of constructor
    
    // Parameterized constructor
    public ElementNotFoundInTreeException( String msg )
    {
    	// Question: where is msg stored?
        super( msg );
        
    } // end of constructor
    
} // end of EmptyQueueException class 
