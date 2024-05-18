
### 1. Introduction to Generics
- **Generics** allow us to create classes, interfaces, and methods with a placeholder for the type of data they operate on.
- This helps in creating type-safe code by ensuring that the data types are consistent.

### 2. Generic Classes
- A generic class can hold an object of any type.
- Example:
  ```java
  class GeneralClass<T> {
      private T someObj;

      public void setObject(T obj) {
          someObj = obj;
      }

      public T getObject() {
          return someObj;
      }
  }
  ```
- Usage:
  ```java
  GeneralClass<Integer> gc = new GeneralClass<>();
  gc.setObject(15);
  Integer x = gc.getObject(); // Works without casting
  ```

### 3. Type Safety
- Generics help in ensuring type safety by catching type mismatches at compile time.
- Example:
  ```java
  GeneralClass<String> gc = new GeneralClass<>();
  gc.setObject("Hello");
  Integer i = (Integer) gc.getObject(); // Compile-time error
  ```

### 4. Type Parameter Naming Conventions
- By convention, type parameter names are single, uppercase letters to distinguish them from normal class names.
  - `E` - Element (used in collections)
  - `K` - Key
  - `N` - Number
  - `T` - Type
  - `V` - Value
  - `S, U, V` - Second, third, fourth types

### 5. More Complex Designs
- You can have more than one type parameter in a class or interface.
- Example: `HashMap<K, V>`.

### 6. Bounded Types
- You can restrict the type parameters to a specific type or its subclasses.
  - Example:
    ```java
    class NumberArrayOps<T extends Number> {
        private T[] arr;

        public NumberArrayOps(T[] arr) {
            this.arr = arr;
        }

        public double calcSum() {
            double sum = 0;
            for (T x : arr) {
                sum += x.doubleValue();
            }
            return sum;
        }
    }
    ```

### 7. Wildcard Arguments
- Use `?` as a wildcard to represent an unknown type.
  - Example:
    ```java
    public void printList(List<?> elements) {
        for (Object x : elements) {
            System.out.println(x);
        }
    }
    ```

### 8. Upper and Lower Bounded Wildcards
- **Upper bounded wildcard**: `<? extends Type>` restricts the unknown type to be a specific type or a subtype.
  - Example: `public void calcCircumference(List<? extends Ellipse> list)`
- **Lower bounded wildcard**: `<? super Type>` restricts the unknown type to be a specific type or a supertype.
  - Example: `public void calcProperties(List<? super Square> list)`

### 9. Generic Constructors
- Constructors can be generic even if their class is not.
  - Example:
    ```java
    class NumTest {
        Number val;

        <T extends Number> NumTest(T value) {
            this.val = value;
        }
    }
    ```

### 10. Generic Interfaces
- Interfaces can also be generic.
  - Example:
    ```java
    interface SomeInt<T extends Superclass> {
    }
    ```

### 11. Restrictions
- You cannot create an instance of a type parameter.
  - `obj = new T();` // Not allowed
- Arrays of generic types cannot be created.
  - `T[] arr = new T[10];` // Not allowed
- Types cannot be used with the static keyword.
  - `static T someValue;` // Not allowed
- A generic class cannot extend `Throwable`.
  - This means you cannot create generic exception classes.

### 12. Variable Number of Parameters (Varargs)
- You can use `T...` to accept a variable number of arguments.
  - Example:
    ```java
    class A<T> {
        public void doIt(T... values) {
            for (T x : values) {
                System.out.println(x);
            }
        }
    }
    ```

