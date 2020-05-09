## 一．synchronized关键字
> 多线程的同步机制对资源进行加锁，使得再同一个事件只有一个线程可以进行操作，同步用以解决多个线程同时访问可能出错的问题。同步机制可以使用synchronized关键字实现。当synchronized关键字修饰一个方法的时候，该方法叫作同步方法。当synchronized方法执行完成或者发生异常时，会自动释放锁。

### １.synchronized修饰方法
- **未加synchronized关键字**
    - 线程之间并发执行，假设有两个线程，线程1和线程2同时进入执行状态，线程2的速度比线程1快，所以线程2先执行完成
- **修饰普通方法**（同一对象，顺序执行）--实例锁
    - 对象有一个synchronized方法
        - 线程1和线程1时顺序执行，也就是说线程2需要等待线程1执行完成，才能执行
    - 对象有对各synchronized方法（多个方法的多线程情况）
        - 如果一个对象有多个synchronized方法，某一时刻某个线程已经进入到某个方法，那么再该方法执行完毕之前，其它线程无法访问该对象的任何synchronized方法
    - 结论：
        - 当synchronized关键字修饰一个方法时，该方法叫作同步方法
        - Java中==每个对象都有一个锁lock，或者叫作监视器==，当一个线程访问某个对象的synchronized方法时，对该对象上锁，==其它任何线程都无法再去访问该线程的所有synchronized方法==，直到之前的线程执行完毕，或者时抛出异常，菜将该对象的锁释放，其它的线程才有可能再区访问该对象的synchronized方法
        - 注意：这时==是给对象上锁==，如果是不同的对象，则哥哥对象之间没有限制关系
- **修饰静态方法**--对象锁

    - 当一个synchronized关键字修饰的方法又被static修饰时，由于非静态的的同步方法会将对象上锁，但是静态的方法奴属于对象，而实属于类，它会==将这个方法所在的类的Class对象上锁。一个类不管生成多少个对象，它们锁定莹的是同一个类==
    - **结论**：如果某个synchronized方法是static的，那么当线程访问该方法时，它锁的并不是synchronized方法所在的对象，而是synchronized方法所在的类所对应的Class对象。Java中，无论一个类有多少个对象，这些对象会对应唯一一个Class对象，==因此当线程分别访问同一个类的两个对象的两个static synchronized方法时，它们的执行顺序也是顺序的，也就是说一个线程先去执行方法，执行完毕后另一个线程才开始。==

- **修饰代码块**实例锁
    - synchronized（object）{  }
    - 表示线程在执行的时候会将object对象上锁，这个对象可以是任意类型的队形，也可以是this关键字
    - synchronized方法实际上等同于用一个synchronized块包住所有的语句，然后再synchronized块中传入this关键字
    - 一个方法中只有几行代码会涉及到线程同步问题，所以==synchronized块比synchronized方法更加细粒度地控制了多个线程的访问==，只有synchronized块中的内容不能同时被多个线程所访问，方法中的其他语句仍然可以同时被多个线程所访问（包括synchronized块之前的和之后的）。
- 结论：
    - synchronized方法是一种==粗粒度的并发控制，某一时刻，只能有一个线程执行该synchronized方法==
    - synchronized块则是一种==细粒度的并发控制，只会将块中的代码同步，位于方法内、synchronized块之外的其他代码是可以被多个线程同时访问到的== synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率
> - **synchronized原理**
>     - Java中，每个对象有且只有一个同步锁。这就意味着，同步锁是依赖对象而存在的 
>     - 当问们调用对象的synchronized方法时，就获取了对象的同步锁。例如synchronized(obj)就获取了obj这个对象的同步锁
>     - 不同的线程对同步锁的访问是互斥的。也就是说，某时间点，对象的同步锁只能被一个线程获取到。通过同步锁，我们就能在多线程中实现“对象/方法”的互斥访问。
>     - 例如，现在有两个线程A和线程B，它们都会访问“对象obj的同步锁”。假设，在某一时刻，线程A获取到“obj的同步锁”并在执行一些操作；而此时，线程B也企图获取“obj的同步锁”线程B会获取失败，它必须等待，直到线程A释放了“该对象的同步锁”之后线程B才能获取到“obj的同步锁”从而才可以运行。
- synchronized基本原则
    - 当一个线程访问“某对象”的synchronized方法或者synchronized代码块时，其它线程对“该对象”的所有synchronized发方法或者synchronized代码块的访问将被阻塞
    - 当一个线程访问某对象的synchronized方法或者同步代码块时，其它线程仍然可以访问该对象的非同步代码块
