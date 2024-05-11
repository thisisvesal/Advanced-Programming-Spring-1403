public class Queue implements DataStructure, Iterable {
    private int startIndex = 0;
    private int endIndex = -1;
    private int size;
    private int[] array = new int[100];

    @Override
    public void add(int number) {
        endIndex++;
        endIndex %= array.length;
        array[endIndex] = number;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void remove(int number) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            try
            {
                if (getElementAt(i) == number) {
                    found = true;
                    size--;
                }
                if (found) {
                    array[i % array.length] = getElementAt(i + 1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    @Override
    public void removeAt(int i) {
        size--;
        for (int j = i; j < size; j++) {
            try {
                array[j % array.length] = getElementAt(j + 1);
            } catch (Exception e) {
                size++;
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    @Override
    public void pop() {
        startIndex++;
        startIndex %= array.length;
        size--;
    }

    @Override
    public int getElementAt(int i) throws Exception {
        i += startIndex;
        i %= array.length;
        if (i <= endIndex) {
            return array[i];
        }
        throw new Exception("Index out of bounds");
    }

    @Override
    public void printArray() {
        try {
            for (int i = 0; i < size; i++) {
                System.out.print(getElementAt(i) + " ");
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
