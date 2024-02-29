package hbv.basics.examples;

import java.util.*;
import java.io.*;

import java.net.*;

public class SimpleServer {
  public static void main(String[] args) {
    try {
      ServerSocket seso = new ServerSocket(3000);
      Socket socket = seso.accept();

      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
      String line = null;
      while ( (line = br.readLine()) != null){;
        pw.println("["+line+"]");
      }
      socket.close();
    } catch(IOException ioe){
      System.err.println(ioe);
    }
  }
}
