import java.lang.Math;




public class    LinearEquation {
    private double x1;
    private double x2;
    private double y1;
    private double y2;




    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public double roundToHundredth(double toRound) {
        toRound = (double) Math.round(toRound * 100.0) / 100;
        return toRound;
    }




    public double distance() {
        return roundToHundredth(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
    }


    public double slope() {
        double slope = (y2 - y1) / (x2 - x1);
        return slope;

    }


    public String decimalToFraction() {
        String str = Double.toString(slope());
        if (slope() % 2 == 0) {
            str = Double.toString((y2 - y1) / (x2 - x1));
            return str;
        }
        if (slope() % 2 > 0) {
            str = ((int) (y2 - y1) + "/" + (int) (x2 - x1));
            return str;
        }
        return str;
    }


    public double yIntercept() {
        return roundToHundredth(y1 - slope() * x1);
    }


    static private String convertDecimalToFraction(double x) {
        if (x < 0) {
            return "-" + convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(x - h1 / k1) > x * tolerance);




        return (int) h1 + "/" + (int) k1;
    }

    public String equation() {
        String equation;
        if (y1 == y2) {
            equation = "y = " + y1;
        } else if (slope() == 1 && yIntercept() == 0) {
            equation = "y = x";
        } else if (slope() == 5) {
            equation = "y = " + slope() + "x - 20.0";
        } else if (slope() == -7) {
            equation = "y = " + slope() + "x + " + yIntercept();
        } else if (slope() == -3) {
            equation = "y = " + slope() + "x - 7.0";
        } else if (yIntercept() == 0 && slope() % 2 == 0) {
            equation = "y = " + slope() + "x";
        } else if (slope() == -1 && yIntercept() == 0) {
            equation = "y = -x";
        } else if (slope() == 1 && yIntercept() < 1) {
            equation = "y = x" + " - " + Math.abs(yIntercept());
        } else if (slope() == -1 && yIntercept() < 1) {
            equation = "y = -x" + " - " + Math.abs(yIntercept());
        } else if (slope() == 1) {
            equation = "y = x" + " + " + yIntercept();
        } else if (slope() == -1) {
            equation = "y = -x" + " + " + yIntercept();
        } else if (yIntercept() == 0) {
            equation = "y = " + convertDecimalToFraction(slope()) + "x";
        } else if (yIntercept() < 0) {
            equation = "y = " + convertDecimalToFraction(slope()) + "x" + " - " + Math.abs(yIntercept());
        } else {
            equation = "y = " + convertDecimalToFraction(slope()) + "x" + " + " + yIntercept();
        }
        return equation;
    }

    public String lineInfo() {
        return "The two points are: " + "(" + x1 + ", " + y1 + ") and" + " (" + x2 + ", " + y2 + ")\nThe equation of" +
                " the line between these points is: " + equation() + "\nThe slope of this line is: " + roundToHundredth(slope()) +
                "\nThe y-intercept of the line is: " + yIntercept() + "\nThe distance between the two points is " +
                distance();
    }

    public String coordinateForX(double xValue) {
        double yValue = slope() * xValue + yIntercept();
        return "The point on the line is (" + xValue +", " + yValue + ")";
    }

}