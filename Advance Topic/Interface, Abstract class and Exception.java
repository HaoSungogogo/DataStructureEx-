Override and Overload
Override: using the same signature as parent class
		  resolved in the runtime -> in the runtime, decide which method to run.
Overload: define two methods with the same name, in the same Class with different signature, resolved in compile time.
signatue: mehtod name and parameter type list.

Interface and Abstract class

Abstract Class has one or more abstract methods
Interface only has abstract methods

Java does not allows multiple inheritance, a Class can only derive one class, whether it is abstrct or not.
However, Java can implement multiple interface.
是什么， 干什么?

Interview Question abstract vs interface
a is good a. if we want to use base Class implementation
		  b. want to declare non-public member
		  c. if we want to add method in the future
i is good a. API will not change for a while.
		  b. do something simmilar to multiple inheritance

Access Modifier
            Class          package				subclass			world
 public		Y				Y  						Y				  Y
 protected  Y				Y						Y				  N
 default	Y				Y						N 				  N
 private	Y				N  						N 				  N

 Singleton Pattern
 
 public class ClassicSingleton {
 	private static final ClassicSingleton singleton = new ClassicSingleton();
 	public static ClassicSingleton getInstance() {
 		return singleton;
 	}
 }

ClassicSingleton s = ClassicSingleton.getInstance();



Exception and Error (extend from Throwable)

Exception: a reasonable application might want to catch
Error: a reasonable application should not try to catch
class Throwable {
	getMessage();
	printStackTrace();
}

Exception a) Checked Exception must handle (try ... catch ... finally / throws Exception  ->  上层catch， 最后防线jvm)
		  b) Runtime Exception/Unchecked Exception: you do not need to handle (JVM could help you handle)

Checked Exception:
a. try ... catch
	try {
		FileInputStream fs = new FileInputStream("D:/temp/a.txt");
	} catch(FileNotFoundException e) {
		System.out.println("catch ...");
		e.printStackTrace();
	} finally {
		System.out.println("finally....");
	}
b. throws
b.1 leave it to JVM
	public class ExceptionTest {
		public static void execute() throws Exception {
			System.out.println("execute....");
			throw new Exception();
		}
	}
b.2 leave it by ourselves
	public class ExceptionTest {
		public static void execute() throws Exception {
			throw new Exception();
		}
		public static void main(Stirng[] args) {
			try {
				execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

Define an Exception

public class MyException extends Exception {
	public MyException() {
		super();
	}
	public MyException(String msg) {
		super(msg + "my excetption");
	}
}

public class ExceptionTest {
	public static void execute(String a) throws MyException {
		System.out.println("execute....");
		if (a.equals("True")) {
			throw new MyException("it can be true");
		}
	}
}

finally -> always execute even after return 

Multiple Catch: Subclass must before superclass.

