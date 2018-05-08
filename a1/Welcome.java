/*Name:Devroop Banerjee
Student ID:V00837868
Name of Program:Welcome.java
Input: None
Output: Ascii TotemPole and surface of cylinder
Purpose:Prints out a TotemPole and the surface area of a cylinder
*/

public class Welcome{
	public static void main (String [] args){
		System.out.println ("Welcome");
		System.out.println ();
			printTotemPole();
			calcSurfaceArea();
			
			
	}

/*Name: printPig
Purpose: prints pig
Input: none
Output: pig
*/

	public static void printPig (){
		System.out.println ("  ^__^");
		System.out.println (" (O  O)");
		System.out.println ("  (oo)");
		System.out.println (" (\")_(\")@");
	}

/*Name: printFrog
Purpose: prints frog
Input: none
Output: frog
*/

	public static void printFrog (){
		System.out.println ("  @..@");
		System.out.println (" (____)");
		System.out.println ("( >__< )");
		System.out.println ("\"\"    \"\"");
	}

/*Name: spacerlines
Purpose: prints a spacer line
Input: none
Output: spacer lines
*/

	public static void spacerlines(){
		System.out.println ("/~~~~~~\\");
	}

/*Name: printTotemPole
Purpose: prints a combination of the frogs, pigs, and spacer lines
Input: none
Output: TotemPole
*/

	public static void printTotemPole(){
			spacerlines();
			printFrog();
			System.out.println ();
			spacerlines();
			printPig ();
			spacerlines();
			printFrog();
			System.out.println ();
			spacerlines();
			printPig ();
			spacerlines();
			spacerlines();
	}

/*Name: calcSurfaceArea
Purpose: calculates surface area of cylinder
Input: none
Output: surface area of cylinder
*/

	public static void calcSurfaceArea(){
		double height;
		double diameter;
		double Circumference;
		double CircleArea;
		double CylinderWall;
		double TotalSurfaceArea;

		height = 5;
		diameter = 4;
			
		Circumference = 2*3.14*(diameter/2);
		CircleArea =  3.14*(diameter/2)*(diameter/2);
		CylinderWall = Circumference*height;
		TotalSurfaceArea = (2*CircleArea) + CylinderWall;
		System.out.println ("Surface Area is:  " + TotalSurfaceArea);
	}
}
		