public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Queue");
        Queue queue = new Queue();
        queue.add(2);
        queue.add(0);
        queue.add(7);
        System.out.println("Queue before pop:");
        queue.printArray();
        queue.pop();
        System.out.println("Queue after pop:");
        queue.printArray();
        queue.pop();
        System.out.println("Queue after pop:");
        queue.printArray();
        queue.add(4);
        queue.add(9);
        queue.add(6);
        System.out.println("Queue after adding more items:");
        queue.printArray();
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println("");

        System.out.println("Initializing HodHod, k = 3");
        HodHod hodHod = new HodHod(3);
        hodHod.add(3);
        hodHod.add(5);
        hodHod.add(1);
        hodHod.add(8);
        System.out.println("HodHod before pop:");
        hodHod.printArray();
        hodHod.pop();
        System.out.println("HodHod after pop:");
        hodHod.printArray();
        hodHod.pop();
        System.out.println("HodHod after pop:");
        hodHod.printArray();
    }
}
