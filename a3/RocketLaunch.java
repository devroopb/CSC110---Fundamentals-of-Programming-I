/*Name:	Devroop Banerjee
Student ID:	V00837868
Name of Program: RocketLaunch.java
Input: Int size, controls the proportions of the rocket
		int numBoosters, controls how many boosters are drawn
Output: An ascii representation of Apollo Spaceship
Purpose:To print a ascii rocket ship
*/

import java.util.*;

	public class RocketLaunch{
		public static void main(String[]args){

				Scanner console = new Scanner(System.in);
				System.out.print("What size rocket would you like to build?");
				System.out.println();
				int num = console.nextInt();

				System.out.println("How many boosters?");
				int num2 = console.nextInt();

			SpaceCraft(num);
				System.out.print("  ");
			spacerLines(num - 1);
				System.out.print("\n");
				System.out.print(" ");
			LemAdapter(num);
			spacerLines(num);
				System.out.print("\n");
			InstrumentUnit(num);
			spacerLines(num);

			for(int z = 0; z < num2; z++){
				Booster(num);
				spacerLines(num);
			}	
			System.out.print("\n");
			Tail(num);

			System.out.println("What is your message?");
			String ms = console.nextLine();
			String msg = console.nextLine();

			System.out.println("What is your key?");
			int key = console.nextInt();

			System.out.println("type 1 for encrypt or 2 for decrypt?");
			int type = console.nextInt();
			if(type == 1){
				String y = encrypt(msg,key);
				int word = y.length();
				if(word == 0){
					System.out.println("Error!!! Your key causes the integer value of one  of the characters to be too high");
				}else{	
					System.out.print("Your message encrypted is: " + y);
				}
			}else if(type == 2){
				String y = decrypt(msg,key);
				int word = y.length();
				if(word == 0){
					System.out.println("Error!!! Your key causes the integer value of one  of the characters to be too low");
				}else{
					System.out.print("Your message decrypted is: " + y);
				}
			}else{
				System.out.println("Error!!! There isn't a type " + type);
			}
		}

/*Name: SpaceCraft
Purpose: Prints out the top of the space craft
Input: size of rocket
Output: top of rocket
*/		
		public static void SpaceCraft(int num){

			int x = 4 + (2*(num - 1));

				for(int i = 0; i < (2*num); i++){
						x = x-1;

					for(int j = x+1; j > 0; j--){
						System.out.print(" ");	
					}

					for(int k = 0; k < i; k++){
						System.out.print("/");
					}

					System.out.print("**");

					for(int l = 0; l < i; l++){
						System.out.print("\\");
					}

					System.out.print("\n");	
				}

		}

/*Name: spacerLines
Purpose: designs spacer lines
Input: none
Output: spacer lines
*/
			public static void spacerLines(int num){
				System.out.print("+");

				for(int i = 0; i < 2*(num + 1); i++){
					System.out.print("=*");
				}

					System.out.print("+");

			}

/*Name: LemAdapater
Purpose: designs a part of the rocket
Input:  none
Output: prints out a part of the rocket
*/
			public static void LemAdapter(int num){
					for(int i = 0; i < 2; i++){
						System.out.print("//");

						for(int k = 0; k < i + (2*num); k++){
							System.out.print(" %");
						}

						System.out.println("\\\\");
					}

			}	

/*Name: InstrumentUnit
Purpose: designs a part of the rocket
Input: none
Output: prints out a part of the rocket
*/		
			public static void InstrumentUnit(int num){
				for(int i = 0; i < 2; i++){
						System.out.print("||");

						for(int j = 0; j < (2*(num)+1); j++){
							System.out.print("~#");
						}

						System.out.println("||");
					}
			}		

/*Name: Booster
Purpose: designs a part of the rocket
Input: Number of boosters
Output: prints out part of rocket
*/
			public static void Booster(int num){
/*Booster top*/
						int x = num + 1;
						System.out.print("\n");

					for(int i = 0; i < num + 1; i++){
						x = x - 1;
						System.out.print("|");

						for(int j = x; j > 0; j--){
							System.out.print(".");	
						}
						for(int k = -1; k < i; k++){
							System.out.print("/\\");
						}
						for(int l = 2 * x; l > 0; l--){
							System.out.print(".");
						}
						for(int m = -1; m < i; m++){
							System.out.print("/\\");
						}
						for(int n = 0; n < x; n++){
							System.out.print(".");
						}
						System.out.print("|");
						System.out.print("\n");
					}

/*Booster bottom*/
						x = num + 1;
						
					for(int i = 0; i < num + 1; i++){	
						x = x - 1;
						
						System.out.print("|");
						for(int j = 0; j < i; j++){
							System.out.print(".");
						}
						for(int k = x + 1; k > 0; k--){
							System.out.print("\\/");
						}
						for(int l = 0; l < i; l++){
							System.out.print("..");
						}
						for(int m = (x + 1); m > 0; m--){
							System.out.print("\\/");
						}
						for(int n = 0; n < i; n++){
							System.out.print(".");
						}
						System.out.print("|");
						System.out.print("\n");
					}
				
			}

/*Name: Tail
Purpose: designs a part of the rocket
Input: none
Output: prints out a part of the rocket
*/
			public static void Tail(int num){
				System.out.print("//  ");
				for(int i = 0; i < num; i++){
					System.out.print("/\\  ");
				}
				System.out.print("\\\\");
				System.out.print("\n\n");
			}

/*Name: encrypt
Purpose: encrypts msg given an encryption key
Input: String msg, the message to be encrypted
		int key, the amount to increase the ascii character by
		to encrypt the message
Output: an encrypted version of msg returned as a String
*/
		public static String encrypt(String msg, int key){
				String x = ("");
			for(int i = 0; i < msg.length(); i++){
				char character = msg.charAt(i);
				int val = (int)msg.charAt(i);
				val = val + key;
				char charVal = (char) val;
				x = x + charVal;
				if(val>127){
					x = ("");
				}
			}	
				return x;
		}

/*Name: decrypt
Purpose: decrypts msg given an encryption key
Input: String msg, the message to be decrypted
		int key, the amount to shift the ascii character by
		to decrypt the message
Output: a decrypted version of msg returned as a String
*/
		public static String decrypt(String msg, int key){
				String x = ("");
			for(int i = 0; i < msg.length(); i++){
				char character = msg.charAt(i);
				int val = (int)msg.charAt(i);
				val = val - key;
				char charVal = (char) val;
				x = x + charVal;
				if(val<0){
					x = ("");
				}
			}	
				return x;
		}
}