package hbv.basics.examples;

import java.util.*;
import java.io.*;

import java.net.*;

public class SimpleClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost",3000);

      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

      for(int i=0; i<10000000; ++i){
        pw.println("send 2"+i);
        String line = br.readLine();
        System.out.println("got:"+line);
      }
      socket.close();
    } catch(IOException ioe){
      System.err.println(ioe);
    }
  }
}