### 13. Generic Methods in Non-Generic Classes
- You can define generic methods in a non-generic class.
  - Example:
    ```java
    public class GenericClass {
        public static void main(String[] args) {
            GenericClass.<Double>print(3.0, 2.0, 5.0, 3.0, 65.0);
            print("Aliya", "Mahammad", "Sadi");
            print(2, "Yes", true);
        }

        private static <T> void print(T... args) {
            if (args.length == 0) {
                System.out.println("[]");
                return;
            }

            System.out.print("[");
            for (int i = 0; i < args.length - 1; i++) {
                System.out.print(args[i] + ", ");
            }
            System.out.println(args[args.length - 1] + "]");
        }
    }

### Lambda Expressions and Functional Interfaces in Java.

### 1. Functional Interfaces
- A **Functional Interface** is an interface that contains exactly one abstract method. This is a target for lambda expressions.
- Examples of functional interfaces in Java:
  - `Runnable`: 
    ```java
    public interface Runnable {
        public abstract void run();
    }
    ```
  - `Comparator<T>`:
    ```java
    public interface Comparator<T> {
        public int compare(T o1, T o2);
    }
    ```

- Custom functional interface example:
  ```java
  @FunctionalInterface
  public interface AnotherFuncInt {
      void apply(String word);

      static void print(String word) {
          System.out.println(word);
      }

      default void print(String word, String pref) {
          System.out.println(pref + ": " + word);
      }
  }
  ```

### 2. Lambda Expressions
- A **Lambda Expression** is an anonymous function that provides a concise way to implement the method of a functional interface.
- Syntax:
  ```java
  (parameters) -> expression
  ```
  or
  ```java
  (parameters) -> { statements; }
  ```

#### Example:
- Functional Interface:
  ```java
  interface NumberTest {
      boolean isEven(int n);
  }
  ```
- Lambda Expression:
  ```java
  NumberTest isEven = (n) -> (n % 2) == 0;
  System.out.println(isEven.isEven(5)); // false
  System.out.println(isEven.isEven(6)); // true
  ```

### 3. Lambda Expression Blocks
- Lambda expressions can contain multiple statements, referred to as block lambdas.
- Example:
  ```java
  interface MathFunc {
      int func(int n);
  }

  MathFunc factorial = (n) -> {
      int fact = 1;
      for (int i = 1; i <= n; i++) {
          fact *= i;
      }
      return fact;
  };
  System.out.println("5! is " + factorial.func(5)); // 5! is 120
  ```

### 4. Generic Functional Interfaces
- Generics can be used with functional interfaces to allow type flexibility.
- Example:
  ```java
  interface AnyFunc<T> {
      T func(T t);
  }

  AnyFunc<String> upper = (s) -> s.toUpperCase();
  System.out.println(upper.func("Demo")); // DEMO
  ```

### 5. Using Lambda Expressions with Multiple Parameters and Types
- More than one parameter:
  ```java
  interface AnyFunc<T> {
      T func(T a, T b);
  }

  AnyFunc<String> merge = (s1, s2) -> s1 + " " + s2;
  System.out.println(merge.func("Hello", "World")); // Hello World
  ```

- More than one type:
  ```java
  interface AnyFunc<T, S, U> {
      T func(S a, U b);
  }

  AnyFunc<String, String, Integer> merge = (s1, s2) -> s1 + " : " + s2;
  System.out.println(merge.func("Hello", 5)); // Hello : 5
  ```

### 6. Java's `java.util.function` Package
Sure, let's explore the `java.util.function` package with examples for each of the mentioned functional interfaces: `Consumer`, `Function`, `Predicate`, and `Supplier`.

### 1. Consumer<T>
A `Consumer` represents an operation that accepts a single input argument and returns no result. It is typically used to perform side-effects.

#### Example:
```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> greeter = name -> System.out.println("Hello, " + name + "!");
        greeter.accept("Alice"); // Output: Hello, Alice!
        greeter.accept("Bob"); // Output: Hello, Bob!
    }
}
```

### 2. Function<T, R>
A `Function` represents a function that accepts one argument and produces a result. It is used for transformations.

#### Example:
```java
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> intToString = num -> "Number: " + num;
        String result1 = intToString.apply(5);
        String result2 = intToString.apply(10);

        System.out.println(result1); // Output: Number: 5   
        System.out.println(result2); // Output: Number: 10
    }
}
```

### 3. Predicate<T>
A `Predicate` represents a boolean-valued function of one argument. It is used for testing conditions.

#### Example:
```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        boolean result1 = isEven.test(4); // true
        boolean result2 = isEven.test(7); // false

        System.out.println("4 is even: " + result1); // Output: 4 is even: true
        System.out.println("7 is even: " + result2); // Output: 7 is even: false
    }
}
```

### 4. Supplier<T>
A `Supplier` represents a supplier of results. It does not take any arguments and returns a result.

#### Example:
```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello, World!";
        String result = supplier.get();

        System.out.println(result); // Output: Hello, World!
    }
}
```

### Combining Functional Interfaces

Let's see a more complex example that combines these interfaces.

#### Example:
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CombinedExample {
    public static void main(String[] args) {
        // Supplier
        Supplier<List<String>> listSupplier = () -> Arrays.asList("Alice", "Bob", "Charlie", "Dave");

        // Consumer
        Consumer<String> greeter = name -> System.out.println("Hello, " + name + "!");

        // Function
        Function<String, String> toUpperCase = String::toUpperCase;

        // Predicate
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Using the Supplier
        List<String> names = listSupplier.get();

        // Using the Consumer
        names.forEach(greeter);

        // Using the Function and Predicate
        names.stream()
            .filter(startsWithA)
            .map(toUpperCase)
            .forEach(greeter); // Output: Hello, ALICE!
    }
}
```

