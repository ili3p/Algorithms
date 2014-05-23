package interview.google;

public class BSTree {

    class Node {
        int value;
        String cargo = null;
        Node left = null;
        Node right = null;

        Node(int v, String c) {
            value = v;
            cargo = c;
        }

        @Override
        public String toString() {
            return cargo + " : " + value;
        }
    }

    Node root = null;

    public void insert(int value, String cargo) {
        if (!contains(value)) {
            root = insert(value, cargo, root);
        }
    }

    private Node insert(int value, String cargo, Node node) {
        if (node == null) {
            return new Node(value, cargo);
        } else {
            if (value > node.value) {
                node.right = insert(value, cargo, node.right);
            } else {
                node.left = insert(value, cargo, node.left);
            }
            return node;
        }
    }

    public boolean contains(int val) {
        return find(val, root) != null;
    }

    public Node find(int val) {
        return find(val, root);
    }

    private Node find(Integer val, Node node) {
        if (node == null || val == null) {
            return null;
        } else {
            if (val == node.value) {
                return node;
            } else if (val > node.value) {
                return find(val, node.right);
            } else {
                return find(val, node.left);
            }
        }
    }

    public void delete(int val) {
        root = delete(val, root);
    }

    private Node delete(int val, Node node) {
        if (node == null) {
            return null;
        }
        if (node.value == val) {
            if (node.right != null && node.left != null) {
                Node min = min(node.right);
                delete(min.value);
                node.value = min.value;
                node.cargo = min.cargo;
            } else {
                if (node.right != null) {
                    return node.right;
                } else {
                    return node.left;
                }
            }
        } else {
            if (node.value < val) {
                node.right = delete(val, node.right);
            } else {
                node.left = delete(val, node.left);
            }
        }

        return node;
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Integer min, Integer max) {
        if (x == null)
            return true;
        if (min != null && Integer.valueOf(x.value).compareTo(min) <= 0)
            return false;
        if (max != null && Integer.valueOf(x.value).compareTo(max) >= 0)
            return false;
        return isBST(x.left, min, Integer.valueOf(x.value))
                && isBST(x.right, Integer.valueOf(x.value), max);
    }

    private static Node min(Node node) {
        Node result = node;

        while (result.left != null) {
            result = result.left;
        }

        return result;
    }

    private void deleteMin(Node node) {
        Node result = node;
        Node parent = node;

        while (result.left != null) {
            parent = result;
            result = result.left;
        }

        parent.left = null;
    }

    private static Node max(Node node) {
        Node result = node;

        while (result.right != null) {
            result = result.right;
        }

        return result;
    }

    private void deleteMax(Node node) {
        Node result = node;
        Node parent = node;
        while (result.right != null) {
            parent = result;
            result = result.right;
        }
        parent.right = null;
    }

    // delete
    // min
    // max
    // rank
    // binary search
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        int[] vals = { 3, 5, 6, 2, 1, 4, 7, 9 };
        String[] cargos = { "cat", "money", "apple", "car", "bike", "van", "table", "chair" };
        for (int i = 0; i < vals.length; ++i) {
            tree.insert(vals[i], cargos[i]);
        }

        tree.delete(3);

        int[] testVals = { 5, 4, 9, 1, 13, 2, 54, 23 };
        for (int i = 0; i < testVals.length; ++i) {
            //            System.out.print(tree.contains(testVals[i]) + " ");
            //            System.out.println(tree.find(testVals[i]));
        }
        tree = new BSTree();
        for (int i = 0; i < 100; ++i) {
            tree.insert((int) (100 * Math.random()), cargos[i % cargos.length]);
        }
        System.out.println(tree.isBST(tree.root, null, null));
        while (tree.root != null) {
            int num = (int) (100 * Math.random());
            tree.delete(num);
            System.out.println(num);
            if (!tree.isBST(tree.root, null, null)) {
                System.out.println("shtop");
            }
        }
    }
}
