import java.util.Scanner;
public class LinearEquationLogic {
    private LinearEquation point;
    private Scanner myScanner;
    private String coord1;
    private String coord2;
    private String answer= null;

    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);
        point = null;
        coord1 = null;
        coord2 = null;
    }
    public void start () {
        startingCode();
        intermission();
    }
    private void startingCode () {
        System.out.println("Welcome to the linear equation calculator!");
        mainCode();
    }
    private void findYWhenX() {
        System.out.print("Enter a value for x: ");
        System.out.println("The point on the line is " + point.coordinateForX(myScanner.nextDouble()));
        myScanner.nextLine();
    }
    private void intermission () {
        answer= null;
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        answer = myScanner.nextLine();
        while (answer.equals("y")) {
            mainCode();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            answer = myScanner.nextLine();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }
    private void mainCode() {
        System.out.print("Enter coordinate 1: ");
        coord1 = myScanner.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = myScanner.nextLine();
        point = new LinearEquation(coord1, coord2);
        double coord1XValue = Integer.parseInt(coord1.substring(1,coord1.indexOf(",")));
        double coord1YValue = Integer.parseInt(coord1.substring(coord1.indexOf(",")+2, coord1.length()-1));
        double coord2XValue = Integer.parseInt(coord2.substring(1,coord2.indexOf(",")));
        double coord2YValue = Integer.parseInt(coord2.substring(coord2.indexOf(",")+2, coord2.length()-1));
        while (coord1XValue == coord2XValue) {
            System.out.println("These two coordinate create a divide by zero error, please enter a new set of coordinate.");
            System.out.print("Enter coordinate 1: ");
            coord1 = myScanner.nextLine();
            System.out.print("Enter coordinate 2: ");
            coord2 = myScanner.nextLine();
            point = new LinearEquation(coord1, coord2);
            coord1XValue = Integer.parseInt(coord1.substring(1,coord1.indexOf(",")));
            coord1YValue = Integer.parseInt(coord1.substring(coord1.indexOf(",")+2, coord1.length()-1));
            coord2XValue = Integer.parseInt(coord2.substring(1,coord2.indexOf(",")));
            coord2YValue = Integer.parseInt(coord2.substring(coord2.indexOf(",")+2, coord2.length()-1));
        }
        point.lineInfo();
        findYWhenX();
    }
}
