/*Name: Devroop Banerjee
Student ID:V00837868
Name of Program: Loopy.java
Input: None
Output: Shapes
Purpose: Prints shapes
*/

public class Loopy{
	public static void main(String[]args){
		int largestShape = 3;
		drawShape(largestShape);
		System.out.println();
		drawImage(largestShape);

		System.out.println();
		double x1 = 7;
		double x2 = 3;
		double x = rectangleArea(x1, x2);
		System.out.println("rectangle: with length " + x1 + ", " + "width: " + x2);
		System.out.println("area: " + x);

		System.out.println();
		double y1 = 7;
		double y2 = 6;
		double y = triangleArea(y1, y2);
		System.out.println("triangle: with height " + y1 + ", " + "base: " + y2);
		System.out.println("area: " + y);

		System.out.println();
		double z = 5;
		double z1 = circleArea(z);
		System.out.println("circle: with diameter " + z);
		System.out.println("area: " + z1);
		double z2 = circumferenceCircle(z);
		System.out.println("circumference: " + z2);

		System.out.println();
		double a1 = 7;
		double a2 = 5;
		double a = cylinderSurfaceArea(a1, a2);
		System.out.println("cylinder: with height " + a1 + ", " + "diameter: " + a2);
		System.out.println("surface area: " + a);

		System.out.println();
		double b1 = 7;
		double b2 = 7;
		double b3 = 3;
		double b = rectPrismSurfaceArea(b1,b2,b3);
		System.out.println("rectangular prism: with height " + b1 + ", " + "depth: " + b2 + ", " + "width: " + b3);
		System.out.println("surface area: " + b);

		System.out.println();
		double c1 = 7;
		double c2 = 6;
		double c = triPrismSurfaceArea(c1,c2);
		System.out.println("triangular prism: with height " + c1 + ", " + "width: " + c2);
		System.out.println("surface area: " + c);

		System.out.println();
		double d1 = 10;
		double d2 = 14;
		double d3 = 6;
		double d4 = 8;
		double d =  houseSurfaceArea(d1, d2, d3, d4);
		System.out.println("house: with wall height " + d1 + ", " + "peek height: " + d2 + ", " + "width: " + d3 + ", " + "depth: " + d4);
		System.out.println("surface area: " + d);
	}

/*Name: drawShape
Purpose: Draws a shape composed of stars bordered by / and \
Input: None
Output: Shape
*/

	public static void drawShape(int size){
		for (int i = 1; i<(size+2); i++){
			System.out.print("/");
		}
		for (int q = 1; q<(size+2); q++){
			System.out.print("\\");
		}
			System.out.print("\n/");
		for (int w = 0; w<size; w++){
			System.out.print("**");
		}
			System.out.print("/\n");

		for (int e= 1; e<(size+2); e++){
			System.out.print("\\");
		}
		for (int r = 1; r<(size+2); r++){
			System.out.print("/");
		}
			System.out.println();
	}

/*Name: drawImage
Purpose: Draws a shape in a certain order
Input: None
Output: Shape
*/
	
	public static void drawImage(int largestShape){
		for (int i = 1; i<(largestShape+1); i++){
			drawShape(i);
		}	
		for (int i = largestShape; i>0; i--){
			drawShape(i);
		}
	}

/*Name: rectangleArea
Purpose: Finds area of rectangle
Input: none
Output: area of rectangle
*/

	public static double rectangleArea(double length, double width){
		double area = length*width;
		return area;
	}
	
/*Name: triangleArea
Purpose: Finds area of triangle
Input: none
Output: area of triangle
*/
	public static double triangleArea(double height, double base){
		double area = 0.5*height*base;
		return area;
	}

/*Name: circleArea
Purpose: Finds area of circle
Input: none
Output: area of circle
*/
	public static double circleArea(double diameter){
		double area = Math.PI*(diameter/2)*(diameter/2);
		return area;
	}

/*Name: circumferenceCircle
Purpose: Finds circumference of circle
Input: none
Output: circumference of circle
*/
	public static double circumferenceCircle(double diameter){
		double area = 2*Math.PI*(diameter/2);
		return area;
	}

/*Name: cylinderSurfaceArea
Purpose: Finds surface area of cylinder
Input: none
Output: surface area of cylinder
*/

	public static double cylinderSurfaceArea(double height, double diameter){
		double area = ((circleArea(diameter)*2)+(circumferenceCircle(diameter)*height));
		return area;
	}

/*Name: rectPrismSurfaceArea
Purpose: Finds suface area of rectangular prism
Input: none
Output: suface area of rectangular prism
*/

	public static double rectPrismSurfaceArea(double height, double depth, double width){
		double area = (2*depth*height)+(rectangleArea(height,width)*4);
		return area;
	}

/*Name: triPrismSurfaceArea
Purpose: Finds surface area of triangular prism
Input: none
Output: surface area of triangular prism
*/

	public static double triPrismSurfaceArea(double height, double width){
		double area = (((Math.sqrt(3))/4)*width*width*2)+(rectangleArea(height,width)*3);
		return area;
	}

/*Name: houseSurfaceArea
Purpose: Finds surafce area of house
Input: none
Output: surafce area of house
*/

	public static double houseSurfaceArea(double wallHeight, double peekHeight, double width, double depth){
		double roofHeight = peekHeight - wallHeight;
		double halfWidth = width/2;
		double roofLength = Math.sqrt((roofHeight*roofHeight)+(halfWidth*halfWidth));
		double area = ((rectangleArea(depth,wallHeight)*2)+(rectangleArea(wallHeight,width)*2)+(rectangleArea(depth,roofLength)*2)+(triangleArea(roofHeight, width)*2));
		return area;
	}
}