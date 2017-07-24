Search in BST

Recursive

public TreeNode search(TreeNode root, int target) {
	if (root == null || root.key) {
		return root;
	}
	if (root.key < target) {
		return search(root.right, target);
	} else {
		return search(root.left, target);
	}
}

Iterative

public TreeNode search(TreeNode root, int target) {
	TreeNode cur = root;
	while (cur != null) {
		if (cur.key == tareget) {
			break;
		}
		if (cur.key < target) {
			cur = cur.right;
		} else {
			cur = cur.left;
		}
	}
	return cur;
}

Insert in BST

Recursive

public TreeNode insert(TreeNode root, int target) {
	if (root == null) {
		TreeNode newNode = new TreeNode(target);
		return newNode;
	}
	if (root.key < target) {
		root.right = insert(root.right, target);
	} else if (root.key > target) {
		root.left = insert(root.left, target);
	}
	return root;
}

public TreeNode insert(TreeNode root, int target) {
	if (root == null) {
		TreeNode newNode = new TreeNode(target);
		return newNode;
	}
	recursion(root, target);
	return root;
}
private void recursion(TreeNode root, int target) {
	if (root.key == target) {
		return;
	}
	if (root.key < target) {
		if (root.right == null) {
			root.right = new TreeNode(target);
			return;
		} else {
			recursion(root.right, target);
		}
	}
	if (root.key > target) {
		if (root.left == null) {
			root.left = new TreeNode(target);
			return;
		} else {
			recursion(root.left, target);
		}
	}
}

Iterative

public TreeNode insert(TreeNode root, int target) {
	TreeNode newNode = new TreeNode(target);
	if (root == null) {
		return newNode;
	}
	TreeNode cur = root;
	while (cur != null) {
		if (cur.key == root) {
			break;
		} else if (cur.key < target) {
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
		}
	}
	return root;
}

public TreeNode insert(TreeNode root, int target) {
	TreeNode newNode = new TreeNode(target);
	if (root == null) {
		return newNode;
	}
	TreeNode pre = null;
	Treenode cur = root;
	while (cur != null) {
		if (cur.key == target) {
			return root;
		}
		if (cur.key < target) {
			pre = cur;
			cur = cur.right;
		} else {
			pre = cur;
			cur = cur.left;
		}
	}
	if (pre.key < target) {
		pre.right = newNode;
	} else {
		pre.left = newNode;
	}
	return root;
}

Delete in BST

public TreeNode delete(TreeNode root, int target) {
	if (root == null) {
		return root;
	}
	if (root.key < target) {
		root.right = delete(root.right, target);
		return root;
	}
	if (root.key > target) {
		root.left = delete(root.left, target);
		return root;
	}
	if (root.left == null) {
		return root.right;
	}
	if (root.right == null) {
		return root.left;
	}
	TreeNode pre = root;
	TreeNode cur = root.right;
	while (cur.left != null) {
		pre = cur;
		cur = cur.left;
	}
	pre.left = cur.right;
	cur.left = root.left;
	cur.right = root.right;
	return cur;
}

Iteration 

pre-order: Using Stack

public void preOrder(TreeNode root) {
	if(root == null) {
		return;
	}
	Deque<TreeNode> stack = new LinkedList<>();
	stack.offerFirst(root);
	while (!stack.isEmpty()) {
		TreeNode cur = stack.pollFirst();
		System.out.println(cur.key);
		if (cur.right != null) {
			stack.offerFirst(cur.right);
		}
		if (cur.left != null) {
			stack.offerFirst(cur.left);
		}
	} 
}

in-order: Using stack with helper node to decide whether left subtree is null

public void inOrder(TreeNode root) {
	if (root == null) {
		return;
	}
	Deque<TreeNode> stack = new LinkedList<>();
	stack.offerFirst(root);
	TreeNode helper = root.left;
	while (!stack.isEmpty()) {
		if (helper != null) {
			stack.offerFirst(helper);
			helper = helper.left;
		} else {
			TreeNode cur = stack.pollFirst();
			System.out.println(cur.key);
			helper = helper.right;
		}
	}
}

post-order

1. Solved by reversing the changed preoder result.
2. Using the traversing direction of that node.
if pre == null -> going down, left is priority
if pre is parent of cur -> going down, left is priority
if pre = cur.left -> left subtree is finished, going cur right
if pre = cur.right -> pop cur, going up.

public void postOrder(TreeNode root) {
	if (root == null) {
		return;
	}
	TreeNode pre = null;
	Deque<TreeNode> stack = new LinkedList<>();
	stack.offerFirst(root);
	while (!stack.isEmpty()) {
		TreeNode cur = stack.peekFirst();
		if (pre == null || pre.left = cur || pre.right = cur) {
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			} else if (cur.right != null) {
				stack.offerFirst(cur.right);
			} else {
				stack.pollFirst(cur);
				System.out.println(cur.key);
			}
		}
		if (pre = cur.left) {
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			} else {
				stack.pollFirst(cur);
				System.out.println(cur.key);
			}
		}
		if (pre = cur.right) {
			stack.pollFirst(cur);
			System.out.println(cur.key);
		}
		pre = cur;
	}
}








