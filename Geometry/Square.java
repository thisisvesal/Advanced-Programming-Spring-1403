
public class Square extends TwoDimensionalShape {
    public final double side;

    public Square(String info, double side) {
        super(info);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return info + " square";
    }
}
