package hbv.basics.examples;

import java.util.*;
import java.io.*;


public class SimpleThreads {
  static long counter;
  static long syncedCounter;
  public static void main(String[] args) {
    Thread[] ts = new Thread[]{new Worker(),new Worker(),new Thread(new Workable())};
    for(Thread t:ts){
      t.start();
    }
    for(Thread t:ts){
      try{
        t.join();
      }catch(InterruptedException ie){}
    }
    System.out.println(counter);
    System.out.println(syncedCounter);
  }
  public static void increment(){
    counter++;
  }
  public static void syncedIncrement(){
    synchronized(SimpleThreads.class){
      syncedCounter++;
    }
    // oder: public static synchronized void ...
  }
}

class Worker extends Thread {
  public void run(){
    for(int i=0; i<1000000; ++i){
      SimpleThreads.increment();
      SimpleThreads.syncedIncrement();
    }
  }
}

class Workable implements Runnable {
  public void run(){
    for(int i=0; i<1000000; ++i){
      SimpleThreads.increment();
      SimpleThreads.syncedIncrement();
    }
  }
}


