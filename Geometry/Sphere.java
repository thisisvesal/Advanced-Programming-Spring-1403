public class Sphere extends ThreeDimensionalShape {
    public final double radius;

    public Sphere(String info, double radius) {
        super(info);
        this.radius = radius;
    }

    @Override
    public double getAroundArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return 4 * Math.PI * radius * radius * radius / 3;
    }

    @Override
    public String toString() {
        return info + " sphere";
    }
}
