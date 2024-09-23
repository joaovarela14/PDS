public class PortionFactory {
    
    public static Portion create(String type, Temperature temperature){
        switch(type + temperature){
            case "MeatWARM":
                return new Pork();
            case "MeatCOLD":    
                return new Tuna();
            case "BeverageWARM":
                return new Milk();
            case "BeverageCOLD":
                return new FruitJuice();
        }
        return null;
    }
}
