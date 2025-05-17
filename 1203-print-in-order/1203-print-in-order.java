class Foo {
    int s;
    final Object lock;
    public Foo() {
        s=0;
        lock=new Object();
    }
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(lock){
            while(s!=0) lock.wait();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s=1;
        lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(lock){
            while(s!=1) lock.wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s=2;
        lock.notifyAll();
    }
    }
    public void third(Runnable printThird) throws InterruptedException {
        synchronized(lock){
            while(s!=2) lock.wait();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.notifyAll();
        }
    }
}