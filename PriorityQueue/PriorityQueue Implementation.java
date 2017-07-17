Heap: a binary tree based data structure.
min-heap property: a) The parent node is always smaller than its child nodes
				      Differing from BST, due to no relation with its child nodes.
				   b) Common implementation not necessary -> complete binary tree

left child of index l = 2 * i + 1
right child of index r = 2 * i + 2
parent node of index p = (i - 1) / 2

Heapify
O(n)
For each node that has at least one child, we perform percolateDown(), in the order from the node one the deepest level to the root.
If the heap has n elements, the range of indeces perfroming percolateDown() is [0, n / 2 - 1]

Other Operation:
Update()
1) if we know the position of element you want to update, it will take O(nlogn)
	either you need percolateDown() or percolateUp()
2) if we do not know the position, without addtional data structure to help, O(n)

Implementation of Capacity limited min-heap

public class MinHeap {
	private int[] array;
	private int size;

	//Constructor
	public MinHeap(int cap) {
		if (cap < 0) {
			throw new IllegalArgumentException("capacity should not be negative");
		}
		array = new int[cap];
		size = 0;
	}

	public MinHeap(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("input array is invalid");
		}
		this.array = arr;
		size = this.array.length;
		heapify();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == array.length;
	}

	private void heapify() {
		for (int i = this.size() / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}

	private void percolateUp(int index) {
		while(index > 0) {
			int parent = (index - 1) / 2;
			if (array[parent] > array[index]) {
				swap(array, index, parent);
				index = parent;
			} else {
				return;
			}
		}
	}

	private void percolateDown(int index) {
		while(index <= this.size / 2 - 1) {
			int leftChild = index * 2 + 1;
			int rightChild = index * 2 + 2;
			int candidate = leftChild;
			if (rightChild < this.size && array[rightChild] < array[leftChild]) {
				candidate = rightChild;
			}
			if (array[candidate] < array[index]) {
				swap(array, index, candidate);
				index = candidate;
			} else {
				return;
			}
		}
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public int peek() {
		if(this.isEmpty) {
			return -1;
		}
		return this.array[0];
	}

	public int poll() {
		if(this.isEmpty) {
			return -1;
		}
		int res = this.array[0];
		this.array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return res;
	}

	public void offer(int ele) {
		if (this.isFull()) {
			int[] newArray = new int[(int)(this.size() * 1.5)];
			for (int i = 0; i < this.array.length; i++) {
				newArray[i] = this.array[i];
			} 
			this.array = newArray;
		}
		array[size++] = ele;
		percolateDown(size - 1);
	}

	// return the original value
	public int update(int index, int element) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundException("invalid index range");
		}
		int cur = array[index];
		array[index] = element;
		if (cur < element) {
			percolateDown(index);
		} else {
			percolateUp(index);
		}
		return cur;
	}
}


