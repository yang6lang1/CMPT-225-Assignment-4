package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import dataCollections.MyBST;
import exceptions.ElementAlreadyExistsException;
import exceptions.ElementNotFoundInTreeException;
import exceptions.EmptyTreeException;


public class EKD{
	final static int QUIT = 0;

	private MyBST<WordPair,String> dictionary;
	private Scanner theKbd;
	
	//Constructor
	public EKD(){
		dictionary = new MyBST<WordPair,String>();
		theKbd = new Scanner(System.in);
		System.out.println("-----------------------------------------------------");
		System.out.println("      Welcome to the English-Klingon Dictionary      ");
		System.out.println("-----------------------------------------------------");


	}
	
	//Getter
	private MyBST<WordPair,String> getDictionary(){
		return dictionary;
	}
	
	//Menus
	private void mainMenu() {
		System.out.println("\n-----------------------------------------------------");

		System.out.println("    Translate English word into Klingon\t- Enter 1");
		System.out.println("    Insert a new pair of words\t        - Enter 2");
		System.out.println("    Update an existing pair of words\t- Enter 3");
		System.out.println("    Remove an existing pair of words\t- Enter 4");
		System.out.println("    Display all pairs of words in");
		System.out.println("    English alphabetical order\t\t- Enter 5");
		System.out.println("    Exit\t\t\t\t- Enter 0");

		System.out.println("-----------------------------------------------------");

		System.out.print("Select menu option: ");
		return;
	}

	private void selectInputFile() {
		System.out.println("\n-----------------------------------------------------");

		System.out.println("    Please select one of the input files listed:");
		System.out.println("    inputFile1.txt\t\t- Enter 1");
		System.out.println("    inputFile1.txt\t\t- Enter 2");
		System.out.println("    inputFile1.txt\t\t- Enter 3");
		System.out.println("    inputFile1.txt\t\t- Enter 4");

		System.out.println("-----------------------------------------------------");

		System.out.print("Select menu option: ");
		return;
	}

	private void translation() {
		System.out.print("\nPlease enter the English word: ");
		String englishWord="";
		String klingonWord="";
		englishWord =this.readString("");
		englishWord = englishWord.toLowerCase().trim();
		WordPair theWordPair = new WordPair(englishWord,null);
		try{
			klingonWord =(this.getDictionary().retrieve(theWordPair)).getKlingon();
			
			System.out.print("\nThe English word you entered is:\t" + englishWord);
			System.out.print("\nThe correspoinding Klingon word is:\t"+klingonWord);
		}catch(EmptyTreeException e){
			//TODO
		}catch(ElementNotFoundInTreeException e){
			//TODO
			System.out.print("\n***Cannot find the word in the dictionary***");
			this.translation();
		}

		return;
	}

	private void bankOperations() {
		System.out.println("\nOpen a new account\t  - Enter 6");
		System.out.println("Close an existing account - Enter 7");
		System.out.println("Display all accounts\t  - Enter 8" );
		// Would be nice to have ... (perhaps next version)
		// System.out.println( "Search for an account - Enter ?" );
		System.out.println("Previous menu\t\t  - Enter 0" );
		System.out.print("\nYour selection is: ");
		return;
	}

/*
 * IO methods
 */

	private int readSelection() {

		int userSelection = QUIT;

		userSelection = this.readInt("");
		// Echo user selection:
		System.out.println("Your selection entered as: " + userSelection);
		return userSelection;
	}

	private String readString(String userInstruction) {

		String aString = null;

		try {
			System.out.print(userInstruction);
			aString = theKbd.nextLine();
		} catch (NoSuchElementException e) {
			//if no line was found
			System.out.println("\nNoSuchElementException error occurred (no line was found) " + e);
		} catch (IllegalStateException e) {
			// if this scanner is closed
			System.out.println("\nIllegalStateException error occurred (scanner is closed)" + e);
		}

		return aString;
	}

