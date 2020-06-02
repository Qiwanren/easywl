package com.forms.wl.tool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    static Lock lock;//当然这里我们还可以使用 ReentrantLock重入锁
    static int count = 0;
    public static void main(String args[]){
        lock = new ReentrantLock();
        Thread1 thread1 = new Thread1(lock);
        Thread2 thread2 = new Thread2(lock);
        thread1.start();
        thread2.start();
    }

    public static class Thread1 extends Thread{
        Lock lock;
        public Thread1(Lock lock){
            this.lock = lock;
        }
        @Override
        public void run() {
            lock.lock();
            for(int i=0;i<5;i++){
                System.out.println("Thread1:"+count);
                count++;
            }
            lock.unlock();
        }
    }

    public static class Thread2 extends Thread{
        Lock lock;
        public Thread2(Lock lock){
            this.lock = lock;
        }
        @Override
        public void run() {
            lock.lock();
            for(int i=0;i<5;i++){
                System.out.println("Thread2:"+count);
                count++;
            }
            lock.unlock();
        }
    }
}
