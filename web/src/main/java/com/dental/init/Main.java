package com.dental.init;

import java.io.*;

/**
 * Created by vrudyk on 10/23/2016.
 */
public class Main {
  public static void main(String[] args) throws IOException {

    String cmd = "cmd /c dir";
    Process exec = Runtime.getRuntime().exec(cmd);
    InputStream inputStream = exec.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    OutputStream outputStream = exec.getOutputStream();
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);


    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
//    reader.lines().forEach(System.out::println);



  }
}
