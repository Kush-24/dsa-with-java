package com.kush.studyplan.seventyfive.tree;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeBFS {

	public static void main(String[] args) {

	}
	/*
	 * Given the root of a binary tree, imagine yourself standing on the right side of it,
	 *  return the values of the nodes you can see ordered from top to bottom.
	 */
	
	 public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> rightView = new ArrayList<>();
	        rightViewDFS(root, 0, rightView);
	        return rightView;
	    }

	    public void rightViewDFS(TreeNode node, int level, List<Integer> rightView) {
	        if(node == null) return;
	        if(rightView.size() > level)
	           rightView.set(level,node.val);
	        else
	          rightView.add(node.val);

	        rightViewDFS(node.left,level + 1, rightView);
	        rightViewDFS(node.right,level + 1, rightView);
	    }
	    
	    
	    
		public int maxLevelSum(TreeNode root) {
			int max = Integer.MIN_VALUE;
			int ans = 0;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int level = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				level++;
				int currSum = 0;
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					currSum += node.val;
					// System.out.print(" level "+level + " "+node.val);
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
				if (currSum > max) {
					max = currSum;
					ans = level;
				}

			}
			return ans;
		}
		
		/*
 You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. 
If such a node does not exist, return null.
		 */
		
		public TreeNode searchBST(TreeNode root, int val) {
		      if(root == null || root.val == val) return root;
		      if(root.val < val)
		        return searchBST(root.right,val);
		      else 
		       return  searchBST(root.left,val);
		 }

}
