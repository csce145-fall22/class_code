
public class Day13Samples {
	
	public static void reverse(String[] ss) {
		int halfLength = ss.length/2;
		for(int i = 0; i<halfLength; ++i) {
			String temp = ss[i];
			int second = ss.length -1 -i;
			ss[i] = ss[second];
			ss[second] = temp;
		}
	}
	
	public static String[]  reverseCopy(String[] ss) {
		String[] newSS = new String[ss.length];
		int halfLength = ss.length/2;
		for(int i = 0; i<halfLength; ++i) {
			int second = ss.length -1 -i;
			newSS[i] = ss[second];
			newSS[second] = ss[i];
		}
		return newSS;
	}
	
	public static void print(String[] ss) {
		System.out.print("{");
		for(int i = 0; i<ss.length; ++i) {
			System.out.print(ss[i]);
			if(i<ss.length-1) System.out.print(", ");
		}
		System.out.println("}");
		
	}
	
	public static void main(String[] args) {
		String[] names = {"Alice", "Bob", "Chet","Fred", "Ted"};
		
		//System.out.print(names);
		print(names);
		
		System.out.println("Reversing");
//		reverse(names);
		print(reverseCopy(names));
		print(names);
	}
}
