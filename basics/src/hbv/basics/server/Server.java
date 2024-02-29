package hbv.basics.server;

import java.util.*;
import java.io.*;

import java.net.*;

public class Server{
  int port;
  public void go(int port) throws IOException{
    ServerSocket seso = new ServerSocket(port);
    System.err.println("listening on port: "+port);
    while (true){
      Socket sock = seso.accept();
      Worker worker = new Worker(sock);
      worker.start();
    }
  }
}
