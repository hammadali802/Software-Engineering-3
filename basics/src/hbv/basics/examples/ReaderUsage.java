package hbv.basics.examples;

import java.util.*;
import java.io.*;

public class ReaderUsage{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out,false);
    String line = null;
    while( (line=br.readLine()) != null){
      pw.println(line);
    }
    pw.flush();
  }
}
