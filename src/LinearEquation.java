public class LinearEquation {
    private String coord1;
    private String coord2;
    private double coord1XValue;
    private double coord1YValue;
    private double coord2XValue;
    private double coord2YValue;
    private double slope;
    private double roundedToHundredth (double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }
    public LinearEquation (String coord1, String coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        coord1XValue = Integer.parseInt(coord1.substring(0,coord1.indexOf(",")));
        coord1YValue = Integer.parseInt(coord1.substring(coord1.indexOf(",")));
        coord2XValue = Integer.parseInt(coord2.substring(0,coord2.indexOf(",")));
        coord2YValue = Integer.parseInt(coord2.substring(coord2.indexOf(",")));
    }
    public double distance() {
        return roundedToHundredth(Math.abs(Math.pow(coord2XValue - coord1XValue, 2) + Math.pow(coord2YValue - coord1YValue, 2)));
    }
    public double slope() {
        slope = roundedToHundredth( (coord2YValue - coord1YValue) / (coord2XValue - coord1XValue) );
        return slope;
    }
    public double yIntercept() {
        return roundedToHundredth(slope() * -1 * coord1XValue + coord2YValue);
    }
    public String equation() {
        if (slope == 0) {
            return "y = " + yIntercept();
        } else {
            return "y = " + (coord2YValue - coord1YValue) + "/" + (coord2XValue - coord1XValue) + "x + " + yIntercept();
        }
    }
    public String coordinateForX (double x) {
        return "(" + x + ", " + slope() * x + yIntercept() + ")";
    }
    public void lineInfo() {
        System.out.println("The two points are: " + coord1 + " and " + coord2);
        System.out.println("The equation of the line between these points is: " + equation());
        System.out.println("The slope of this line is: " + slope());
        System.out.println("The y-intercept of this line is: " + yIntercept());
        System.out.println("The distance between these points is " + distance());
    }
}
