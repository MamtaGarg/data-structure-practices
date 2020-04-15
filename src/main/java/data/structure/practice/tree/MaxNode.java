package data.structure.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNode {
	static class Node {
		int data;
		Node left;
		Node right;
	}

	/*
	 * Helper function that allocates a new node with the given data and NULL left
	 * and right pointers.
	 */
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return (node);
	}

	static int maxNodeLevel(Node root) {
		// Base case
		if (root == null)
			return -1;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		int currentLevel = 0;

		int maxCount = Integer.MIN_VALUE;

		int maxNodesLevel = 0;

		while (true) {
			int countNodeLevelWise = queue.size();

			if (countNodeLevelWise == 0)
				break;

			if (countNodeLevelWise > maxCount) { // update maxCount having maximum no. of nodes and maxNodesLevel with currentLevel accordingly.
				maxCount = countNodeLevelWise;
				maxNodesLevel = currentLevel;
			}

			// get current level and move to the left or right of the tree
			while (countNodeLevelWise > 0) {
				Node node = queue.peek();
				queue.remove();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				countNodeLevelWise--;
			}
			currentLevel++; // Increment currentLevel for the next level
		}
		return maxNodesLevel;
	}

	// Driver program to test above
	public static void main(String[] args) {
		// binary tree formation
		Node root = newNode(1); /* 2 */
		root.left = newNode(2); /* / \ */
		root.right = newNode(3); /* 1 3 */
		root.right.left = newNode(4); /* / \ \ */
		root.right.right = newNode(5); /* 4 6 8 */
		root.right.left.left = newNode(3); /* / \ \ */
		root.right.left.right = newNode(4); /* 4 6 8 */
		root.right.right.left = newNode(5); /* / \ \ */
		root.right.right.right = newNode(7); /* 4 6 8 */

		System.out.println("Level having maximum number of Nodes : " + maxNodeLevel(root));
	}

}
