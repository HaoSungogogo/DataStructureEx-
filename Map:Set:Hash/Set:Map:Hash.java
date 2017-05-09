Set: no duplicate element
HashSet: best performance (is kind of HashTable)
TreeSet: implemented by red-black-tree(balanced binary search tree), have order.
LinkedHashSet: combine the HashSet and LinkedList

HashMap
Common API:
V put(K key, V value)
V get(K key)
V remove(K key)
boolean containsKey(K key)
Set<Map.Entry<K,V>> entrySet()  get set view of all entries in the HashMap
Set<K> keySet() get set view of all the keys in the HashMap
Collection<V> values() get collection view of all the values in the HashMap

* HashTable doesn not allow null key, HashMap allows
* HashTable is synchronized and performance is poor.
* HashMap can only have one null Key, it is always mapped to bucket 0.