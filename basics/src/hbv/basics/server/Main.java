package hbv.basics.server;

import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws Exception {
    int port = Integer.parseInt(args[0]);

    Server server = new Server();
    server.go(port);

  }
}
