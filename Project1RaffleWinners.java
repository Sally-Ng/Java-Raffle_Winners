package project1;

import java.util.Random;
import java.util.Scanner;

public class Project1RaffleWinners {

	public static void main(String[] args) {
		// import number generator and scanners;
		Random generator = new Random();
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
			
		// create integer and string variable 
		int smallestNum, largestNum, range, winningNum1, winningNum2, winningNum3;
		String userInput;
			
		do { 
			System.out.println("Welcome to the Raffle Winner Program!");
			
			// Ask what is the smallest raffle number
			System.out.println("What is the smallest raffle number sold? ");
			smallestNum = scan.nextInt();
			while (smallestNum <= 0) {
				if(smallestNum < 0) {
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
			while (largestNum <= 0 || range < 2) {
				if(largestNum < 0){
					System.out.println("It needs to be a positive number.");
				} else if(largestNum == 0) {
					System.out.println("The number should be bigger than 0.");
				} else if(largestNum <= smallestNum) {
					System.out.println("The largest raffle number should be bigger than the smallest raffle number.");
				} else {
					System.out.println("Three or more tickets should be sold");
				}	
				System.out.println("What is the largestest raffle number sold? ");
				largestNum = scan.nextInt();
				range = (largestNum - smallestNum) + 1;
			}
				
			// drawing the winning numbers
			winningNum1 = generator.nextInt(range) + smallestNum;
			System.out.println("The first winning number is " + winningNum1 + " !");
				
			winningNum2 = generator.nextInt(range) + smallestNum;
			while (winningNum2 == winningNum1){
				winningNum2 = generator.nextInt(range) + smallestNum;
			}
			System.out.println("The second winning number is " + winningNum2 + " !");
				
			winningNum3 = generator.nextInt(range) + smallestNum;
			
			// check if the numbers repeated
			while (winningNum1 == winningNum3 && winningNum2 == winningNum1){
				winningNum3 = generator.nextInt(range) + smallestNum;
			}
			System.out.println("The third winning number is " + winningNum3 + " !");
			
			System.out.println("Do you want to play again? Y / N" );
			userInput = scan1.nextLine();
				
		} while(userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("Y"));	
	}
}

