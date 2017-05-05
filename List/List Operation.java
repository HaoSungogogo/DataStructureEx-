//getLength(ListNode head)
int getLength(ListNode list){
	int length = 0;
	while(list != null){
		length ++;
		list = list.next;
	}
	return length;
}

//get(int index)
ListNode get(ListNode head, int index){
	while(index > 0 && head != null){
		index--;
		head = head.next;
	}
	return head;
}

//appendHead(int val, ListNode head)
ListNode appendHead(int val, ListNode head){
	LiseNode newNode = new ListNode(val);
	newNode.next = head;
	return newNode;
}

//appendTail(int val, ListNode head)
ListNode appendTail(int val, ListNode head){
	if(head == null){
		return new ListNode(val);
	}
	ListNode cur = head;
	while(cur.next != null){
		cur = cur.next;
	}
	cur.next = new ListNode(val);
	return head;
}

//ArrayList

Class ArrayList<E>{
	private E[] array;  
	// capacity = array.length;
	private int size;

	private E get(int index){}
	private void set(int index, E e){}
	// size() -> eager computation
	private int size(){
		return this.size;
	}
	private void add(E e){}
	private void add(int index, E e){}
	private E remove(int index){}
}

//LinkedList

// double linked list
Class ListNode<E>{
	private E e;
	private ListNode<E> pre;
	private ListNode<E> next;
}

// wrap the size, head and tail node information
Class LinkedList<E>{
	private ListNode<E> head;
	private ListNode<E> tail;
	private int size;

	private E get(int index){}
	private void set(int index, E e){}
	// size() -> eager computation
	private int size(){
		return this.size;
	}
	private void add(E e){}
	private void add(int index, E e){}
	private E remove(int index){}
}
