	private int readInt(String userInstruction) {

		int aInt = -1;
		
		try {
			System.out.print(userInstruction);
			aInt = theKbd.nextInt();
			theKbd.nextLine();
		} catch (InputMismatchException e) {
		//	System.out.println("\nInputMismatchException error occurred (the next token does not match the Integer regular expression, or is out of range) " + e);
			System.out.println("\n***Invalid input!***");
			System.out.print("Input cannot be special symbols and characters.\nPlease enter again: ");
			theKbd.nextLine();
			return this.readInt("");
			
		} catch (NoSuchElementException e) {
			System.out.println("\nNoSuchElementException error occurred (input is exhausted)" + e);
		} catch (IllegalStateException e) {
			System.out.println("\nIllegalStateException error occurred (scanner is closed)" + e);
		}

		return aInt;

	}

	private double readDouble(String userInstruction) {

		double aDouble = 0;

		try {
			System.out.print(userInstruction);
			aDouble = theKbd.nextDouble();
			theKbd.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("\nInputMismatchException error occurred (the next token does not match the Integer regular expression, or is out of range) " + e);
		} catch (NoSuchElementException e) {
			System.out.println("\nNoSuchElementException error occurred (input is exhausted)" + e);
		} catch (IllegalStateException e) {
			System.out.println("\nIllegalStateException error occurred (scanner is closed)" + e);
		}

		return aDouble;

	}

	private void readFile(String fileName){

        BufferedReader fileInBR = null;
        Scanner fileInput = null;
        String newLine = null;
        WordPair newWordPair = null;

		System.out.println("\nLoading data from: "+fileName+ "...");
	
        try {
            fileInBR = new BufferedReader(new FileReader(fileName));
       }
       catch (FileNotFoundException e) { 
			System.out.println("\n***Invalid option!***");
			System.out.print("    Please select one of the following input sources:");
			this.loadData();
			return;

       }

       fileInput = new Scanner(fileInBR);

       while(fileInput.hasNextLine())
       {
    	   newLine = fileInput.nextLine();
    	   String[] pair =newLine.split(":");
    	   newWordPair = new WordPair(pair[0],pair[1]);
    	   //load word pairs into the dictionary
    	   try{    		  
    		   this.getDictionary().insert(newWordPair);
    	   }catch(ElementAlreadyExistsException e){
               System.out.println( "Exception: " + e );
    	   }
    	   
    	   //testing if the inputFile is successfully loaded:
           //System.out.println(newWordPair.toString());

       }
       
       System.out.println("Loading completed!");
   
		return;

	}
	
	private void loadData(){
		int userSelection = QUIT;
        String fileName ="";

		this.selectInputFile();
		userSelection = this.readSelection();
		switch(userSelection){
			case 1:
				fileName="inputFile1.txt";
			break;
			
			case 2:
				fileName="inputFile2.txt";
			break;
			
			case 3:
				fileName="inputFile3.txt";
			break;
			
			case 4:
				fileName="inputFile4.txt";
			break;
		}
		
		this.readFile(fileName);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EKD theEKD = new EKD();
		int userSelection = QUIT;

		theEKD.loadData();
		theEKD.mainMenu();
		userSelection = theEKD.readSelection();
		
		// While user has not selected QUIT
		while (userSelection != QUIT) {
			//if(userSelection>-1 &&userSelection <6){
			
				switch (userSelection) {
				// If user selected Customer Operations
				case 1:
					// Display translation menu
					theEKD.translation();
					userSelection = theEKD.readSelection();
					break;
					
				default:
					//out of option
					System.out.println("\n***Invalid option!***");
					System.out.print("    Please select one of the following operations:");
					theEKD.mainMenu();
					userSelection = theEKD.readSelection();
					break;
		
			}
		}
		// Exit		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("                        Bye!");
		System.out.println("-----------------------------------------------------");

	}

}
