/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author AlexYang
 */
public class EmptyTreeException extends Exception 
{ 
    // Default constructor
    public EmptyTreeException( ) 
    {
    } // end of constructor
    
    // Parameterized constructor
    public EmptyTreeException( String msg )
    {
    	// Question: where is msg stored?
        super( msg );
        
    } // end of constructor
    
} // end of EmptyQueueException class 
