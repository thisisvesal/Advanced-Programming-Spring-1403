abstract class TwoDimensionalShape extends Shape {
    public TwoDimensionalShape(String info) {
        super(info);
    }

    public abstract double getArea();

    @Override
    public void printInfo() {
        System.out.println("Area of " + this.toString() + ": " + this.getArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TwoDimensionalShape)) {
            return false;
        }
        if (obj instanceof Circle) {
            if (((Circle)obj).radius != ((Circle)this).radius || !((Circle)this).info.equals(((Circle)obj).info)) {
                return false;
            }    
        }
        if (obj instanceof Square) {
            if (((Square)obj).side != ((Square)this).side || !((Square)this).info.equals(((Square)obj).info)) {
                return false;
            }    
        }
        return true;
    }
}