### Explanation:
1. **Supplier**: Provides a list of names.
2. **Consumer**: Greets each name.
3. **Function**: Converts each name to uppercase.
4. **Predicate**: Tests if a name starts with the letter 'A'.
5. **Combined Usage**:
    - Greets all names in the list.
    - Filters names that start with 'A', converts them to uppercase, and then greets them.

### 7. Using Lambda Expressions as Method Arguments
- Lambda expressions can be passed as arguments to methods expecting a functional interface.
- Example:
  ```java
  public void printIt(AnyFunc<String> af) {
      System.out.println("The result is: " + af.func("Hello"));
  }

  printIt((str) -> str.toUpperCase()); // The result is: HELLO
  ```

### 8. Method References
- Method references provide a way to refer to methods directly without invoking them.
- Syntax:
  ```java
  ClassName::methodName
  ```
- Example:
  ```java
  interface SomeFunc<T> {
      T func(T t);
  }

  static void printIt(SomeFunc<String> sf) {
      System.out.println(sf.func("Hello"));
  }

  static String upper(String a) {
      return a.toUpperCase();
  }

  String lower(String a) {
      return a.toLowerCase();
  }

  public static void main(String[] args) {
      printIt(LambdaTester::upper); // static method reference
      LambdaTester lt = new LambdaTester();
      printIt(lt::lower); // instance method reference
  }
  ```

### Exercises:
1. **Write several Lambda Expressions of `AnyFunc`:**
   - Reverse a string:
     ```java
     AnyFunc<String> reverse = (s) -> new StringBuilder(s).reverse().toString();
     System.out.println(reverse.func("Salam")); // malaS
     ```
   - Count the number of digits in a number:
     ```java
     AnyFunc<Integer, Integer> digits = (n) -> String.valueOf(n).length();
     System.out.println(digits.func(3423)); // 4
     ```Great! Let's start with Java I/O. We'll break down the key concepts and then go through some questions to test your understanding. Here's an overview of what we will cover:

### Overview of Java I/O Streams
1. **Streams:** Java programs perform I/O (Input/Output) operations through streams. Streams make your code independent of the target resource or device. There are two types of I/O streams:
   - **Byte Streams:** Used for binary data (e.g., `InputStream`, `OutputStream`).
   - **Character Streams:** Used for character data (e.g., `Reader`, `Writer`).

2. **Java I/O Package:** The `java.io` package contains classes necessary for input and output operations, such as reading/writing files, buffers, and managing network streams.

### Byte Streams
- **InputStream** and **OutputStream** are abstract classes for handling input and output of byte data.
- Common classes include:
  - **FileInputStream**: Reads data from a file.
  - **FileOutputStream**: Writes data to a file.

### Character Streams
- **Reader** and **Writer** are abstract classes for handling input and output of character data.
- Common classes include:
  - **FileReader**: Reads character data from a file.
  - **FileWriter**: Writes character data to a file.
  - **BufferedReader**: Buffers input to improve efficiency.

### Common Classes and Methods
- **System.in**: An instance of `InputStream` for reading input from the console.
- **System.out**: An instance of `PrintStream` for writing output to the console.
- **FileInputStream**:
  - `int read() throws IOException`: Reads a single byte and returns it as an integer. Returns -1 if the end of the file is reached.
  - `int read(byte[] b) throws IOException`: Reads up to `b.length` bytes into the byte array `b`.
  - `int read(byte[] b, int off, int len) throws IOException`: Reads up to `len` bytes into the byte array `b` starting at offset `off`.
- **FileOutputStream**:
  - `void write(byte b) throws IOException`: Writes a single byte to the output stream.
  - `void write(byte[] b) throws IOException`: Writes `b.length` bytes from the byte array `b` to the output stream.
  - `void write(byte[] b, int off, int len) throws IOException`: Writes `len` bytes from the byte array `b` starting at offset `off`.

