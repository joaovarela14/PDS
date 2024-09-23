
public interface State {
    public void auction(Product p, int auctionDuration);
    public void bid(Product p, double value);
    public void finishAuction(Product p);
}
