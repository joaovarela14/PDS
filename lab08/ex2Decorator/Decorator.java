

public class Decorator  implements ReaderInt{
    ReaderInt reader;
    public Decorator(ReaderInt reader){
        this.reader = reader;
    }
    public boolean hasNext() {
        return reader.hasNext();
    }
    public String next() {
        return reader.next();
    }
    
}