### Auto-Closeable Resources
- Starting with JDK 7, resources such as `FileInputStream` and `FileOutputStream` can be automatically closed using the try-with-resources statement.
  - Example:
    ```java
    try (FileInputStream fis = new FileInputStream("file.txt")) {
        // Read data from the file
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

### Serializable Interface
- Objects can be saved and transferred through a byte stream only if they implement the `Serializable` interface.
- To make a class serializable, implement the `java.io.Serializable` interface.

### Example Questions:
1. **What is the main difference between byte streams and character streams?**
2. **How do you read a file using `FileInputStream`? Provide an example.**
3. **How do you write to a file using `FileOutputStream`? Provide an example.**
4. **What is the purpose of the `finally` block in a try-catch-finally statement?**
5. **How do you use try-with-resources to automatically close a `FileInputStream`? Provide an example.**
6. **What is the `Serializable` interface used for? How do you make a class serializable?**
7. **How do you read a text file using `BufferedReader`? Provide an example.**
8. **What is the `RandomAccessFile` class used for? Provide an example of reading and writing to a file using `RandomAccessFile`.**

### Let's Start with the Questions One by One
### Question 1:
What is the main difference between byte streams and character streams?
### Detailed Notes on Threads in Java

#### 1. Introduction to Threads
- **Threads**: Independent paths of execution within a program. They allow for parallel execution of tasks, improving efficiency.
- **Concurrency**: The ability of a program to execute multiple tasks simultaneously. This is critical for applications that require multitasking.
- **Parallelism**: Involves performing multiple tasks at the same time in different threads or processes.

#### 2. Types of Multitasking
- **Process-based Multitasking**:
  - **Definition**: Running multiple programs (processes) simultaneously.
  - **Characteristics**:
    - Each process has its own memory space.
    - Inter-process communication (IPC) is complex and expensive.
    - Context switching between processes is costly.
  - **Example**: Browsing the internet while listening to music on a media player.
- **Thread-based Multitasking**:
  - **Definition**: Running multiple threads within a single program.
  - **Characteristics**:
    - Threads share the same memory space.
    - Communication between threads is inexpensive.
    - Context switching between threads is less costly.
  - **Example**: A text editor updating text formatting while saving the document in the background.

#### 3. Measuring Runtime
- **Using `System.currentTimeMillis()`**:
  ```java
  long before = System.currentTimeMillis();
  // Code to measure
  long after = System.currentTimeMillis();
  long workingTime = after - before;
  ```
- **Using `System.nanoTime()`**:
  ```java
  long before = System.nanoTime();
  // Code to measure
  long after = System.nanoTime();
  long workingTime = after - before;
  ```

#### 4. Creating Threads in Java
- **Implementing the `Runnable` Interface**:
  ```java
  class MyRunnable implements Runnable {
      public void run() {
          // Execution code here
      }
  }

  MyRunnable mr = new MyRunnable();
  Thread t = new Thread(mr);
  t.start();
  ```
- **Extending the `Thread` Class**:
  ```java
  class MyThread extends Thread {
      public void run() {
          // Execution code here
      }
  }

  MyThread mt = new MyThread();
  mt.start();
  ```

#### 5. Thread Lifecycle
- **New**: A thread is created but not yet started.
- **Runnable**: The `start()` method is called, but the thread is not yet selected by the scheduler to run.
- **Running**: The thread is picked by the thread scheduler to run.
- **Waiting/Blocked**: The thread is waiting for a specific condition to be met or for a resource to become available.
- **Terminated**: The thread has completed execution.

#### 6. Thread Scheduler
- **Role**: The thread scheduler in the JVM determines which thread should run at any given time. It uses thread priorities to make scheduling decisions.
- **Methods**:
  - `boolean isAlive()`: Checks if a thread is still running.
  - `void join()`: Waits for the thread to finish execution.
  - `void yield()`: Suggests that the thread scheduler should switch to another thread.
  - `void sleep(long millis)`: Puts the current thread to sleep for a specified time.
  - `void interrupt()`: Interrupts a sleeping or waiting thread.

#### 7. Synchronization
- **Purpose**: To prevent concurrent threads from interfering with each other when accessing shared resources.
- **Synchronized Methods**: Ensure that only one thread can execute the method at a time.
  ```java
  public synchronized void increment() {
      count++;
  }
  ```
- **Synchronized Blocks**: Provide a finer control over the synchronization.
  ```java
  public void addBonus(int bonus) {
      synchronized (this) {
          score += bonus;
      }
  }
  ```

#### 8. Volatile Keyword
- **Purpose**: To ensure visibility of changes to variables across threads. It guarantees that a read or write to a volatile variable always goes to main memory.
- **Usage**:
  ```java
  private volatile boolean flag = true;
  ```

#### 9. Wait and Notify
- **wait()**: Makes the current thread release the monitor and wait until another thread calls `notify()` or `notifyAll()`.
  ```java
  synchronized (obj) {
      while (!condition) {
          obj.wait();
      }
      // Perform action
  }
  ```
- **notify()**: Wakes up a single thread that is waiting on the object's monitor.
  ```java
  synchronized (obj) {
      condition = true;
      obj.notify();
  }
  ```
- **notifyAll()**: Wakes up all threads that are waiting on the object's monitor.

#### 10. Liveness Issues
- **Deadlock**: Occurs when two or more threads are blocked forever, each waiting on the other to release a resource.
  ```java
  synchronized (resource1) {
      synchronized (resource2) {
          // Deadlock situation
      }
  }
  ```
- **Livelock**: Occurs when threads are not blocked but cannot proceed because they keep responding to each other.
- **Starvation**: Occurs when a thread is perpetually denied access to resources and thus cannot make progress.

### Example Questions

#### Question 1:
What is the main difference between process-based multitasking and thread-based multitasking?

#### Question 2:
How do you measure the runtime of a piece of code in milliseconds and nanoseconds in Java?

#### Question 3:
Write a code example to create a thread by implementing the `Runnable` interface.

#### Question 4:
Describe the lifecycle of a thread in Java.

#### Question 5:
Explain the purpose of the `synchronized` keyword and provide an example of its usage.

#### Question 6:
What is the `volatile` keyword used for in Java?

#### Question 7:
Write a code example demonstrating the use of `wait()` and `notify()` methods.

#### Question 8:
What are liveness issues in concurrency, and how do they differ (deadlock, livelock, starvation)?

#### Question 9:
Provide an example of a `synchronized` block and explain when you would use it over a synchronized method.

#### Question 10:
What is the role of the thread scheduler in Java, and how does thread priority affect thread execution?
Sure! Here are detailed explanations and code examples for each of the topics, including livelock and starvation.

### Question 1:
**What is the main difference between process-based multitasking and thread-based multitasking?**

**Answer:**
- **Process-based Multitasking**:
  - Involves running multiple processes (programs) simultaneously.
  - Each process has its own memory space.
  - Inter-process communication is complex and expensive.
  - Example: Checking emails while browsing the internet.

- **Thread-based Multitasking**:
  - Involves running multiple threads within a single process.
  - Threads share the same memory space.
  - Communication between threads is simple and inexpensive.
  - Example: A text editor updating text formatting while saving the document in the background.

### Question 2:
**How do you measure the runtime of a piece of code in milliseconds and nanoseconds in Java?**

**Answer:**
**Using `System.currentTimeMillis()`**:
```java
long before = System.currentTimeMillis();
// Code to measure
long after = System.currentTimeMillis();
long workingTime = after - before;
System.out.println("Execution time in milliseconds: " + workingTime);
```

**Using `System.nanoTime()`**:
```java
long before = System.nanoTime();
// Code to measure
long after = System.nanoTime();
long workingTime = after - before;
System.out.println("Execution time in nanoseconds: " + workingTime);
```

### Question 3:
**Write a code example to create a thread by implementing the `Runnable` interface.**

**Answer:**
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running.");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
```

