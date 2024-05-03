abstract class ThreeDimensionalShape extends Shape {

    public ThreeDimensionalShape(String info) {
        super(info);
    }

    public abstract double getAroundArea();

    public abstract double getVolume();

    @Override
    public void printInfo() {
        System.out.println("Area of " + this.toString() + ": " + this.getAroundArea());
        System.out.println("Volume of " + this.toString() + ": " + this.getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ThreeDimensionalShape)) {
            return false;
        }
        if (obj instanceof Sphere) {
            if (((Sphere)obj).radius != ((Sphere)this).radius || !((Sphere)this).info.equals(((Sphere)obj).info)) {
                return false;
            }    
        }
        if (obj instanceof Cube) {
            if (((Cube)obj).side != ((Cube)this).side || !((Cube)this).info.equals(((Cube)obj).info)) {
                return false;
            }
        }
        return true;
    }
}