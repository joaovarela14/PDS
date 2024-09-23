

public class ChocolateCakeBuilder extends Builder {

    @Override
    public void addCakeLayer() {
      this.getCake().setCakeLayer("Soft chocolate");
    }
  
    @Override
    public void addCreamLayer() {
      this.getCake().setMidLayerCream(null);
    }
  
    @Override
    public void addTopLayer() {
      this.getCake().setTopLayerCream(Cream.WHIPPED_CREAM);
    }
  
    @Override
    public void addTopping() {
      this.getCake().setTopping(Topping.CHOCOLATE);
    }
  
  }