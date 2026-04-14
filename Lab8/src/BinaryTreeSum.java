class InvalidTreeNodeException extends Exception {
    public InvalidTreeNodeException(String message) {
        super(message); // Pass message to parent Exception class
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeSum {
    public TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        return root;
    }

    public int sumTree(TreeNode root) throws InvalidTreeNodeException {
        if (root == null) {
            return 0; // if the current node is null, contribute 0 to the sum
        }

        // not allowed for negative values
        if (root.val < 0) {
            throw new InvalidTreeNodeException(
                    "Invalid node value found: " + root.val + " (negative values not allowed)"
            );
        }
        return root.val + sumTree(root.left) + sumTree(root.right); // current value +sum of left subtree +sum of right subtree
    }

    public static void main(String[] args) {
        BinaryTreeSum bts = new BinaryTreeSum();

        TreeNode tree = bts.buildSampleTree();
        try {
            int total = bts.sumTree(tree);
            System.out.println("Sum of all nodes: " + total); // 70
        } catch (InvalidTreeNodeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        TreeNode badTree = bts.buildSampleTree();
        badTree.left.left.val = -5;

        try {
            int total = bts.sumTree(badTree);
            System.out.println("Sum: " + total);
        } catch (InvalidTreeNodeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
