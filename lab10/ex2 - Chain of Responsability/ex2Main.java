import java.util.*;

public class ex2Main {
    public static void main(String[] args) {
        ChefMiddleware chefs = ChefMiddleware.link(
            new SushiChef(),
            new PastaChef(),
            new BurgerChef(),
            new PizzaChef(),
            new DessertChef()
        );
        
        List<FoodItem> foodItens = new ArrayList<>();
        foodItens.add(new FoodItem("sushi nigiri and sashimi",FoodType.SUSHI));
        foodItens.add(new FoodItem("Pasta Carbonara",FoodType.PASTA));
        foodItens.add(new FoodItem("veggie burguer",FoodType.BURGER));
        foodItens.add(new FoodItem("PLAIN pizza, no toppings!",FoodType.PIZZA));
        foodItens.add(new FoodItem("strawberry ice cream and waffles dessert",FoodType.DESSERT));
    
        for (FoodItem foodItem : foodItens) {
            System.out.println("Can I please get a " + foodItem.getName() + "?");
            chefs.parse(foodItem.getName());
            System.out.println();
        }


    }   
}
