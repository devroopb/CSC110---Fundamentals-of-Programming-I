/*Name: Devroop Banerjee
Student ID:V00837868
Name of Program: ChuckALuck.java
Input: scanner, randomObject
Output: Dice rolls, amount of money won/lost, bet number, amount of money left
Purpose: To play a game of Chuck A Luck using a random number generator as a dice
*/

import java.util.Scanner;
import java.util.Random;

public class ChuckALuck {
    public static void main(String[]args){
    	Scanner scan = new Scanner(System.in);
    	Random rand = new Random(System.currentTimeMillis());
        Play(scan,rand);
    }

/*Name: Play
Purpose: to play the chuck a luck game
Input: Scanner scanner, to collect input from the user for the bet amount and if they want to continue playing Random randomObject, to simulate dice roll
Output: prompts to ask user for bet and updates of bankroll
 */
    public static void Play(Scanner scanner, Random randomObject) {
        double bankroll = Money(scanner);
        boolean playAgain = true;
        int betNumber = 1;

        while(playAgain){
            double bet = bet(scanner,bankroll);
            int number = Number(scanner);
            int rollOne = random(randomObject);
            int rollTwo = random(randomObject);
            int rollThree = random(randomObject);
            diceRoll(rollOne, rollTwo, rollThree);
            double winnings = win(rollOne, rollTwo, rollThree, number, bet, bankroll);
            bankroll = newBankroll(winnings, bankroll, bet);
            playAgain = playAgain(bankroll,scanner); 
            if(playAgain){
                System.out.println("After bet #" + betNumber + " your bankroll is $" + bankroll);
                betNumber +=1;
            }else{
                System.out.println("After bet #" + betNumber + " your bankroll is $" + bankroll);
                betNumber +=1;
            }    
        }
    }
          
/*Name: Money
Purpose: Asks user how much money he/she wants o start the game with and checks validity of data input
Input: Scanner, to collect input from user
Output: none
*/
    public static double Money(Scanner scanner) {
        System.out.print("How much do you want to add to your bankroll? ");
        checkForDouble(scanner);
        double bankroll = scanner.nextDouble();
        while(bankroll < 0) {
            System.out.println("Sorry, that's an invalid number, please enter a positive number");
            bankroll = scanner.nextDouble();
        }
        return bankroll;
    }
     
/*Name: bet
Purpose: asks user to place bet amount and checks validity of data input
Input: scanner, to input value from user; value of bankroll
Output: none
*/
    public static double bet(Scanner scanner, double bankroll){
        System.out.println("");
        System.out.print("What is the value of your next bet? ($0.00- $" + bankroll + ") ");
        checkForDouble(scanner); 
        double bet = scanner.nextDouble();
        while(bet < 0) {
            System.out.println("Sorry, that's an invalid number, please enter a positive number");
            bet = scanner.nextDouble();
        }
        while (bet > bankroll) {
            System.out.println("Sorry, you don't have that much to bet. Please enter a value within your bankroll.");
            bet = scanner.nextDouble();
        }
        while(bet < 0) {
            System.out.println("Sorry, that's an invalid number, please enter a positive number");
            bet = scanner.nextDouble();
        }
        while(bet == 0){
            System.out.println("Please enter a valid bet amount!");
            bet = scanner.nextDouble();
        }
        return bet;
    }
     
/*Name: Number
Purpose: asks user to input a number between 1 and 6 and checks validity of data input
Input: scanner, to input guess from user
Output: none
*/
    public static int Number(Scanner scanner) {
        System.out.print("Choose a number between 1 and 6: ");
        checkForInt(scanner);
        int number = scanner.nextInt(); 
        while (number > 6 || number <= 0) {
            System.out.print("Sorry, that choice is not within the numbers specified. Please choose a new one.");
            checkForInt(scanner);
            number = scanner.nextInt();
        }
        return number;
    }
     
/*Name: random 
Purpose: generates 3 random numbers between 1 to 6 as the outcomes of the dice rolls
Input: randomObject, to generate random values as dice rolls
Output: none
*/
    public static int random(Random randomObject) {
        int rollOne = randomObject.nextInt(6)+1;
        int rollTwo = randomObject.nextInt(6)+1;
        int rollThree = randomObject.nextInt(6)+1;
        return rollOne;
    }
     
/*Name: diceRoll
Purpose: prints out the random numbers generated as dice roll outcomes
Input: numbers from random number generator
Output: prints out the dice roll values
*/
    public static void diceRoll(int rollOne, int rollTwo, int rollThree) {
        System.out.print("Dice rolls:  ");
        System.out.println(rollOne + " " + rollTwo + " " + rollThree);
    }
     
/*Name: win
Purpose: calculates the amount won according to the number of dice roll values matching the player's guess
Input: values from dice rolls, number guesed, the bet amount placed, and the current bankroll value 
Output: none 
*/
    public static double win(int rollOne, int rollTwo, int rollThree, int number, double bet, double bankroll) {
        double winnings = 0.0;
        if (number == rollOne && number == rollTwo && number == rollThree) {
            winnings = bet*10;
        } else if (number == rollOne && number == rollTwo || number == rollOne && number == rollThree || number == rollTwo && number == rollThree) {
            winnings = bet*2;
        } else if (number == rollOne || number == rollTwo || number == rollThree) {
            winnings = bet;
        }
         
        System.out.println("Winnings = $" + winnings);
        return winnings;
    }
     
/*Name: newBankRoll
Purpose: calculates the new amount in the bankroll after a bet has been won or lost 
Input: the amount of money won, current bankroll value, the amount of bet placed
Output: none
*/
    public static double newBankroll(double winnings, double bankroll, double bet) {
        if (winnings > 0.0) {
            bankroll += winnings;
        } else {
            bankroll -= bet;
        }
        return bankroll;
    }
     
/*Name: playAgain
Purpose: Asks user if they want to play again and let's them play or doesn't let them play according to the funds remaining
Input: current bankroll value,scanner to get input from user
Output: none
*/
    public static boolean playAgain(double bankroll,Scanner scanner) {  
        String answer = scanner.nextLine();
        System.out.print("Do you want to keep playing? ");
        answer = scanner.nextLine();
         
        while((answer.equalsIgnoreCase("yes") && bankroll > 0.00)){
            return true;
        }
        while(answer.equalsIgnoreCase("yes") && bankroll==0.00){
            System.out.println("Sorry, you've lost all your money! Better luck next time!!");
            return false;
        }

        if(answer.equalsIgnoreCase("no")){
            System.out.println("Okay, game over. Thanks for playing!");
        }else{
            System.out.println("Please enter yes or no");
            answer = scanner.nextLine();
        }
    
        return false;
    }

/*Name: checkForDouble 
Purpose: checks is the data entered is a double or not
Input: scanner
Output: prints error message
*/
    public static void checkForDouble(Scanner scanner){
        while(!scanner.hasNextDouble()){
            System.out.print("That is not a number. Please enter a number ");
            scanner.next();
        }
    }

/*Name: checkForInt
Purpose: checks if the data entered is an integer or not
Input: scanner
Output: prints error message
*/
    public static void checkForInt(Scanner scanner){   
        while(!scanner.hasNextInt()){
            System.out.println("That is not a number. Please choose a number between 1 to 6 ");
            scanner.next();
        }
    }
}