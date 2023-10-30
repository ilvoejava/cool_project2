import java.util.Scanner;

public class LinearEquation{

    Scanner scan = new Scanner(System.in);
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    public LinearEquation(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;


    }

    public double roundedToHundreth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }
    public double slope() {
        double slope = (y2 - y1) / (x2 - x1);
        return slope;

    }

    public double yintercept(){
        double yintercept = roundedToHundreth((double) y1 - slope() * (double) x1);
        return yintercept;

    }

    public double distance() {
        return (double) Math.round(Math.abs(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))) * 100 / 100);
    }

    public String slopeAsString() {
        int y = y2 - y1;
        int x = x2 - x1;
        String m;
        if (y % x == 0) {
            int result = y / x;
            m = "" + result;
        } else {
            m = "" + y + "/" + x;
        }
        if (slope() > 0 && m.indexOf("-") == 0) {
            int divide = m.indexOf("/");
            String mfirst = m.substring(1, divide);
            String msecond = m.substring(divide + 2);
            m = mfirst + "/" + msecond;
        } else if(slope() < 0 && m.indexOf("-") != 0) {
            int divide = m.indexOf("/");
            String mfirst = m.substring(0, divide);
            String msecond = m.substring(divide + 2);
            m = "-" + mfirst +"/" + msecond;
        }
        return m;
    }
    public String equation() {
        String equation;
        if (y1 == y2) {
            equation = "y = " + y1;
        } else if (slope() == 1 && yintercept() == 0) {
            equation = "y = x";
        } else if (slope() == -1 && yintercept() == 0) {
            equation = "y = -x";
        } else if (slope() == 1 && yintercept() < 1) {
            equation = "y = x" + " - " + Math.abs(yintercept());
        } else if (slope() == -1 && yintercept() < 1) {
            equation = "y = -x" + " - " + Math.abs(yintercept());
        } else if (slope() == 1) {
            equation = "y = x" + " + " + yintercept();
        } else if (slope() == -1) {
            equation = "y = -x" + " + " + yintercept();
        } else if (yintercept() == 0) {
            equation = "y = " + slopeAsString() + "x";
        } else if (yintercept() < 0) {
            equation = "y = " + slopeAsString() + "x" + " - " + Math.abs(yintercept());
        } else {
            equation = "y = " + slopeAsString() + "x" + " + " + yintercept();
        }
        return equation;
    }

    public String lineInfo() {
        return "The two points are: " + "(" + x1 + ", " + y1 + ") and" + " (" + x2 + ", " + y2 + ")\nThe equation of" +
                " the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() +
                "\nThe y-intercept of the line is: " + yintercept() + "\nThe distance between the two points is " +
                distance();
    }

    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yintercept();
        return "The point on the line is (" + xValue +", " + yValue + ")";
    }

}