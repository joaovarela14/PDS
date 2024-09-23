public class Jeep implements Product {
    String code;
    String descricao;
    double points;

    public Jeep(OldJeep oj){
        String oj_info = oj.getData();
        String info[] = oj_info.split(";");
        this.code = info[0];
        this.descricao = info[1];
        this.points = Double.parseDouble(info[2]);
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
