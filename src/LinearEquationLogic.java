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
    }
}
