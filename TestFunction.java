import java.util.Scanner;

public class TestFunction {

	public static void display(String name) {
		System.out.println("My name is " + name);
	}
	
	public static void displayNumber(int first,int second) {
		int sum=first+second;
		System.out.println("The sum of the numbers is "+sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first,second;
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		display(name);
		first=sc.nextInt();
		second=sc.nextInt();
		displayNumber(first,second);
		
	}

}