- **synchronized方法和synchronized代码块**

方法示例：
```
public synchronized void foo1() {
    System.out.println("synchronized methoed");
}
```
代码块示例：
    
```
public void foo2() {
    synchronized (this) {
        System.out.println("synchronized methoed");
    }
}
```

synchronized代码块中的==this是指当前对象==。也可以将this替换成其他对象，例如==将this替换成obj==，则foo2()在执行synchronized(obj)时就==获取的是obj的同步锁。== 
- 实例锁和全局锁
    - 实例锁 
        - 锁在某一个实例对象上
        - 如果该实例是单例，呢么该所也具有全局锁的概念
        - 实例锁对应synchronized关键字
        - public synchronized void isSyncA(){}
    - 全局锁
        - 改锁针对类，无论多少个实例对象，都共享同一把锁
        - 全局锁对应static synchronized（或者是锁在该类的class或者classloader对象上）
        - public static synchronized void cSyncA(){}
## 二.volatile关键字
- **特点**：
    - **==保证可见性==**
        - 使用volatile关键字会强制将修改的值立即写入主存；
        - 使用volatile关键字的话，当有线进行修改时，会导致其它线程的工作内存中缓存变量无效
        - 由于其它线程工作内存中缓存的volatile变量无效，所以其它线程会再次读取volatile变量的值时会去主存读取，从而保证了读到的值是最新修改过的。
    - **==禁止指令重排序==**
        - 当程序执行到volatile变量的读操作或者写操作时，其前面的操作的更改肯定全部已经进行，且结果已经对后面的操作可见；且其后面的操作肯定还未进行；
        - 在进行指令优化时，JVM不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行。
- **正确理解volatile关键字**
    - synchronized关键字是防止多个线程同时执行一段代码，那么就会很影响程序的执行效率。而volatile关键字在某些情况下性能要由于synchronized，==但是volatile关键字是无法代替synchronized关键字的，因为你volatile关键字无法保证操作的原子性==
    - volatile关键字有synchronized关键字的可见性，但不具备原子性。这就是说线程能够自动实现volatile变量的最新值。volatile变量可用于提高线程安全，但只能应用于非常有限的一组用例：==多个线程之间或者某变量当前值于修改后的值之间没有约束，也就是不依赖于当前值==。因此单独用volatile变量不会像锁那样造成线程阻塞，因此也很少造成伸缩性。在某些情况下如果读操作远远大于写操作，volatile变量还可以提高优于锁的性能优势
- **使用条件**
    - 只能在有限的一些情形下使用 volatile 变量替代锁。要使 volatile 变量提供理想的线程安全，必须同时满足下面两个条件：
        ==- 对变量的写操作不依赖于当前值
        - 该变量没有包含在具有其他变量的不变式中。==
    - 第一个条件就是不能是自增自减等操作。第一个条件的限制使 ==volatile 变量不能用作线程安全计数器==。虽然增量操作（x++）看上去类似一个单独操作，实际上它是一个由（读取－修改－写入）操作序列组成的组合操作，必须以原子方式执行，而 volatile 不能提供必须的原子特性。
    - 第二个条件我们来举个例子它包含了一个不变式 ==：下界总是小于或等于上界。==

## 三.volatile 与 synchronized 的比较

volatile | synchronized
---|---
volatile本质是在告诉jvm当前变量在工作内存中的值是不确定的，需要从主存中读取 | synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住；
synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住； | synchronized则可以使用在变量、方法、和类级别的
volatile仅能实现变量的修改可见性，不能保证原子性 | 而synchronized则可以保证变量的修改可见性和原子性；
volatile不会造成线程的阻塞，即volatile不能用来同步，因为多个线程并发访问volatile修饰的变量不会阻塞 |synchronized可能会造成线程的阻塞；
volatile标记的变量不会被编译器优化 |synchronized标记的变量可以被编译器优化
当一个变量的值依赖于它之前的值时，volatile就无法使用，如n=n+1,n++等。|
