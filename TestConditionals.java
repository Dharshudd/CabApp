import java.util.Scanner;
public class TestConditionals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mark;
		Scanner sc = new Scanner(System.in);
		mark=sc.nextInt();
		if(mark>0) {
			System.out.println("Valid Mark");
		}
		else {
			System.out.println("Invalid Mark");
		}
	}

}
