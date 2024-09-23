public class Motorcycle implements Product{
    String code;
    String descricao;
    double points;


    public Motorcycle(String code, String descricao, int points){
        this.code = code;
        this.descricao = descricao;
        this.points = points;
    }
 

    public String code(){
        return this.code;
    }

    public String description(){
        return this.descricao;
    }

    public double points(){
        return this.points;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[code " + code() + ", descr: " + description()
        + ", points =  " + points() ;
    }
}
