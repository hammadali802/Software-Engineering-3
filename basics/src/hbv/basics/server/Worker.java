package hbv.basics.server;

import java.util.*;
import java.io.*;

import java.net.*;

public class Worker extends Thread {
  Socket socket;
  public Worker(Socket socket){
    this.socket = socket;
  }
  public void run() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
      String line = null;
      while ( (line = br.readLine()) != null){;
        System.err.println("received "+line);
        pw.println("["+line+"]");
      }
      pw.flush();
      socket.close();
      System.err.println("closed "+this);
    } catch(IOException ioe){
      System.err.println(ioe);
    }
  }
}
