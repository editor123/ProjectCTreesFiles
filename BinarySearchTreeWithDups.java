import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T> {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
	}

	@Override
	public boolean add(T newEntry) {
		if (isEmpty()) {
			return super.add(newEntry);
		} else {
			return addEntryHelperNonRecursive(newEntry);
		}
	}

	// IMPLEMENT THIS METHOD; THIS METHOD CANNOT BE RECURSIVE
	private boolean addEntryHelperNonRecursive(T newEntry) {
		BinaryNode<T> currentNode = root;
		boolean added = false;

		while (!added) {
			int comparison = newEntry.compareTo(currentNode.getData());
			if (comparison < 0) { // newEntry < currentNode.data
				if (currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
				} else {
					currentNode.setLeftChild(new BinaryNode<>(newEntry));
					added = true;
				}
			} else if (comparison > 0) { // newEntry > currentNode.data
				if (currentNode.hasRightChild()) {
					currentNode = currentNode.getRightChild();
				} else {
					currentNode.setRightChild(new BinaryNode<>(newEntry));
					added = true;
				}
			} else { // newEntry == currentNode.data
				if (currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
				} else {
					currentNode.setLeftChild(new BinaryNode<>(newEntry));
					added = true;
				}
			}
		}
		return true;
	}

	// THIS METHOD CANNOT BE RECURSIVE.
	// Make sure to take advantage of the sorted nature of the BST!
	public int countIterative(T target) {
		int count = 0;
		if (root == null) {
			return 0;
		}

		Stack<BinaryNode<T>> nodeStack = new Stack<>();
		nodeStack.push(root);

		while (!nodeStack.isEmpty()) {
			BinaryNode<T> currentNode = nodeStack.pop();
			if (target.equals(currentNode.getData())) {
				count++;
			}

			// Push right child first so left is processed first (LIFO)
			if (currentNode.hasRightChild()) {
				nodeStack.push(currentNode.getRightChild());
			}
			if (currentNode.hasLeftChild()) {
				nodeStack.push(currentNode.getLeftChild());
			}
		}
		return count;
	}

	// THIS METHOD MUST BE RECURSIVE!
	// You are allowed to create a private helper.
	// Make sure to take advantage of the sorted nature of the BST!
	public int countGreaterRecursive(T target) {
		return countGreaterRecursiveHelper(root, target);
	}

	private int countGreaterRecursiveHelper(BinaryNode<T> node, T target) {
		if (node == null) {
			return 0;
		}

		int count = 0;
		if (node.getData().compareTo(target) > 0) {
			count++;
			count += countGreaterRecursiveHelper(node.getLeftChild(), target);
			count += countGreaterRecursiveHelper(node.getRightChild(), target); // Add this line
		} else if (node.getData().compareTo(target) == 0){
			count += countGreaterRecursiveHelper(node.getRightChild(), target);
		}
		else {
			count += countGreaterRecursiveHelper(node.getRightChild(), target);
		}

		return count;
	}

	// THIS METHOD CANNOT BE RECURSIVE.
	// Hint: use a stack!
	// Make sure to take advantage of the sorted nature of the BST!
	public int countGreaterIterative(T target) {
		int count = 0;
		if (root == null) {
			return 0;
		}

		Stack<BinaryNode<T>> nodeStack = new Stack<>();
		nodeStack.push(root);

		while (!nodeStack.isEmpty()) {
			BinaryNode<T> currentNode = nodeStack.pop();
			if (currentNode.getData().compareTo(target) > 0) {
				count++;
				// Push left and right children if they exist
				if (currentNode.hasRightChild()) {
					nodeStack.push(currentNode.getRightChild());
				}
				if (currentNode.hasLeftChild()) {
					nodeStack.push(currentNode.getLeftChild());
				}
			} else if (currentNode.getData().compareTo(target) == 0){
				if (currentNode.hasRightChild()){
					nodeStack.push(currentNode.getRightChild());
				}
			}
			else {
				if (currentNode.hasRightChild()) {
					nodeStack.push(currentNode.getRightChild());
				}
			}
		}

		return count;
	}

	// For full credit, the method should be O(n).
	// You are allowed to use a helper method.
	// The method can be iterative or recursive.
	public int countUniqueValues() {
		if (root == null) {
			return 0;
		}
		Set<T> uniqueValues = new HashSet<>();
		Stack<BinaryNode<T>> nodeStack = new Stack<>();
		nodeStack.push(root);

		while (!nodeStack.isEmpty()) {
			BinaryNode<T> currentNode = nodeStack.pop();
			uniqueValues.add(currentNode.getData());

			if (currentNode.hasRightChild()) {
				nodeStack.push(currentNode.getRightChild());
			}
			if (currentNode.hasLeftChild()) {
				nodeStack.push(currentNode.getLeftChild());
			}
		}
		return uniqueValues.size();
	}
}