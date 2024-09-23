
class Cake { 
    private Shape shape; 
    private String cakeLayer; 
    private int numCakeLayers; 
    private Cream midLayerCream; 
    private Cream topLayerCream; 
    private Topping topping; 
    private String message;


    public Cake() {
        this.shape = Shape.Circle;
        this.numCakeLayers = 1;
      }
    

    public Cake(Shape shape, String cakeLayer, int numCakeLayers, Cream midLayerCream, Cream topLayerCream, Topping topping, String message) {
        this.shape = shape;
        this.cakeLayer = cakeLayer;
        this.numCakeLayers = numCakeLayers;
        this.midLayerCream = midLayerCream;
        this.topLayerCream = topLayerCream;
        this.topping = topping;
        this.message = message;
    }

    public void addCakeLayer(){
        numCakeLayers++;
    }
    

    public Shape getShape() {
        return this.shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getCakeLayer() {
        return this.cakeLayer;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public int getNumCakeLayers() {
        return this.numCakeLayers;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public Cream getMidLayerCream() {
        return this.midLayerCream;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public Cream getTopLayerCream() {
        return this.topLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public Topping getTopping() {
        return this.topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
      return String.format("%s cake with %d layers%s with %s shape, topped with %s cream and %s. Message says: \"%s\".",

          this.getCakeLayer(),
          this.getNumCakeLayers(),
          (this.midLayerCream != null) ? String.format(" and %s cream", this.midLayerCream) : "",
          this.getShape(),
          this.getTopLayerCream(),
          this.getTopping(),
          this.getMessage());
    }
    
    
     
   }