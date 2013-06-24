package practice;

public class practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = "Alex";
		String string2 = "Bob";
		String string3 = "Al";
		
		int result;
		result = string1.compareToIgnoreCase(string2);
		System.out.println(result);
		result = string1.compareToIgnoreCase(string3);
		System.out.println(result);
	}

}
