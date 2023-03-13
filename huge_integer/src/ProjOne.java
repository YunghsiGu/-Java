import java.util.Scanner;

public class ProjOne {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HugeInteger A = new HugeInteger();
		HugeInteger B = new HugeInteger();
		String C = new String();
		String D = new String();
		
		System.out.println("Please input two huge integers:");
		A.parse(input.next());
		B.parse(input.next());
		
		A.toString();
		B.toString();
		System.out.println("Copies with type String have been built.");
		
		System.out.print("A + B = ");
		A.add(B);
		System.out.print("A - B = ");
		A.subtract(B);
		
		System.out.print("Is A equal to B? ");
		if (A.isEqualTo(B))
			System.out.println("yes");
		else if (A.isNotEqualTo(B))
			System.out.println("no");
		
		if (A.isGreaterThan(B)) 
			System.out.println("A > B");
		else if (A.isLessThan(B))
			System.out.println("A < B");
		
		if (A.isGreaterThanOrEqualTo(B))
			System.out.println("A >= B");
		if (A.isLessThanOrEqualTo(B))
			System.out.println("A <= B");
		
		if (A.isZero())
			System.out.println("A = 0");
		if (B.isZero())
			System.out.println("B = 0");
	}
}