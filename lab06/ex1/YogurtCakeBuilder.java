
public class YogurtCakeBuilder extends Builder {

    @Override
    public void addCakeLayer() {
      this.getCake().setCakeLayer("Yogurt");
    }
  
    @Override
    public void addCreamLayer() {
      this.getCake().setMidLayerCream(Cream.VANILLA);
    }
  
    @Override
    public void addTopLayer() {
      this.getCake().setTopLayerCream(Cream.RED_BERRIES);
    }
  
    @Override
    public void addTopping() {
      this.getCake().setTopping(Topping.CHOCOLATE);
    }
  
  }