import java.util.concurrent.atomic.AtomicInteger;


class NoMatchingNodesException extends Exception {
    public NoMatchingNodesException(String message) {
        super(message);
    }
}

public class BinaryTreeSumFiltered {
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

    public int sumFiltered(TreeNode root, boolean sumEven, AtomicInteger sum)
            throws InvalidTreeNodeException {


        if (root == null) {
            return 0; // if nodes found
        }
        if (root.val < 0) {
            throw new InvalidTreeNodeException("Negative value: " + root.val); // if input is negative
        }


        int count = 0; // count of nodes at this level and below


        // check if node's value matches the filter condition
        boolean isEven = (root.val % 2 == 0);
        if ((sumEven && isEven) || (!sumEven && !isEven)) {
            sum.addAndGet(root.val); // add this value to the running total
            count = 1; // matched
        }


        // recurse into left and right subtrees and add their match counts
        count += sumFiltered(root.left, sumEven, sum);
        count += sumFiltered(root.right, sumEven, sum);


        return count;
    }

    public static void main(String[] args) {
        BinaryTreeSumFiltered bstf = new BinaryTreeSumFiltered();
        TreeNode tree = bstf.buildSampleTree();


        // test of even
        AtomicInteger evenSum = new AtomicInteger(0); // Shared accumulator
        try {
            int count = bstf.sumFiltered(tree, true, evenSum);
            if (count == 0) {
                throw new NoMatchingNodesException("No even values found in the tree."); // if no even values found, throw custom exception
            }
            System.out.println("Sum of even nodes: " + evenSum.get()); // 70
        } catch (InvalidTreeNodeException e) {
            System.out.println("Tree error: " + e.getMessage());
        } catch (NoMatchingNodesException e) {
            System.out.println("Filter error: " + e.getMessage());
        }

        // test of odd
        AtomicInteger oddSum = new AtomicInteger(0);
        try {
            int count = bstf.sumFiltered(tree, false, oddSum);
            if (count == 0) {
                throw new NoMatchingNodesException("No odd values found in the tree.");
            }
            System.out.println("Sum of odd nodes: " + oddSum.get());
        } catch (InvalidTreeNodeException e) {
            System.out.println("Tree error: " + e.getMessage());
        } catch (NoMatchingNodesException e) {
            System.out.println("Filter error: " + e.getMessage()); // This triggers!
        }
    }
}