### Question 4:
**Describe the lifecycle of a thread in Java.**

**Answer:**
1. **New**: A thread is created but not yet started.
2. **Runnable**: The `start()` method is called, but the thread is not yet selected by the scheduler to run.
3. **Running**: The thread is picked by the thread scheduler to run.
4. **Waiting/Blocked**: The thread is waiting for a specific condition to be met or for a resource to become available.
5. **Terminated**: The thread has completed execution.

### Question 5:
**Explain the purpose of the `synchronized` keyword and provide an example of its usage.**

**Answer:**
**Purpose**: To prevent concurrent threads from interfering with each other when accessing shared resources. It ensures that only one thread can execute a synchronized method or block at a time.

**Synchronized Method Example**:
```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedMethodExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
```

### Question 6:
**What is the `volatile` keyword used for in Java?**

**Answer:**
**Volatile**: Ensures visibility of changes to variables across threads. It guarantees that a read or write to a volatile variable always goes to main memory.

**Example**:
```java
public class VolatileExample {
    private volatile boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Thread writer = new Thread(() -> {
            example.setFlag(false);
        });

        Thread reader = new Thread(() -> {
            while (example.getFlag()) {
                // Do something
            }
            System.out.println("Flag changed to false");
        });

        writer.start();
        reader.start();
    }
}
```

