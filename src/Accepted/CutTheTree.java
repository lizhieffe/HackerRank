package Accepted;

import static org.junit.Assert.*;

import org.junit.Test;

import Util.TreeNode;


public class CutTheTree {
	private int result = Integer.MAX_VALUE;
	private int sum = 0;
	public int getMinDiff(TreeNode node) {
		if (node == null)
			return 0;
		getSum(node);
		findCut(node);
		return result;
	}
	
	private int findCut(TreeNode node) {
		int result = node.val;
		if (node.left != null) {
			int left = findCut(node.left);
			if (Math.abs(this.sum - 2 * left) < this.result)
				this.result = Math.abs(this.sum - 2 * left);
			result += left;
		}
		if (node.right != null) {
			int right = findCut(node.right);
			if (Math.abs(this.sum - 2 * right) < this.result)
				this.result = Math.abs(this.sum - 2 * right);
			result += right;
		}	
		return result;
	}
	
	private void getSum(TreeNode node) {
		if (node == null)
			return;
		this.sum += node.val;
		getSum(node.left);
		getSum(node.right);
	}
	
	@Test
	public void tc01() {
		TreeNode root = new TreeNode(100);
		root.right = new TreeNode(200);
		root.right.left = new TreeNode(100);
		root.right.right = new TreeNode(100);
		root.right.left.left = new TreeNode(500);
		root.right.left.right = new TreeNode(600);
		CutTheTree service = new CutTheTree();
		int result = service.getMinDiff(root);
		assertTrue(result == 400);

	}
}
