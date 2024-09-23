
public class SpongeCakeBuilder extends Builder{

    @Override
    public void addCakeLayer() {
      this.getCake().setCakeLayer("Sponge");
    }
  
    @Override
    public void addCreamLayer() {
      this.getCake().setMidLayerCream(Cream.RED_BERRIES);
    }
  
    @Override
    public void addTopLayer() {
      this.getCake().setTopLayerCream(Cream.WHIPPED_CREAM);
    }
  
    @Override
    public void addTopping() {
      this.getCake().setTopping(Topping.FRUIT);
    }
}