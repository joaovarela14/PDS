public abstract class ChefMiddleware {
    private ChefMiddleware nextChef = null;

    public static ChefMiddleware link(ChefMiddleware first, ChefMiddleware... chefs) {
        ChefMiddleware head = first;
        for (ChefMiddleware nextInChain: chefs){
            head.next(nextInChain);
            head = nextInChain;
        }
        return first;
    }


    public void next(ChefMiddleware nextChef) {
        this.nextChef = nextChef;
    }

    public void parse(String request) {
        if (nextChef != null) {
            nextChef.parse(request);
        }
    }

    protected boolean canHandleRequest(String request, String foodType) {
        request = request.toLowerCase();
        return request.contains(foodType.toLowerCase());
    }
    
    protected int randomTime(String chefName) {
        int min = 3;
        int max = 20;
        return (int) (Math.random() * (max - min + 1) + min);
    }

    

}
