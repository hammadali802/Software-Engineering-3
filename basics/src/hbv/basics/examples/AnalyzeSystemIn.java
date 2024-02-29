package hbv.basics.examples;

import java.io.*;
import java.lang.reflect.*;

public class AnalyzeSystemIn {
  public static void main(String[] args) throws Exception {
    System.out.println(System.in);
    Field field = FilterInputStream.class.getDeclaredField("in");
    field.setAccessible(true);
    System.out.println(field.get(System.in));
  }
}
