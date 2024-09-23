public abstract class CommonPropertiesShip implements Ship {

    String code;
    String name;

    public CommonPropertiesShip(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String code(){
        return this.code;
    }

    public String name(){
        return this.name;
    }


} 