Two ways to implement Stack and Queue
1. LinkedList
2. Array


Part I using LinkedList

implementation of Stack

class ListNode{
	public int value;
	public ListNode next;
}

public class Stack{
	private ListNode head;
	public Stack(){
		head = null;
	}
	public Integer pop(){
		if(this.head == null){
			return null;
		}
		ListNode pre = head;
		head = head.next;
		pre.next = null;
		return pre.value;
	}
	public Integer peek(){
		if(this.head == null){
			return null;
		}
		return head.value;
	}
	public void push(Integer ele){
		ListNode newNode = new ListNode(ele);
		newNode.next = this.head;
		head = newNode;
	}
}

implementation of Queue

class ListNode{
	public int value;
	public ListNode next;
}

public class Queue{
	private ListNode head;
	private ListNode tail;

	public Queue(){
		head = null;
		tail = null;
	}

	public Integer poll(){
		if(head == null){
			return null;
		}
		ListNode res = head;
		head = head.next;
		res.next = null;
		if(head == null){
			tail = null;
		}
		return res.value;
	}

	public Integer peek(){
		if(head == null){
			return null;
		}
		return head.value;
	}

	public void offer(Integer ele){
		if(head == null){
			head = new ListNode(ele);
			tail = head;
		}else{
			tail.next = new ListNode(ele);
			tail = tail.next;
		}
	}
}

Part II using Array to implement

Using Circular Array to implement Queue

public class BoundedQueue{
	private Integer[] array;
	private int size;
	private int head;
	private int tail;

	public BoundedQueue(int cap){
		array = new Integer[cap];
		size = 0;
		head = 0;
		tail = 0;
	}

	public boolean offer(Integer val){
		if (size == array.length){
			return false;
		}else{
			array[tail] = val;
			tail = tail + 1 == array.length? 0 : tail + 1;
			size++;
			return true;
		}
	}

	public Integer poll(){
		if(size == 0){
			return null;
		}
		Integer res = array[head];
		head = head + 1 == array.length ? 0 : head + 1;
		size--;
		return res;
	}

	public Integer peek(){
		if(size == 0){
			return null;
		}
		return array[head];
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public boolean isFull(){
		return this.size == this.array.length;
	}
}


public class BoundedStack{
	private Integer[] array;
	private int head;

	public BoundedStack(int cap){
		array = new Integer[cap];
		head = 0;
	}

	public boolean push(Integer val){
		if(head == array.length){
			return false;
		}else{
			array[head++] = val;
			return true;
		}
	}

	public Integer pop(){
		if(head == 0){
			return null;
		}else{
			return array[head--];
		}
	}

	public Integer top(){
		if(head == 0){
			return null;
		}else{
			return array[head];
		}
	}
}


