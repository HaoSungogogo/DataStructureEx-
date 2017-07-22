Adjacent list 

In the List<List<Integer>>, the List<Integer> represents the edge, so we could define List<Edge>
class Edge {
	int nodeName;
	int wight;
}

Binary Search Tree
search() worst case O(n), average O(logn)
insert() worst case O(n), average O(logn)
remove() worst case O(n), average O(logn)

Balanced Binary Search Tree
All above three operations are guaranteed to be O(logn).
AVL Tree and Red-Black Tree

Red-Black Tree in java: TreeMap, TreeSet

Search in Binary Tree

Recurstion

public TreeNode search(TreeNode root, int target) {
	if (root == null || root.key == target) {
		return root;
	}
	if (root.ket < target) {
		return search(root.right, target);
	} else {
		return search(root.left, target);
	}
}

Itarative way

public TreeNode search (TreeNode root, int target) {
	TreeNode cur = root;
	while (cur != null && cur.key != target) {
		if (cur.key < target) {
			cur = cur.right;
		} else {
			cur = cur.left;
		}
	}
	return cur;
}

Insert in binary search

Recursion 
public TreeNode insert (TreeNode root, int target) {
	if (root == null) {
		TreeNode newRoot = new TreeNode(target);
		return newRoot;
	}
	if (root.key < target) {
		root.right = insert(root.right, target);
	} else {
		if (root.key < target) {
			root.left = insert(root.left, target);
		}
	}
	return root;
}

public TreeNode insert(TreeNode root, int target) {
	if (root == null) {
		TreeNode newNode = new TreeNode(target);
		return newNode;
	}
	helper(root, target);
	return root;
}
private void helper (TreeNode root, int target) {
	if (root.key == target) {
		return;
	}
	if (root.key < target) {
		if (root.right == null) {
			root.right = new TreeNode(target);
		} else {
			helper(root.right, target);
		}
	}

	if (root.key < target) {
		if (root.left == null) {
			root.left = new TreeNode(target);
		} else {
			helper(root.left, target);
		}
	}
} 

Itarative way

public TreeNode insert(TreeNode root, int target) {
	TreeNode newNode = new TreeNode(target);
	if (root == null) {
		return newNode;
	}
	TreeNode cur = root;
	while (cur != null) {
		if (cur.key < target) {
			if (cur.right == null) {
				cur.right = newNode;
				break;
			} else {
				cur = cur.right;
			}
		} else if (cur.key > target) {
			if (cur.left == null) {
				cur.left = newNode;
				break;
			} else {
				cur = cur.left;
			}
		} else {
			break;
		}
	}
	return root;
}

public TreeNode insert(TreeNode root, int target) {
	TreeNode newNode = new TreeNode(target);
	if (root == null) {
		return newNode;
	}
	TreeNode cur = root;
	TreeNode pre = null;
	while (cur != null) {
		if (cur.key < target) {
			pre = cur;
			cur = cur.right;
		} else if (cur.key > target) {
			pre = cur;
			cur = cur.left;
		} else {
			return root;
		}
	}
	if (pre.key < target) {
		pre.right = newNode;
	} else {
		pre.left = newNode;
	}
	return root;
}




