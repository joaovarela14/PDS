

public class Main {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");       // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");    // squared, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(Shape.Rectangle,3, "The best");           // 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        // you should add here other example(s) of CakeBuilder          


        CakeBuilder velvet = new VelvetCakeBuilder();
        cakeMaster.setCakeBuilder(velvet);
        cakeMaster.createCake(Shape.Rectangle, 4, "Happy Birthday"); // rectangle, 4 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder carrot = new CarrotCakeBuilder();
        cakeMaster.setCakeBuilder(carrot);
        cakeMaster.createCake(5, "Happy New Year"); // 5 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Testing second Choco Cake"); // 1 cake layer
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

    }
}
