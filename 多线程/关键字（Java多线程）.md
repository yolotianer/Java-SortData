## 一．synchronized关键字
> 多线程的同步机制对资源进行加锁，使得再同一个事件只有一个线程可以进行操作，同步用以解决多个线程同时访问可能出错的问题。同步机制可以使用synchronized关键字实现。当synchronized关键字修饰一个方法的时候，该方法叫作同步方法。当synchronized方法执行完成或者发生异常时，会自动释放锁。

### １.synchronized修饰方法
- **未加synchronized关键字**
    - ==线程之间并发执行==，假设有两个线程，线程1和线程2同时进入执行状态，线程2的速度比线程1快，所以线程2先执行完成
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
