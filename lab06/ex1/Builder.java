public abstract class Builder implements CakeBuilder{
    Cake cake = new Cake();

    public void setCakeShape(Shape shape){
        this.cake.setShape(shape);

    }
    public void addCakeLayer(){
        this.cake.addCakeLayer();

    }
    public abstract void addCreamLayer();
    public abstract void addTopLayer();
    public abstract void addTopping();

    public void addMessage(String m){
        this.cake.setMessage(m);
    } 

    @Override
    public void createCake() {
      this.addCakeLayer();
      this.addCreamLayer();
      this.addTopLayer();
      this.addTopping();
    }
    
    public Cake getCake(){
        return cake; 
        
    }
}