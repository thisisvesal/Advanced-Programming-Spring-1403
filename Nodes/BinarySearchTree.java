import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    /**
     * Node
     */
    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.getValue()) {
            root.left = insertRec(root.getLeft(), value);
        } else if (value > root.getValue()) {
            root.right = insertRec(root.getRight(), value);
        }
        return root;
    }

    public boolean contains(int value) {
        return containsRec(root, value);
    }

    private boolean containsRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.getValue() == value) {
            return true;
        }
        if (value < root.getValue()) {
            return containsRec(root.getLeft(), value);
        } else {
            return containsRec(root.getRight(), value);
        }
    }
    

    public int min() {
        return minRec(root);
    }

    private int minRec(Node root) {
        if (root.getLeft() == null) {
            return root.getValue();
        }
        return minRec(root.getLeft());
    }

    public int max() {
        return maxRec(root);
    }

    private int maxRec(Node root) {
        if (root.getRight() == null) {
            return root.getValue();
        }
        return maxRec(root.getRight());
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = heightRec(root.getLeft());
        int rightHeight = heightRec(root.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int countLeaves() {
        return countLeavesRec(root);
    }

    private int countLeavesRec(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        return countLeavesRec(root.getLeft()) + countLeavesRec(root.getRight());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb);
        return sb.toString();
    }

    private void toStringRec(Node root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.getValue()).append(" ");
            toStringRec(root.getLeft(), sb);
            toStringRec(root.getRight(), sb);
        }
    }

    public String printLevelToLevel() {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            sb.append(current.getValue()).append(" ");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return sb.toString();
    }
}
