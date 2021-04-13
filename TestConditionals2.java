
import java.util.Scanner;
public class TestConditionals2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String grade = null;
		int mark;
		Scanner sc = new Scanner(System.in);
		mark=sc.nextInt();
		
		if(mark>50)
			grade = "A";
		else
			grade = "B";
		System.out.println(mark+" "+grade);
	}

}
