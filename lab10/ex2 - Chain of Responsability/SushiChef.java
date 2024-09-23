public class SushiChef extends ChefMiddleware{

    @Override
    public void parse(String request){
        if (canHandleRequest(request, "Sushi")) {
            System.out.printf("SushiChef : Starting to cook %s. Out in %d minutes.\n", request, this.randomTime("SushiChef"));
        } else {
            System.out.println("SushiChef : I can't cook that.");
            super.parse(request);
        }
    }
    
}