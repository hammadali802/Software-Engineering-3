package hbv.basics.examples;

import java.util.*;
import java.io.*;

public class ScannerUsage{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while(input.hasNextLine()){
      String data = input.nextLine();
      System.out.println(data);
    }
  }
}
