// Main.java
public class Main {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Product 1", 100.0);
        Product product2 = new Product(2, "Product 2", 200.0);
        Product product3 = new Product(3, "Product 3", 300.0);
        Product product4 = new Product(4, "Product 4", 400.0);
        Product product5 = new Product(5, "Product 5", 500.0);

        // Create clients
        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        Client client3 = new Client("Client 3");

        Gestor manager = new Gestor("Manager");

        product1.addObserver(client1);
        product1.addObserver(manager);

        product2.addObserver(client2);
        product2.addObserver(manager);

        product3.addObserver(client3);
        product3.addObserver(manager);

        product4.addObserver(client1);
        product4.addObserver(manager);

        product5.addObserver(client2);
        product5.addObserver(manager);

        // Simulate bids
        client1.bid(product1, 150.0);
        client2.bid(product2, 250.0);
        client3.bid(product3, 350.0);

        // Change product states
        product1.setState(new AuctionState(product1));
        product2.setState(new SoldState(product2));
        product3.setState(new StockState(product3));
    }
}
