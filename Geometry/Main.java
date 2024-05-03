public class Main {

    public static void main(String[] args){
        Shape [] shapes = new Shape[4];
        shapes[0] = new Circle("red", 2);
        shapes[1] = new Square("blue", 3);
        shapes[2] = new Sphere("yellow", 2);
        shapes[3] = new Cube("green", 5);

        for(Shape element : shapes) {
            element.printInfo();
        }
    }
}