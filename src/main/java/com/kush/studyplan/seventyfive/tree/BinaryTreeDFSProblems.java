package com.kush.studyplan.seventyfive.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeDFSProblems {
	public static void main(String[] args) {
		
	}

	/*
	 * A binary tree's maximum depth is the number of nodes along the 
	 * longest path from the root node down to the farthest leaf node.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
	
	
	/*
	 * Consider all the leaves of a binary tree, from left to right order, 
	 * the values of those leaves form a leaf value sequence
	 */
	
	 public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	        List<Integer> one=new ArrayList<>();
	        List<Integer> two=new ArrayList<>();
	        getLeafNodes(root1,one);
	        getLeafNodes(root2,two);

	        if(one.size() !=two.size())
	        return false;
	        
	        for(int i=0;i<one.size();i++){
	            if(one.get(i) != two.get(i))
	            return false;
	        }
	        return true;
	    }
	 
	    public void getLeafNodes(TreeNode root,List<Integer> set){
	        if(root == null) return ;
	        if(root.left == null && root.right == null){
	            set.add(root.val);
	            return;
	        }
	        getLeafNodes(root.left,set);
	        getLeafNodes(root.right,set);
	    }
	    
	    /*
	    Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
	    Return the number of good nodes in the binary tree.
	    */
	    
	    int cnt=0;
	    public int goodNodes(TreeNode root) {
	         getGoodNodesCounts(root,Integer.MIN_VALUE);
	         return cnt;
	    }
	    public void getGoodNodesCounts(TreeNode root,int max){
	       if(root == null) return;
	      // System.out.println(root.val +" "+max+" "+cnt);
	       if(root.val >= max) cnt++;
	       max=Math.max(root.val,max);
	       getGoodNodesCounts(root.left,max);
	       getGoodNodesCounts(root.right,max);
	    }
	    
	    //without taking class level variable
	    
	    public int goodNodes2(TreeNode root) {
	        return dfs(root, Integer.MIN_VALUE);
	    }
	    private int dfs(TreeNode root, int max) {
	        if(root == null) return 0;
	        int cnt = (root.val >= max) ? 1 : 0;
	        max = Math.max(max, root.val);
	        return cnt + dfs(root.left, max) + dfs(root.right, max);
	    }

	     
}
