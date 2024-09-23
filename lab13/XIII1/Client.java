public class Client {
    String ID;
    String name;

    public Client(String ID, String name){
        this.ID = ID;
        this.name = name;

    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " [Number: " + this.getID() + " ,name = " + this.getName()+" ]";
    }


}
