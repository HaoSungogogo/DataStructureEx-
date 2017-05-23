Two ways to realize the order of PriorityQueue

1. the element type implements Comparable interface and thus implements the required method 
   int compareTo(E ele){}

   interface Comparable<E>{
    int compareTo(E ele);
   }

   Example:
   class Integer implements Comparable<Integer>{
    private int val;
    public Integer(int val){
      this.val = val;
    }
    @Override
    int compareTo(Integer another){
      if(this.val == another.val){
        return 0;
      }
      return this.val < another.val ? -1 : 1;
    }
   }

   class Cell implements Comparable<Cell>{
    private int row;
    private int col;
    private int val;
    public Cell(int row, int col, int val){
      this.row = row;
      this.col = col;
      this.val = val;
    }
    @Override
    int compareTo(Cell another){
      if(this.val == another.val){
        return 0;
      }
      return this.val < another.val ? -1 : 1;
    }
   }

   *******the return value of compareTo determines the order: -1 this has higher priority than another.*******

2. provide Comparator<E> class to compare elements, and pass an comparator object to the PriorityQueue.

   interface Comparator<E>{
    int compare(E o1, E o2);
   }

   ********If the class has already implements Comparable interface, we need another way to order elements in our PriorityQueue,
   we can pass the new Comparator.

   // Constructor
   PriorityQueue(int capacity, Comparator<? super E> comparator){}

   a utility method Collections.reverseOrder() returns a Comparator that reverses the natural order.

   *****if E already implements Comparable<E>, but still provides a Comparator. 
   PriorityQueue would choose the order specified in Comparator********

   Anonymous inner class (define in a method with just new and no definition)








