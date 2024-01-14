import java.util.Scanner;

public class Main {
    static int size = 0;
    static Node node = new Node("A", null, null);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < size; i++) {
            String[] split = sc.nextLine().split(" ");
            String root = split[0];
            String left = split[1];
            String right = split[2];
            insertNode(node, root, left, right);
        }

        preorderTraversal(node);
        System.out.println();
        inorderTraversal(node);
        System.out.println();
        postorderTraversal(node);
        System.out.println();
    }

    static class Node {
        String root;
        Node left;
        Node right;

        public Node(String root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    static void insertNode(Node node, String root, String left, String right) {
        if (node.root.equals(root)) {
            node.left = left.equals(".") ? null : new Node(left, null, null);
            node.right = right.equals(".") ? null : new Node(right, null, null);
        } else {
            if (node.left != null) {
                insertNode(node.left, root, left, right);
            }
            if (node.right != null) {
                insertNode(node.right, root, left, right);
            }
        }
    }

    // 전위 순회
    static void preorderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.root);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    // 중위 순회
    static void inorderTraversal(Node node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.root);
        inorderTraversal(node.right);
    }

    // 후위 순회
    static void postorderTraversal(Node node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.root);
    }
}