### Question 7:
**Write a code example demonstrating the use of `wait()` and `notify()` methods.**

**Answer:**
```java
public class WaitNotifyExample {
    private final Object lock = new Object();
    private boolean condition = false;

    public void doWait() {
        synchronized (lock) {
            while (!condition) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Condition met, proceeding with execution");
        }
    }

    public void doNotify() {
        synchronized (lock) {
            condition = true;
            lock.notify();
        }
    }

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();

        Thread waiter = new Thread(() -> {
            example.doWait();
        });

        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.doNotify();
        });

        waiter.start();
        notifier.start();
    }
}
```

### Question 8:
**What are liveness issues in concurrency, and how do they differ (deadlock, livelock, starvation)?**

**Answer:**
- **Deadlock**: Occurs when two or more threads are blocked forever, each waiting on the other to release a resource.
- **Livelock**: Occurs when threads are not blocked but cannot proceed because they keep responding to each other.
- **Starvation**: Occurs when a thread is perpetually denied access to resources and thus cannot make progress.

### Question 9:
**Provide an example of a `synchronized` block and explain when you would use it over a synchronized method.**

**Answer:**
**Synchronized Block**: Provides finer control over the synchronization. It allows you to synchronize only a part of the method, reducing the scope of synchronization.

**Example**:
```java
public class Counter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedBlockExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
```

### Question 10:
**What is the role of the thread scheduler in Java, and how does thread priority affect thread execution?**

**Answer:**
**Thread Scheduler**: The thread scheduler in the JVM determines which thread should run at any given time. It uses thread priorities to make scheduling decisions.

- **Thread Priority**: Each thread has a priority, which helps the thread scheduler decide the order of thread execution. Higher priority threads are more likely to be executed before lower priority threads.

**Example**:
```java
public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> {
            System.out.println("High priority thread is running");
        });

        Thread lowPriorityThread = new Thread(() -> {
            System.out.println("Low priority thread is running");
        });

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        lowPriorityThread.start();
        highPriorityThread.start();
    }
}
```

### Livelock Example:
```java
public class LivelockExample {
    static class Spoon {
        private Diner owner;

        public Spoon(Diner d) {
            owner = d;
        }

        public Diner getOwner() {
            return owner;
        }

        public synchronized void setOwner(Diner d) {
            owner = d;
        }

        public synchronized void use() {
            System.out.println(owner.name + " is eating!");
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String n) {
            name = n;
            isHungry = true;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                if (spoon.getOwner() != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                if (spouse.isHungry()) {


                    System.out.println(name + ": You eat first, dear " + spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.println(name + " is done eating.");
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");
        final Spoon spoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(spoon, wife)).start();
        new Thread(() -> wife.eatWith(spoon, husband)).start();
    }
}
```

### Starvation Example:
```java
public class StarvationExample {
    static class Worker extends Thread {
        private static final Object lock = new Object();

        public Worker(String name) {
            this.setName(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " is working");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker 1");
        Worker worker2 = new Worker("Worker 2");
        Worker worker3 = new Worker("Worker 3");
        Worker worker4 = new Worker("Worker 4");
        Worker worker5 = new Worker("Worker 5");

        worker1.setPriority(Thread.MAX_PRIORITY);
        worker2.setPriority(Thread.MIN_PRIORITY);
        worker3.setPriority(Thread.MIN_PRIORITY);
        worker4.setPriority(Thread.MIN_PRIORITY);
        worker5.setPriority(Thread.MIN_PRIORITY);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker5.start();
    }
}
```

These examples and explanations should give you a thorough understanding of Java threads, their lifecycle, synchronization, and liveness issues.

