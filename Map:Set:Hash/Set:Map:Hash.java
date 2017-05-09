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

Very Important:
key.hashCode() -> to determine the entry index of the key
key.equals() -> to determine whether two keys are the same keys
Defined in Object class.
The default implementation of equals() is to check if two references are pointed to the same object.
The default implementation of hashCode() returns a "unique hash value" for the object based on its memory address.

The important point!!!!
there is a contract between equals() and hashCode(), the developer need to maintain:
(1): if one.equals(two), then one.hashCode() == two.hashCode()
(2): if one.hashCode() == two.hashCode(), it is not necessary to maintain one.equals(two).
When you want to override equals(), please definitely override hashCode() as well.

Rehashing when it exceeds the load factor 0.75: number of <key, value> pair / number of buckets