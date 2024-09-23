public class TupperWare  extends Container{
    Portion portion;


    public TupperWare(Portion portion) {
        this.portion = portion;

    }

    public String toString(){
        return "TupperWare with portion = " + portion.toString();
    }
    
}
