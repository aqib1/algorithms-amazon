import java.util.Scanner;

public class BalkessTask {
	public static void main(String[] args) {
		System.out.print("Please enter your input here => ");
		try (Scanner scanner = new Scanner(System.in)) {
			int input = scanner.nextInt();
			printConstraintsByInput(input);
		}
	}

	private static void printConstraintsByInput(int input) {
		if(input < 1 || input > 100) {
			throw new IllegalArgumentException("*constraint 1<=n<=100 range");
		}
		if(!isEven(input)) {
			System.out.println("Weird");
		} else {
			if(input >=2 && input <=5) {
				System.out.println("Not Weird");
			} else if(input >=6 && input <= 20) {
				System.out.println("Weird");
			} else {
				System.out.println("Not Weird");
			}
		}
	}

	private static boolean isEven(int input) {
		return input % 2 == 0;
	}
}
