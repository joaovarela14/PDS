

public class SoldState implements State{

    public SoldState(Product p){
        p.setState(this);
    }

    public void auction(Product p, int auctionDuration){
        System.out.println("The product is already sold.");
    }

    public void bid(Product p, double value){
        System.out.println("The product is already sold.");
    }

    public void finishAuction(Product p){
        System.out.println("The product is already sold.");
    }

    
}
