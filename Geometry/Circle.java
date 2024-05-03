
public class Circle extends TwoDimensionalShape {
    public final double radius;

    public Circle(String info, double radius) {
        super(info);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return  Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return info + " circle";
    }
}
