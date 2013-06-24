package app;

//Description: the KeyedItem will contain the search key as a data field
//and a method for accessing the search key
public abstract class KeyedItem<KT extends Comparable<? super KT>> {

	private KT searchKey;
	
	public KeyedItem(KT key){
		searchKey = key;
	}

	public void updataKey(KT key){
		searchKey = key;
	}
	
	public KT getKey(){
		return searchKey;
	}
}

