public class BurgerChef extends ChefMiddleware {

    @Override
    public void parse(String request) {
        if (canHandleRequest(request, "Burger")) {
            System.out.printf("BurgerChef : Starting to cook %s. Out in %d minutes.\n", request,
                    this.randomTime("BurgerChef"));
        } else {
            System.out.println("BurgerChef : I can't cook that.");
            super.parse(request);
        }
    }

}
