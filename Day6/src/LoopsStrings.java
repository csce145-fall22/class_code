import java.util.Scanner;

public class LoopsStrings {

	private static double avg2(double d1,double d2) {
		return (d1+d2)/2.0;
	}
	
	private static void print(String s) {
		System.out.println(s);
	}
	
	private static double average(double[] ds) {
		double sum = 0.0;
//		for(int i = 0;i<ds.length;++i) {
//			sum = sum + ds[i];
//		}
		int i = 0;
		while(i<ds.length) {
			sum = sum + ds[i];
			++i;
		}
		return sum/ds.length;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter 2 numbers");
//		double x1 = in.nextDouble();
//		double x2 = in.nextDouble();
//		in.nextLine();
		
//		System.out.println("The average is: "+avg2(x1,x2));
		
		double[] ds = {1,2,3,4,5,6,7};
		
		System.out.println("The average of ds is "+average(ds));
		
		String a = "abcdefghi";
		print("a="+a);
		String sub_a = a.substring(3);//FOURth character and rest
		print("sub_a="+sub_a);
		
		String sub_a2 = a.substring(3,6);//FOURth, fifth and sixth
		print("sub_a2="+sub_a2);
		
		String sub_a3 = a.substring(3,a.length() );//FOURth character and rest
		print("sub_a3="+sub_a3);
		
		String subseq_a = a.subSequence(4, 7).toString();
		print("subseq_a="+subseq_a);
		
		print("a.indexOf('e')="+a.indexOf('e'));
		
		String abcs0 = "abcbacaccabacabaca";
		
		String[] pieces = abcs0.split("c+");
		print("abcs0.length= "+abcs0.length() );
		for (int i = 0;i<pieces.length;++i) {
			print("piece "+i+": "+pieces[i]);
		}
		
		String ns = "1,2 ,3,4,5,6, 7 ,8 , 9, 10";
		String[] n_pieces = ns.split("\\s*,\\s*");
		double sum = 0;
		for (int i=0;i<n_pieces.length;++i) {
			print("n_pieces["+i+"]: "+n_pieces[i]);
			sum += Double.parseDouble(n_pieces[i]);
		}
		print("The average is "+ (sum/n_pieces.length) );

	}

}
