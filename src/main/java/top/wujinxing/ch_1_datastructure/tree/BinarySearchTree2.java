package top.wujinxing.ch_1_datastructure.tree;

/**
 * @author wujinxing
 * date 2019 2019/12/26 21:20
 * description
 */
public class BinarySearchTree2 {

    public static void main(String[] args) {
        BinarySearchTree2 tree = new BinarySearchTree2();
        tree.insert(39);
        tree.insert(24);
        tree.insert(64);
        tree.insert(23);
        tree.insert(30);
        tree.insert(53);
        tree.insert(60);

        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);

        tree.show(tree.find(23));
    }

    private class Node {
        int data;
        Node right;
        Node left;
    }

    private Node root;

    public void insert(int key) {
        Node p = new Node();    // 待插入的节点
        p.data = key;

        if (root == null) {
            root = p;
        } else {
            Node parent = new Node();
            Node current = root;
            while (true) {
                parent = current;
                if (key > current.data) {    //  待插入的值大于当前节点，将当前节点右移
                    current = current.right;
                    if (current == null) {
                        parent.right = p;
                        return;
                    }
                } else { // 未做key相等的情况
                    current = current.left;
                    if (current == null) {
                        parent.left = p;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.data != key) {
            if (key > current.data)
                current = current.right;
            else
                current = current.left;

            if (current == null) return null;
        }
        return current;
    }

    public void show(Node node){
        if (node != null)
            System.out.println(node.data);
        else
            System.out.println("null");
    }


    // 遍历
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("preOrder traversal: ");
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("inOrder traversal: ");
                inOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("postOrder traversal: ");
                postOrder(root);
                System.out.println();
                break;
        }
    }
}
