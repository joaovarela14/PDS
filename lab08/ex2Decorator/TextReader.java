import java.util.*;
import java.io.*;



public class TextReader implements ReaderInt{

    ReaderInt reader;


    public Scanner sc;

    public TextReader(String fileName) throws FileNotFoundException {
      sc = new Scanner(new File(fileName));
    }

    public boolean hasNext() {
      return sc.hasNext();
    }

    public String next() {
      return sc.nextLine();
    }
  
    
}
