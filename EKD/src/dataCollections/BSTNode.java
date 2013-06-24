package dataCollections;


public class BSTNode<T> {

	private T element;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	//default constructor
	public BSTNode(){
		this(null,null,null);
	}
	
	//parameterized constructor
	public BSTNode(T theElement){
		this(theElement,null,null);
	}
	
	//parameterized constructor
	public BSTNode(T theElement,BSTNode<T> theLeft, BSTNode<T> theRight){
		element = theElement;
		left = theLeft;
		right = theRight;
	}
	
	//getters
	public T getElement(){
		return element;
	}
	
	public BSTNode<T> getLeft(){
		return left;
	}
	
	public BSTNode<T> getRight(){
		return right;
	}
	
	//setters
	public void setElement(T theElement){
		element = theElement;
	}
	
	public void setLeft(BSTNode<T> theLeft){
		left = theLeft;
	}
	
	public void setRight(BSTNode<T> theRight){
		right = theRight;
	}
}
