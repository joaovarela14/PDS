public class VelvetCakeBuilder extends Builder{
    @Override
    public void addCakeLayer() {
      this.getCake().setCakeLayer("Velvet");
    }

    @Override
    public void addCreamLayer() {
        this.cake.setMidLayerCream(Cream.CREAM_CHEESE);
    }

    @Override
    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.CREAM_CHEESE);
    }
    
    @Override
    public void addTopping() {
        this.cake.setTopping(Topping.STRAWBERRIES);
    }

    
}
