import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductReader implements Bridge {

    public Product[] readFile(File filename)  {
        List<Product> productList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split("\t");
                Product product = readProducts(info);
                if (product != null) {
                    productList.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename.getPath());
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename.getPath());
        }
        // Convert the list to an array
        Product[] products = new Product[productList.size()];
        products = productList.toArray(products);


        return products;
    }

    public Product readProducts(String[] info) {
        String tipo = info[0];

        switch (tipo) {
            case "Car":
                return new Car(info[1].trim(), info[2], Integer.parseInt(info[3]));

            case "Van":
                return new Van(info[1].trim(), info[2], Integer.parseInt(info[3]));

            case "Motorcycle":
                return new Motorcycle(info[1].trim(), info[2], Integer.parseInt(info[3]));

            default:
                return null;
        }
    }
}
