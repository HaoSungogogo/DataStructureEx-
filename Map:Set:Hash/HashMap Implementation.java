// class Entry<K, V>{
// 	final K key;  
// 	// final, we could not change it
// 	private V value;
// 	private Entry<K, V> next;
// 	public Entry(K key, V value){
// 		this.key = key;
// 		this.value = value;
// 	}
// 	public K getKey(){
// 		return this.key;
// 	}
// 	public V getValue(){
// 		return this.value;
// 	}
// 	public void setValue(int value){
// 		this.value = value;
// 	}
// }

// class HashMap<K, V>{
// 	private Entry<K, V>[] array;
// 	private int hash(K key){
// 		if(key == null){
// 			return 0;
// 		}
// 		return key.hashCode() & Integer.MAX_VALUE;
// 	}
// 	private int getIndex(int hashNumber){
// 		return hashNumber % this.array.length;
// 	}
// }

Implementation of HashSet

Common API
boolean add(E e)
boolean remove(Object o)
boolean contains(Object o)
int size()
boolean isEmpty()

public HashSet<K>{
	private HashMap<K, Object> map;
	//special object used for existing keys
	private static final Object PRESENT = new Object();
	public HashSet(){
		map = new HashMap<K, Object>();
	}
	public boolean contains(K key){
		return map.containsKey(key);
	}
	public boolean add(K key){
		return map.put(key, PRESENT) == null;
	}
}

Implementation of HashMap

public class MyHashMap<K, V> {
	public static class Node<K, V> {
		private final K key;
		private V value;
		public Node<K, V> next;
		public Node<K, V> (K key, V value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return this.key;
		}
		public V getValue() {
			return this.value;
		}
		public void setValue(V value) {
			this.value = value;
		}
	}

	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private Node<K, V> [] array;
	private int size;
	private float loadfactor;

	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	public MyHashMap(int cap, float loadfactor) {
		if(cap <= 0) {
			throw new IllegalArgumentException("cap could not be <= 0");
		}
		this.array = (Node<K, V>[]) (new Node[cap]);
		this.size = 0;
		this.loadfactor = loadfactor;
	}

	public int size() {
		return this.size();
	}

	public boolean isEmpty() {
		return this.size == 0; 
	}

	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}

	private int hash(K key) {
		if(key == null) {
			return 0;
		}
		return key.hashCode() & Integer.MAX_VALUE;
	}

	private int getIndex(K key) {
		return hash(key) % array.length;
	}

	public boolean containsKey(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
		while(node != null) {
			if (equalsKey(node.getKey(), key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	private boolean equalsKey(K k1, K k2) {
		if (k1 == null && k2 == null) {
			return true;
		}
		if(k1 == null || k2 == null) {
			return false;
		}
		return k1.equals(k2);
	}

	public V get(K key) {
		int index = getIndex(key);
		Node<K, V> node = this.array[index];
		while(node != null) {
			if(equalsKey(node.getKey, key)) {
				return node.getValue;
			}
			node = node.next;
		}
		return null;
	}

	public V put(K key, V value) {
		int index = getIndex(key);
		Node<K, V> node = this.array[index];
		Node<K, V> head = node;
		while(node != null) {
			if(equalsKey(node.getKey, key)) {
				node.setValue(value);
				return value;
			}
			node = node.next;
		}
		Node<K, V> newNode = new Node(key, value);
		newNode.next = head;
		// need to reconnect
		this.array[index] = newNode;
		size++;
		if(needRehashing()) {
			rehashing();
		}
		return null;
	}

	public boolean containsValue(V value) {
		if(isEmpty()) {
			return false;
		}
		for(Node<K, V> node : this.array){
			while(node != null) {
				if(equalsValue(node.getValue, value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}

	private boolean equalsValue(V v1, V v2) {
		if (v1 == null && v2 == null) {
			return true;
		}
		if(v1 == null || v2 == null) {
			return false;
		}
		return v1.equals(v2);
	}

	private boolean needRehashing() {
		 return ((this.size + 0.0f) / this.array.length) > loadfactor;
	}
	private boolean rehashing() {}

	public V remove(K key) {
		int index = getIndex(key);
		Node<K, V> node = this.array[index];
		Node<K, V> dummy = new Node<K, V>();
		dummy.next = node;
		Node<K, V> pre = dummy;
		while(node != null) {
			if(equalsKey(node.getKey, key)) {
				pre.next = node.next;
				node.next = null;
				size--;
				this.array[index] = dummy.next;
				return node.getValue;
			}
			node = node.next;
			pre = pre.next;
		}
		return null;
	}

}














