Java VS C++
1. Platform compatible.
C++ : write once and compile everywhere
Java: write once, compile once and run everywhere on JVM
-> JRE (Java Runtime Environment) : is a JVM program. Java application runs on JRE
-> JDK : tools (compiler[javac]) -> compile the code that JVM could recognize
-> Java complies to byte code to JVM and then interpret to run the program.
2. All types are passed by value.
3. Garbage Collection: we do not need to care about memory management and memory leak.
    C++ : need to delete the object by yourself

java source code -> byte code  .java -> .class
JVM interpret code is similar to machine code, so it is fast.
解释语言 -> no compile and read and interpret at the same time
reference is strong typed -> address + type

GC
stack -> it has life cycle
stack -> one per thread
heap -> one per process, only one per JVM

JVM Architecture
class file -> class loader system --
                                    |
                            runtime data area:
                            method area
                            heap
                            java threads -> stack
                            program counter register
                            native internal threads (bookkeeping)
                                      |
                            Execution Engine
                            JIT Compiler and GC

Steps for GC: (Running GC would STOP THE WORLD)
1. Marking
 identifies which pieces of memory are in use and not in use.
2. Normal Deletion
 remove unreferenced objects to free space
2a. Deletion with compacting

Advanced (improve performance)
JVM Generations -> divide the heap into several parts.
Young generation, old generation, permanent generation(metadata for method and class, if the class unloaded, it will free the space)
