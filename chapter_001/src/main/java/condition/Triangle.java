package condition;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        double rsl = (a + b + c) / 2;
        return rsl;
    }


    public boolean exist(double ab, double ac, double bc) {
        boolean rsl = false;
        if (ab + ac > bc && ac + bc > ab && bc + ab > ac) {
            rsl = true;
        }
        return rsl;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
