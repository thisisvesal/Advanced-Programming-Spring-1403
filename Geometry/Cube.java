public class Cube extends ThreeDimensionalShape {
    public final double side;

    public Cube(String info, double side) {
        super(info);
        this.side = side;
    }

    @Override
    public double getAroundArea() {
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public String toString() {
        return info + " cube";
    }
}
