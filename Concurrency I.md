Concurrency and Parallel

你吃饭吃到一半，电话来了，你一直到吃完了以后才去接，这就说明你不支持并发也不支持并行。
你吃饭吃到一半，电话来了，你停了下来接了电话，接完后继续吃饭，这说明你支持并发。
你吃饭吃到一半，电话来了，你一边打电话一边吃饭，这说明你支持并行。

Concurrency: semantic concept, we can't tell the order, who is first and who is second.
             In java program, maybe a before b or b before a or at the same time.
Parallel: physically simultaneously, implementation level

Process and Thread

Process
an independent execution of instructions with a complete memory space
IPC to communicate
Thread
an in dependent execution of instructions with shared memory space (heap shared)  
Each has private stack, program counter and register states

Java Concurrency is focusing on multithread case, java application runs by default in one process.

Thread t = new Thread(); create one system thread
t.start(); schedule a thread and make ready to go (including run())
t.join(); make sure the thread finished after this line.

class Thread {
  public void run() {
    what this thread needs to do
  }
  public void start() {
    //preparing
    run();
    //cleaning up
  }  
}

public static void main(String(args)) {
  Thread t = new Thread() {
    @Override
    public void run() {
      Thread.sleep(1000);
      System.out.println("Hello1");
    }
  }
  t.start();
  System.out.println("Hello2");
}

when JVM exists?
no alive non-deamon threads.
daemon thread -> JVM exit, still exist

Two ways making thread
1. extends threads
  class HelloThreads extends Thread {
    @Override
    public void run() {
      System.out.println("Hello");
    }
  }
  public static void main (String args) {
    Thread newThread = new HelloThreads();
    newThread.start();
  }

2. implements Runnable interface
  interface Runnable() {
    void run();
  }
  class HelloThreads implements Runnable {
    @Override
    public void run() {
      System.out.println("Hello");
    }
  }

  public static void main (String args) {
    Thread t = new Thread(new HelloThreads());
    t.start();
  }
Or
public static void main (String args) {
  Thread t = new Thread(new Runnable () {
      public void run() {}
    });
  t.start();
}

sleep(1000) or yield() - static method of Thread class.
Thread.sleep(1000) -> move to sleep thread pool
Thread.yield() -> put back to ready to run queue for next time frame

Synchronization and Race
synchronization -> coordination
Impose orders on concurrent event
How?
Locks(synchronize), concurrent data structure, wait/notify(condition synchronization), volatile

Race should have 3 factors:
1. More than one operations work on the same memory location.
2. At least one operation is write
3. At least two of those operations are concurrent.

Mutual Extension, critical section and Locks
critical section: the code that requires mutual exclusion.
critical section would be created by locks.

Locks
1. lock: wait no one is there and go into critical section
2. unlock: leave the critical section and mark no one is there.

In java
synchronized could define method and Java class

instance lock

class Counter {
  private int val;
  public Counter (int val) {
    this.val = val;
  }
  public void increase() {
    synchronized(this) {
      value++;
    }
  }
  public synchronized decrease() {
    value--;
  }
  public synchronized getCount() {
    return value;
  }
}

class lock
For static variables.
class Counter {
  private static int value = 0;
  public void increment() {
    synchronized(Counter.class) {
      value++;
    }
  }
  public static synchronized void decrease() {
    value--;
  }
  public static int getCount() {
    synchronized(Counter.class) {
      return value;
    }
  }
}

Pay attention:
synchronized on non-static method = synchronized(this)
........        static     method = synchronized(Counter.class) != synchronized(all instance)
