import java.util.*;

public class ToShare implements Iterable<Product> {
    List<Product> products__available;
    List<Product> shared_products;
    List<Product> all_products;
    HashMap<Product,Client> client_product;


    public ToShare() {
        products__available =  new ArrayList <Product>();
        shared_products = new ArrayList<Product>();
        all_products = new ArrayList<Product>();
        client_product =  new HashMap<Product, Client>();

    }


    public boolean add(Product p){
        for (Product product : products__available){
            if (product == p){
                return false;
            }
        }
        products__available.add(p);
        all_products.add(p);
        return true;
    }


    public Product remove(String code){
        for (Product p : products__available){
            if (p.code().equals(code)){
                products__available.remove(p);
                return p;
            }
        }
        return null;
    }


    public Product remove(Product p){
        products__available.remove(p);
        return p;
    }


    public boolean share(String code, Client user){
        for (Product product : products__available){

            if (product.code().equals(code)){
                products__available.remove(product);
                shared_products.add(product);
                client_product.put(product, user);
                return true;
            }
            else{
                System.out.println(product.code() + "!=" + code);
            }
        }
        return false;
    }
    public boolean share (Product p, Client user){
        for (Product product : products__available){
            if (product == p){
                products__available.remove(product);
                shared_products.add(product);
                client_product.put(product, user);
                return true;
            }
        }
        return false;
    }
    public boolean giveBack(String code){
        for (Product product : shared_products){
            if (product.code().equals(code)){
                products__available.add(product);
                shared_products.remove(product);
                client_product.remove(product);

                return true;
            }
        }                            
        return false;
    }
    public boolean giveBack(Product p){
        for (Product product : shared_products){
            if (product == p){
                products__available.add(product);
                shared_products.remove(product);
                client_product.remove(product);
                return true;
            }
        }                            
        return false;
    }

    @Override
    public Iterator<Product> iterator() {
        return all_products.iterator();
    }

    public String sharedProducts(){
        StringBuilder sb = new StringBuilder();
        sb.append("Total: " + shared_products.size()+"\n");
        for (Product product : shared_products){
            sb.append("\t"+product.getClass().getSimpleName()+" " + product.code()).append(" shared with ");
            Client client = client_product.get(product);
            sb.append(client.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<Product> getProducts(){
        return all_products;
    }

}
