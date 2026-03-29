package com.kush.studyplan.seventyfive.tree;
public class ZigZagPathFinder {
    int maxZigZag = 0;

    /**
     * Problem: Find the longest ZigZag path in a binary tree.
     * 
     * Intuition: Use a recursive approach to traverse the tree in a depth-first
     * manner. Keep track of the direction of traversal ('left' or 'right') and the
     * length of the current ZigZag path.
     * 
     * Approach:
     * - Initialize a variable `maxZigZag` to store the maximum ZigZag length.
     * - Start recursion from the root node.
     * - Implement a helper method to traverse the tree while keeping track of the
     *   current direction and path length.
     * - At each node, update the `maxZigZag` if the current path length exceeds it.
     * - Recursively explore the left and right subtrees, changing direction and
     *   updating path length accordingly.
     * - Return the `maxZigZag` value, which contains the longest ZigZag path length.
     * 
     * Time Complexity: O(N) - where N is the number of nodes in the tree. As each
     * node is visited once during the traversal.
     * 
     * Space Complexity: O(H) - where H is the height of the tree. The space is used
     * for the recursive call stack during the traversal.
     * 
     * 
     * Please Note::
     * 
     * For nodes on the left side, the algorithm explores the right child first and then explores the left child. 
     * This means that for nodes on the left, both the right and left subtrees are traversed separately, potentially resulting in twice the traversal.
     * However, despite traversing both the left and right subtrees for nodes on the left side, the time complexity remains O(N) because each node is still visited only once.
     * Although there's additional traversal for nodes on the left side due to exploring both right and left subtrees separately, it doesn't increase the overall time complexity to O(N*2).
     * The algorithm still completes in O(N) time because it visits each node exactly once, even though there's a bit of redundant exploration for nodes on the left side.
     */

    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        helper(root.left, "left", 1);
        helper(root.right, "right", 1);
        return maxZigZag;
    }

    private void helper(TreeNode root, String dir, int length) {
        if (root == null)
            return;

        maxZigZag = Math.max(maxZigZag, length);

        if (dir.equals("left")) {
        	// left-right is zigzag so count will increase
            helper(root.right, "right", length + 1);
        	// right-right is the starting for new tree so passing 1
            helper(root.left, "left", 1);
        } else {
            helper(root.left, "left", length + 1);
            helper(root.right, "right", 1);
        }
    }

    public static void main(String[] args) {
        // Test case
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        ZigZagPathFinder zigZagPathFinder = new ZigZagPathFinder();
        int longestZigZag = zigZagPathFinder.longestZigZag(root);
        System.out.println("Longest ZigZag path length: " + longestZigZag);
    }
}
