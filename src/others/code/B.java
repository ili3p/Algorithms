package others.code;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class B {
  
  public void doIt() throws IOException {
    String className = this.getClass().getSimpleName();
    boolean small = true;
    boolean practice = false;
    String fileName = className + "-" + (small ? "small" : "large") + (practice ? "-practice" : (small ? "-attempt1" : "")) + ".in";
    String outFileName = className + "-" + (small ? "small" : "large") + (practice ? "-practice" : (small ? "-attempt1" : "")) + ".out";
    BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName)));
    
    boolean out = false;
    PrintWriter writer = null;
    
    if (!out) {
      writer = new PrintWriter(new FileWriter(outFileName));
    }
    
    String o = "";
    
    String line = reader.readLine();
    
    int cases = Integer.parseInt(line);
    
    for (int ncase = 0; ncase < cases; ncase++) {
      line = reader.readLine();
    
      //String origLine = line;
      boolean straight = true;
      int last = 0;
      
      for (int i = 0; i < line.length() - 1; i++) {
        if (line.charAt(i) < line.charAt(i + 1)) {
          straight = false;
          last = i;
        }        
      }
      
      if (straight) {
        
        line = (new StringBuffer(line)).reverse().toString();
        int k = 0;
        while (line.charAt(k) == '0') {
          k++;
        }
        line = (new StringBuffer(line.substring(0, k + 1))).reverse().toString() + "0" + line.substring(k + 1);
      } else {
        line = line.substring(0, last) + doIt(line.substring(last));
      }
//      if (line.charAt(0) == '0') {
//        line = origLine + "0";
//      }
      
      o = "Case #" + (ncase + 1) + ": " + line;
      if (out) {
        System.out.println(o);
      } else {
        writer.println(o);
      }
    }
    if (!out) {
      writer.flush();
      writer.close();
    }

  }
  
  private String doIt(String substring) {
    int next = -1;
    for (int i = 1; i < substring.length(); i++) {
      if (substring.charAt(i) > substring.charAt(0)) {
        if (next == -1) {
          next = i;
        } else {
          if (substring.charAt(i) < substring.charAt(next)) {
            next = i;
          }          
        }
      }
    }
    
    String res = substring.substring(next, next + 1);
    substring = substring.substring(0, next) + substring.substring(next + 1);
    byte[] b = substring.getBytes();
    Arrays.sort(b);
    substring = new String(b);
    
    return res + substring;
  }

  public static void main(String[] args) throws IOException {
    B a = new B();
    a.doIt();
  }
}
