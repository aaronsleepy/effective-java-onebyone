package com.socurites.ej.ch1;

import java.io.*;

public class ItemEx09 {
  private static final int BUFFER_SIZE = 1024;

  public static void main(String[] args) throws IOException {
    // try-finally with one resource
    String path = "";
    firstLineOfFile(path);

    // try-finally with two resource
    String src = "";
    String dst = "";
    copy(src, dst);


    // try-with-resources with one resource
    firstLineOfFileGood(path);

    // try-with-resources with two resource
    copyGood(src, dst);
  }

  private static void copyGood(String src, String dst) throws IOException {
    try(InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst)) {
      byte[] buf = new byte[BUFFER_SIZE];
      int n;
      while ((n = in.read(buf)) >= 0) {
        out.write(buf, 0, n);
      }
    }
  }

  private static void firstLineOfFileGood(String path) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
      bufferedReader.readLine();
    }
  }

  private static void copy(String src, String dst) throws IOException {
    InputStream in = new FileInputStream(src);
    try {
      OutputStream out = new FileOutputStream(dst);
      try {
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buf)) >= 0) {
          out.write(buf, 0, n);
        }
      } finally {
        out.close();
      }

    }finally {
      in.close();
    }
  }

  private static void firstLineOfFile(String path) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
    try {
      bufferedReader.readLine();
    } finally {
      bufferedReader.close();;
    }

  }
}
