import java.util.Scanner;
public class LinearEquationLogic {
    private LinearEquation point;
    private Scanner myScanner;
    private String coord1;
    private String coord2;

    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);
        point = null;
        coord1 = null;
        coord2 = null;
    }
    public void start () {
        startingCode();
    }
    public void startingCode () {
        System.out.println("Welcome to the linear equation calculator!");
        System.out.print("Enter coordinate 1: ");
        coord1 = myScanner.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = myScanner.nextLine();
        point = new LinearEquation(coord1, coord2);
        double coord1XValue = Integer.parseInt(coord1.substring(0,coord1.indexOf(",")));
        double coord1YValue = Integer.parseInt(coord1.substring(coord1.indexOf(",")));
        double coord2XValue = Integer.parseInt(coord2.substring(0,coord2.indexOf(",")));
        double coord2YValue = Integer.parseInt(coord2.substring(coord2.indexOf(",")));
        while (coord1XValue == coord2XValue) {
            System.out.println("These two coordinate create a null slope, please enter a new set of coordinate.");
            System.out.println("Welcome to the linear equation calculator!");
            System.out.print("Enter coordinate 1: ");
            coord1 = myScanner.nextLine();
            System.out.print("Enter coordinate 2: ");
            coord2 = myScanner.nextLine();
            point = new LinearEquation(coord1, coord2);
        }
    }
}
