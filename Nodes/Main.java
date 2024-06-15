public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] values = {13, 3, 4, 2, 1, 12, 10, 5, 8, 7, 6, 9, 11, 14, 18};
        
        for (int value : values) {
            binarySearchTree.insert(value);
        }
        System.out.println(binarySearchTree.toString());
        System.out.println(binarySearchTree.contains(2));
        System.out.println(binarySearchTree.contains(25));
        System.out.println(binarySearchTree.countLeaves());
        binarySearchTree.printLevelToLevel();
        System.out.println(binarySearchTree.height());
        System.out.println(binarySearchTree.min());
        System.out.println(binarySearchTree.max());
    }
}
