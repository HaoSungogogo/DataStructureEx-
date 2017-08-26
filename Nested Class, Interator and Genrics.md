Class
top-level Class
Nested Class:
  Static Nested Class:
    Only nested class could be declared as static class
    OuterClass.NestedStaticClass c1 = new OuterClass.NestedStaticClass();
    eg: Map.Entry<K, V>
    Static Nested Class can only access static member of OuterClass

  Non Nested Class (Inner class) -> inner which means that it is in the instance
    Inner class belongs to an object, so it needs an instance of OuterClass
    Inner class can access both static and nonstatic members of the OuterClass, so Inner class can make program
    simple and concise.
    OuterClass outer = new OuterClass();
    OuterClass.InnerClass inner = outer.new InnerClass();

  Local Class (defined in method)
    anonymous (Runnable, Comparator)


Static method can only be declared in a static class or top-level class
Prefer static to inner class (every instance would have its own class, costly)

Helper Class
bundle related support functionality -> top-level class in a file but not public

Iterator:
iterate through a collection of object
next()
hashNext()
remove()
for (Iterator<Apple> iter = list.iterator(); iter.hasNext();) {
  Apple apple = iter.next();
  System.out.println(apple);
}

ListIterator:
the cursor position always lies between the element that would be returned by previous()
and element returned by next();
previous()
previousIndex()
hasPrevious()
nextIndex()
for (ListIterator<Integer> it = list.listIterator(); it.hasNext();) {
  System.out.prinln(it.next());
  if (it.hasNext()) {
    System.out.println("One step forward: " + it.next());
    System.out.println("One step backward: " + it.previous());
  }
}

Generics (check in the compile time)
Types are parameter.
subclass can be cast to superclass, but the generics is different
List<Fruit> is different with List<Apple>

to get data use <? extends>, to write data to use <? super>

Generics methods and class
with a single method declaration, a set of related methods
with a single class declaration, a set of related types.

Generics method
public <E> void func(E e) {}
generics must be declared before return value.

Generics class
class Pair<K, V> {
  private K k;
  private V v;
  public Pair(K k, V v) {}
  public void setKey() {}
}
generics would be declared at the beginning, then the function in the class does not need declare generics again.

Type parameter only can represent reference type.
Want to restrict type you want to pass in.  <E extends Comparable<E>> -> declare upper bound

enum

public enum Websites {
  Yahoo("http://yahoo.com"),
  Google("http://google.com");
  private String url;
  private Websites (String url) {
    this.url = url;
  }
  public String getString() {
    return this.url;
  }
}
String res = Websites.Google.getUrl();


IO
i/o is aimed to memory.
read() using int return -> using signed bit -1 to decide whether it has completed reading.
file close must be down in finally, to make sure the file can be closed.

Common read and write Operation
read line by line
FileInputStream cin = new FileInputStream("/Users/sunhao/Desktop/test.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(cin));
String line = null;
while ((line = br.readLine()) != null) {
	System.out.println(line);
}
br.close();

Standard Input
Scanner scan = new Scanner(System.in);
String line = null;
while ((line = scan.nextLine()) != null) {
  System.out.println(line);
}
