package project1;

import java.util.*;

public class Project1Bonus {

	public static void main(String[] args) {
		// import number generator and scanners;
		Random generator = new Random();
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		// create integer and string variables and an array
		int winningNumbers, smallestNum, largestNum, range, numberLast, numberMatch;
		String userInput;
		int numbers[];
				
		do { 
			System.out.println("Welcome to the Raffle Winner Program!");
			
			// Ask how many winning numbers should be draw
			System.out.println("How many winning numbers should be draw? ");
			winningNumbers = scan.nextInt();
			while (winningNumbers <= 0) {
				if (winningNumbers < 0) {
					System.out.println("The number should be positive.");
				} else {
					System.out.println("The number should be bigger than 0.");
				}
				winningNumbers = scan.nextInt();
			}
			numbers = new int[winningNumbers];
						
			// Ask what is the smallest raffle number
			System.out.println("What is the smallest raffle number sold? ");
			smallestNum = scan.nextInt();
			while (smallestNum <= 0) {
				if (smallestNum < 0) {
					System.out.println("The number should be positive.");
				} else {
					System.out.println("The number should be bigger than 0.");
				}
				System.out.println("What is the smallest raffle number sold? ");
				smallestNum = scan.nextInt();
			}
			
			// Ask what is the largest raffle number
			System.out.println("What is the largest raffle number sold? ");
			largestNum = scan.nextInt();
			range = (largestNum - smallestNum) + 1;
			while (largestNum <= 0 || range < winningNumbers) {
				if (largestNum < 0){
					System.out.println("It needs to be a positive number.");
				} else if (largestNum == 0) {
					System.out.println("The number should be bigger than 0.");
				} else if (largestNum <= smallestNum) {
					System.out.println("The largest raffle number should be bigger than the smallest raffle number.");
				} else {
					System.out.println("At least " + winningNumbers + " tickets should be sold");
				}	
				System.out.println("What is the largestest raffle number sold? ");
				largestNum = scan.nextInt();
				range = (largestNum - smallestNum) + 1;
			}
					
			// drawing the winning numbers
			for (int i = 0; i < winningNumbers; i++) { 
				int numb = generator.nextInt(range) + smallestNum;			
				
				// check if the numbers repeated
				do {
					numberMatch = 0;
					for (int h = i; h > 0; h--) {
						numberLast = numbers[h-1];
						if (numberLast == numb) {
							numberMatch = 1;
							numb = generator.nextInt(range) + smallestNum;
						} else {
							continue;
						}
					}
				} while (numberMatch == 1);
		
				numbers[i] =numb;
			}
			
			// print the winning numbers
			System.out.print("The winning numbers are :");
			System.out.println(Arrays.toString(numbers));
			
			System.out.println("Do you want to play again? Y / N" );
			userInput = scan1.nextLine();
			
		} while(userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("Y"));	
	}
}
