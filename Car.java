public class Car {
    String name;
    String color;
    double xLocation;
    double yLocation;
    double speed;

    Car(String name, String color, double x, double y, double speed) {
        this.name = name;
        this.color = color;
        xLocation = x;
        yLocation = y;
        this.speed = speed;
    }

    void printInfo() {
        System.out.print("\n");
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("x: " + xLocation);
        System.out.println("y: " + yLocation);
        System.out.println("Speed: " + speed);
        System.out.print("\n");
    }

    double calculateDistance(double x, double y) {
        return Math.sqrt((xLocation - x) * (xLocation - x) + (yLocation - y) * (yLocation - y));
    }

    void calculateSpeed(double x, double y, int time) {
        speed = calculateDistance(x, y) / time;
    }

    boolean isSpeedLimitExceeded(int limit) {
        if (speed > limit)
            return true;
        else
            return false;
    }

}
