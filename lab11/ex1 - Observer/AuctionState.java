
public class AuctionState implements State{

    public AuctionState(Product p){
        p.setState(this);
    }
    
    public void auction(Product p, int auctionDuration){
        p.startAuction(auctionDuration);
    }

    public void bid(Product p, double value){
        System.out.println("The product is not being auctioned.");
    }

    public void finishAuction(Product p){
        p.setState(new SoldState(p));
        p.finishAuction();
    }

    
}
