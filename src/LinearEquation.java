public class LinearEquation {
    private String coord1;
    private String coord2;
    private double coord1XValue;
    private double coord1YValue;
    private double coord2XValue;
    private double coord2YValue;

    public LinearEquation (String coord1, String coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        coord1XValue = Integer.parseInt(coord1.substring(1,coord1.indexOf(",")));
        coord1YValue = Integer.parseInt(coord1.substring(coord1.indexOf(",")+2, coord1.length()-1));
        coord2XValue = Integer.parseInt(coord2.substring(1,coord2.indexOf(",")));
        coord2YValue = Integer.parseInt(coord2.substring(coord2.indexOf(",")+2, coord2.length()-1));
    }

    public LinearEquation (int x1, int y1, int x2, int y2) {
        coord1XValue = x1;
        coord1YValue = y1;
        coord2XValue = x2;
        coord2YValue = y2;
    }
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(coord2XValue - coord1XValue, 2) + Math.pow(coord2YValue - coord1YValue, 2)));
    }
    public double slope() {
        double slope;
        if ((coord2YValue - coord1YValue) % (coord2XValue - coord1XValue) == 0) {
            slope = (coord2YValue - coord1YValue) / (coord2XValue - coord1XValue);
        } else {
            slope = roundedToHundredth( (coord2YValue - coord1YValue) / (coord2XValue - coord1XValue) );
        }
        return slope;
    }
    public double yIntercept() {
        return coord1YValue - coord1XValue * slope();
    }
    public String equation() {
        String yIntercept = null;
        if (yIntercept() < 0) {
            yIntercept = "- " + Math.abs(yIntercept());
        } else {
            yIntercept = "+ " + Math.abs(yIntercept());
        }
        if (slope() == 0) {
            return "y = " + yIntercept();
        } else {
            if (yIntercept() == 0) {
                if ((slope() == 1) || (slope() == -1)) {
                    if (slope() == 1) {
                        return "y = " + "x";
                    } else {
                        return "y = " + "-x";
                    }
                } else {
                    if ((coord2YValue - coord1YValue) % (coord2XValue - coord1XValue) == 0) {
                        return "y = " + (int) slope() + "x";
                    } else {
                        if (slope() > 0) {
                            return "y= " + Math.abs(coord2YValue - coord1YValue) + "/" + Math.abs(coord2XValue - coord1XValue) + "x";
                        } else {
                            return "y= -" + (coord2YValue - coord1YValue) + "/" + Math.abs(coord2XValue - coord1XValue) + "x";
                        }
                    }
                }
            } else {
                if ((slope() == 1) || (slope() == -1)) {
                    if (slope() == 1) {
                        return "y = " + "x " + yIntercept;
                    } else {
                        return "y = " + "-x " + yIntercept;
                    }
                } else {
                    if ((coord2YValue - coord1YValue) % (coord2XValue - coord1XValue) == 0) {
                        return "y = " + (int) slope() + "x " + yIntercept;
                    } else {
                        if (slope() > 0) {
                            return "y= " + Math.abs(coord2YValue - coord1YValue) + "/" + Math.abs(coord2XValue - coord1XValue) + "x " + yIntercept;
                        } else {
                            return "y= -" + (coord2YValue - coord1YValue) + "/" + Math.abs(coord2XValue - coord1XValue) + "x " + yIntercept;
                        }
                    }
                }
            }
        }
    }

    public String coordinateForX (double x) {
        return "(" + x + ", " + (slope() * x + yIntercept()) + ")";
    }
    public void lineInfo() {
        System.out.println("The two points are: " + coord1 + " and " + coord2);
        System.out.println("The equation of the line between these points is: " + equation());
        System.out.println("The slope of this line is: " + slope());
        System.out.println("The y-intercept of this line is: " + yIntercept());
        System.out.println("The distance between these points is " + distance());
    }
    private double roundedToHundredth (double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }
}
