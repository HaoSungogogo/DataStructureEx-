package Map;

import java.util.Arrays;

public class HashMap<K, V> {

	public static class Node<K, V> {
		private final K key;       // key must be final
		private V value;
		Node<K, V> next;
		public Node (K key, V value) {
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

	public static final int DEFAULT_CAPACITY = 16;   // default is static and final
	public static final float DEFAULT_LOAD_FACTOR = 075f;

	private Node<K, V>[] bucket;
	private int size;
	private float loadfactor;
	public HashMap(int cap, float loadfactor) {
		if (cap < 0) {
			throw new IllegalArgumentException("cap could not be smaller than 0");   // throw exception
		}
		this.loadfactor = loadfactor;
		this.bucket = (Node<K, V>[]) new Node[cap];     // compulsory trans
		size = 0;
	}
	public HashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);    // no argument constructor
	}

	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		return this.size == 0;
	}
	public void clear() {
		Arrays.fill(this.bucket, null);
		this.size = 0;
	}

	private int hash(K key) {
		if (key == null) {
			return 0;
		}
		return key.hashCode() & 0X7FFFFFFF;    // no negative
	}

	private int getIndex(K key) {
		return hash(key) % bucket.length;
	}

	private boolean equalsValue(V v1, V v2) {
		if (v1 == null && v2 == null) {
			return true;
		}
		if (v1 == null || v2 == null) {
			return false;
		}
		return v1.equals(v2);
	}

	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		for (Node<K, V> cur : bucket) {
			while (cur != null) {
				if (equalsValue(cur.getValue(), value)) {
					return true;
				}
				cur = cur.next;
			}
		}
		return false;
	}

	private boolean eqaulsKey(K k1, K k2) {
		if (k1 == null && k2 == null) {
			return true;
		}
		if (k1 == null || k2 == null) {
			return false;
		}
		return k1.equals(k2);
	}

	public boolean containsKey (K key) {
		int index = getIndex(key);
		Node<K, V> cur = bucket[index];
		while (cur != null) {
			if (eqaulsKey(cur.getKey(), key)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	public V get(K key) {
		int index = getIndex(key);
		Node<K, V> cur = bucket[index];
		while (cur != null) {
			if (eqaulsKey(cur.getKey(), key)) {
				return cur.getValue();
			}
			cur = cur.next;
		}
		return null;
	}

	public V put(K key, V value) {
		int index = getIndex(key);
		Node<K, V> cur = bucket[index];
		Node<K, V> head = cur;
		while (cur != null) {
			if (eqaulsKey(cur.getKey(), key)) {
				V res = cur.getValue();
				cur.setValue(value);
				return res;
			}
			cur = cur.next;
		}
		Node<K, V> newNode = new Node(key, value);
		newNode.next = head;
		bucket[index] = newNode;
		size++;      // update size
		if (needRehashing()) {
			rehashing();
		}
		return null;
	}

	private boolean needRehashing() {
		float ratio = (this.size + 0.0f) / this.bucket.length;  // cast float
		return ratio >= this.loadfactor;
	}
	private void rehashing() {}

	public V remove(K key) {
		size--;
	}
}
