import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Bridge {

    public Product readProducts(String[] info);
    public Product[] readFile(File filename) throws FileNotFoundException, IOException;
} 