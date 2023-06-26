public class RBTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;
        Color color;

    }
    private enum Color{
        RED,BLACK;
    }

    public Node find(int value) {
        return find(value, root);
    }

    private Node find(int value, Node node) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value < value) {
            return find(value, node.right);
        } else return find(value, node.left);
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
        } else {
            insert(root, value);
            root = rebalance(root);
        }
        root.color = Color.BLACK;
    }

    private void insert(Node node, int value) {
        if (node.value != value) {
            if (node.value < value) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                } else {
                    insert(node.right, value);
                    node.right = rebalance(node.right);
                }
            } else {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                } else {
                    insert(node.left, value);
                    node.left = rebalance(node.left);
                }
            }
        }
    }
    public void swapColor(Node node){
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
        node.color = Color.RED;
    }
    public Node turnLeft(Node node){
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }
    public Node turnRight(Node node){
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        x.color = node.color;
        node.color = Color.RED;
        return x;
    }
    public Node rebalance(Node node){
        Node cur = node;
        boolean flag = true;
        while (flag){
            flag = false;
            if(cur.right != null && cur.right.color == Color.RED
            && (cur.left == null || cur.left.color == Color.BLACK)){
                cur = turnRight(node);
                flag = true;
            }
            if (cur.left != null && cur.left.color == Color.RED
                    && cur.left.left != null && cur.left.left.color == Color.RED){
                cur = turnLeft(node);
                flag = true;
            }
            if(cur.left != null && cur.left.color == Color.RED
                    && cur.right != null && cur.right.color == Color.RED){
                swapColor(cur);
                flag = true;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
//        MyHashMap map = new MyHashMap();
//        map.push(1,2);
//        map.push(3,5);
//
//        System.out.println(map.find(1));
//        System.out.println(map.find(2));
//
//        map.remove(1);
//        map.push(2,5);
//        System.out.println(map.find(1));
//        System.out.println(map.find(2));

        RBTree tree = new RBTree();
        for (int i = 0; i <= 9; i++) {
            tree.insert(i);
        }
    }
}