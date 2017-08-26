Two complement could represent -2^(n - 1) ~ 2^(n - 1) - 1
Integer.MIN_VALUE = 10000000 00000000 00000000 00000000
Integer.MAX_VALUE = 01111111 11111111 11111111 11111111

Overflow
Integer.MAX_VALUE + 1 = Integer.MIN_VALUE;
Integer.MIN_VALUE - 1 = Integer.MAX_VALUE;

Signed Shift >>
符号位不动，填充与符号位一样的bit， similar to divide two取整
Unsigned Shift >>>
only add 0

Wrapper class
1. Generic type could not be primitive type
2. represent not exist -> null

Wrapper class object are "immutable" -> internal values can not be changed after initialization

class Integer implements Comparable<Integer> {
  private final int value;
  public Integer (int value) {
    this.value = value;
  }
  public int intValue() {
    return this.value;
  }
  public Integer plus (Integer another) {
    return Integer.valueOf(this.value + another.intValue());
  }
  @Override
  public int compareTo (Integer another) {
    if (this.value == another.intValue()) {
      return 0;
    }
    return this.val < another.intValue() ? -1 : 1;
  }
}

Autoboxing (complier does)
Unboxing is done when it is necessary. +-*/><= only applied to primitive type, so it is unboxing automatically.

what happened when Integer++ ("immutable")
int val = a.intValue();
val++;
a = Integer.valueOf(val);

Be careful "=="
Integer a = 5;
Integer b = 5;
System.out.println(a == b); true -> pool

a = 129;
b = 129;
System.out.println(a == b); false

Integer Class cache the Integer object with value from -128 ~ 127

int[] and Integer[]
It is totally different and there is no directly conversion between them

String

class String {
  private final char[] value;
  private int offset;
  private int count;
}

Pooling for String objects
JVM and complier would maintain an intern area in Heap, for the same String literal, it will only have
one String object associated.

only 字符串常量才放到pool中
变量代替不是字符串常量
常量 -> compile time could tell
非常量 -> runtime could tell

compile find the usual string and make a marker on it
run time put them into cache (cache only in the run time) -> intern pool (一般是字符串常量)

1.String s = new String("abc");创建了几个String对象。
答案是2个，一个是字符串字面常数，在字符串池中。一个是new出来的字符串对象，在堆中。
2.String s1 = "abc";
   String s2 = "a";
   String s3 = s2 + "bc";
   String s4 = "a" + "bc";
   String s5 = s3.intern();
请问s1==s3是true还是false，s1==s4是false还是true。s1==s5呢？
此题注意两点，因为s2是一个变量，所以s3是运行时才能计算出来的字符串，是new的，在堆中不在字符串池中。
s4是通过常量表达式计算出来的，他等同于字符串字面常数，在字符串池中。所以，s1!=s3，s1==s4。
再看s5，s5是s3放到字符串池里面返回的对像，所以s1==s5。
这里新手要注意的是，s3.intern()方法，是返回字符串在池中的引用，并不会改变s3这个变量的引用，
就是s3还是指向堆中的那个"abc"，并没有因调用了intern()方法而改变，实际上也不可能改变。

Constructor
String()
String(String value)
String(char[] array)
String(char[] array, int offset, int length)
String(StringBuilder sb)

StringBuffer and StringBuilder
List<Character> list.
StringBuffer is thread-safe, every operation is synchronized
StringBuilder is not thread-safe.

Strategy in String
1. to char[]
2. use StringBuilder
