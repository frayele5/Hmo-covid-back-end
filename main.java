import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 1;
        while (option == 1 || option == 2) {
            System.out.println("Choose an option\n 1: A rectangle tower\n 2: A Triangle tower\n 3: exit the program");
            option = scan.nextInt();
            if (option == 3)
                break;
            System.out.println("Please enter height and width respectively");
            int height = scan.nextInt();
            int width = scan.nextInt();
            if (option == 1) {
                if (Math.abs(height - width) > 5)
                    System.out.println("The area of the rectangle is: " + height * width);
                else
                    System.out.println("The perimeter of the rectangle is: " + (height * 2 + width * 2));
            } else if (option == 2) {
                System.out.println("Choose an option\n 1:Calculating the perimeter\n 2:Printing the triangle");
                option = scan.nextInt();
                if (option == 1) {
                    System.out.println("The perimeter of the triangle is: " + calculateTrianglePerimeter(width, height));
                } else {
                    if (width % 2 == 0 || width >= 2 * height) {
                        System.out.println("Cannot print triangle with given dimensions.");
                    } else {
                       printTriangle(width, height);
                    }
                }
            }
        }

    }

    // This method print the triangle according to width and height
    // counter - Calculate the number of distinct levels that can exist between the initial and final lines
    // numInUpperLine - count how many asterisk should display in the upper group after first line.
    // numsInEachLine - count how many asterisk should display between the upper group and last line
    // astTimes - the number of asterisks to display
    // spaceTimes - the number of spaces to display
    private static void printTriangle(int width, int height) {
        int counter = 0;

        for(int i=3 ;i<width; i+=2) {
            counter++;
        }
        int numsInEachLine = (height-2)/counter;
        int numInUpperLine = ((height-2)%counter) + numsInEachLine;

        String space = " ";
        int spaceTimes = (width-1)/2;
        String ast = "*";
        int astTimes = 1;
        System.out.println(space.repeat(spaceTimes) + ast.repeat(astTimes));
        spaceTimes--;
        astTimes += 2;

        for(int i=0; i<numInUpperLine; i++) {
            System.out.println(space.repeat(spaceTimes) + ast.repeat(astTimes));
        }

        for(int i=numInUpperLine+1; i<height-1 && counter>1; i+=numsInEachLine) {
            spaceTimes--;
            astTimes += 2;
            for(int j=0; j<numsInEachLine && i+j<height-1; j++)
                System.out.println(space.repeat(spaceTimes) + ast.repeat(astTimes));
        }
        spaceTimes--;
        System.out.println(space.repeat(spaceTimes) + ast.repeat(width));
    }

    public static double calculateTrianglePerimeter(int width, int height) {
        double calc = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        double perimeter = width + calc * 2 ;
        return perimeter;
    }
}
