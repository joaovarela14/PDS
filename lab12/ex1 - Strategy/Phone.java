
public class Phone {

    private String processor;
    private String camera;
    private int price;
    private int storage;

    public Phone(String processor, String camera, int price, int storage) {
        this.processor = processor;
        this.camera = camera;
        this.price = price;
        this.storage = storage;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCamera() {
        return this.camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStorage() {
        return this.storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return String.format("Processor %-15s | Storage %-10s GB | Camera %-15s | Price %-5s", getProcessor(), getStorage(), getCamera(), getPrice());
    }



}
