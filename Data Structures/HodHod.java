public class HodHod implements DataStructure, Iterable {
    private int size;
    private int[] array = new int[100];
    public final int k;

    public HodHod(int k) {
        this.k = k;
    }

    @Override
    public void add(int number) {
        try {
            array[size] = number;
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void remove(int number) {
        boolean found = false;
        int i = 0;
        for (i = 0; i < size; i++) {
            if (array[i] == number) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Number not in HodHod");
            return;
        }
        size--;
        for (; i < size; i++) {
            array[i] = array[i + 1];
        }
    }

    @Override
    public void removeAt(int i) {
        if (i >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        size--;
        for (int j = i; j < size; j++) {
            array[j] = array[j + 1];
        }
    }

    @Override
    public void pop() {
        boolean found = false;
        int i = 0;
        for (i = 0; i < size; i++) {
            if (array[i] > k) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No number in this HodHod is larger than k");
            return;
        }
        size--;
        for (; i < size; i++) {
            array[i] = array[i + 1];
        }
    }

    @Override
    public int getElementAt(int i) throws Exception {
        if (i < size) {
            return array[i];
        }
        throw new Exception("Index out of bounds");
    }

    @Override
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

}
