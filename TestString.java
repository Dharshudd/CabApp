import java.util.Scanner;
public class TestString {

	public static void main(String[] args) {
		String FirstName;
		String LastName;
		Scanner sc = new Scanner(System.in);
		FirstName = sc.next();
		LastName = sc.next();
		int FirstLength = FirstName.length();
		int LastLength = LastName.length();
		String FullName = FirstName+" "+LastName;
		int FullLength = FullName.length();
		System.out.println(FirstName+" "+ FirstLength);
		System.out.println(LastName+" "+ LastLength);
		System.out.println(FullName+" "+FullLength);
	}

}
