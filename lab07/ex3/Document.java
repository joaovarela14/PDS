import java.io.*;
import java.nio.file.Files;
import java.util.*;


public class Document {
    
    private String name;
    
    public Document(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name;
    }

    public String[] getContent() {
        List<String> lines = null;
        try{
            lines = Files.readAllLines( new File(name).toPath() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }
}
