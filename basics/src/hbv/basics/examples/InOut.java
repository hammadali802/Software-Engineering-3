package hbv.basics.examples;

import java.util.*;
import java.io.*;

public class InOut{
  public static void main(String[] args) throws IOException{
    int length=8*1024;
    byte[] buf = new byte[length];
    while ((length = System.in.read(buf)) != -1) {
      System.out.write(buf, 0, length);
    }
    // https://www.baeldung.com/java-system-out-flush
    System.out.flush();
  }
}
