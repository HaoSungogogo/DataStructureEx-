Deque could be implemented by LinkedList and ArrayDequeue
We just use LinkedList to implement Queue and Deque interface.
ArrayDequeue: no null value in Deque

Using deque as stack

Deque<Integer> stack = new LinkedList<>();
stack.offerFrist();
stack.pollFirst();
stack.peekFirst();

Queue<Integer> qu = new LinkedList<>();
qu.offer();
qu.poll();
qu.peek();

For Queue
throw exception           return special value (null, false)
add(e)					  offer(e)
remove()				  poll()
element()				  peek()