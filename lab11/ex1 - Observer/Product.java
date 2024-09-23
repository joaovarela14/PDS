public class Product {
    private String descricao;
    private double preco_base;
    private int id;
    private State state;

    public Product(int id, String descricao, double preco_base) {
        this.id = id;
        this.descricao = descricao;
        this.preco_base = preco_base;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco_base() {
        return preco_base;
    }

    public int getId() {
        return id;
    }

    protected void startAuction(int auctionDuration){
        Product p = this;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("A new Auction for " + p.toString() + " is now taking place. The auction will last "  + auctionDuration + " seconds.");
                    // Sleep for the specified duration
                    Thread.sleep(auctionDuration * 1000); // Convert seconds to milliseconds
                    // After the auction's duration, kill it
                    finishAuction();
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }
            }
        });
        thread.start();
    }

    
    public State setState(State state){
        this.state = state;
        return state;
    }

    public void finishAuction(){
        state.finishAuction(this);
        System.out.println("The auction for " + this.toString() + " has ended.");
    }

    
    public void bid(double value){
        state.bid(this, value);
    }

    public void addObserver(Observer observer){
        state.addObserver(observer);
    }
    
    
}
