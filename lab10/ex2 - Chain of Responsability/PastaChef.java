public class PastaChef extends ChefMiddleware{
    
    @Override
    public void parse(String request){
        if (canHandleRequest(request, "Pasta")) {
            System.out.printf("PastaChef : Starting to cook %s. Out in %d minutes.\n", request, this.randomTime("PastaChef"));
        } else {
            System.out.println("PastaChef : I can't cook that.");
            super.parse(request);
        }
    }
}
