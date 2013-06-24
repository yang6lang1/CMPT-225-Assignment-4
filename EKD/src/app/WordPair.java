package app;

//import interfaces.Listable;

//in this class, the key value is the english word
public class WordPair extends KeyedItem<String>{
	final static String INIT_ENGLISH="";
	final static String INIT_KLINGON="";
	
//	private String english;
	private String klingon;
	
	//Default constructor
	public WordPair(){
		this(INIT_ENGLISH,INIT_KLINGON);
	}
	
	//parameterized constructor
	public WordPair(String englishWord, String klingonWord){
		super(englishWord);
		klingon = klingonWord;
	}
	
	//setters
	public void setWordPair(String englishWord, String klingonWord){
		super.updataKey(englishWord);
		klingon = klingonWord;
	}
	
	//getters
	public String getEnglish(){
		return super.getKey();
	}
	
	public String getKlingon(){
		return klingon;
	}
	
	public String toString()
	{
		return (super.getKey() +":"+klingon);
	}
	
/*	// Description: method that decided whether this object is equal to, > than or < than otherObject
	// Postcondition: returns 0 if both objects match (are equal)
	// returns 1 if this object > otherObject
	// returns -1 if this object < otherObject
	public int compareTo(Listable otherObject){
		int result = -1;
		int compare = (english.compareToIgnoreCase(((WordPair)otherObject).getEnglish()));
		
		if(compare ==0){
			result = 0;
		}
		
		if(compare <0){
			result =-1;
		}
		
		if(compare >0){
			result =1;
		}
		
		return result;
	}*/
	

}
