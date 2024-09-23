package startypes;
import java.awt.*;

public abstract class StarType {

    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;
    private int x;
    private int y;

    public StarType(int size, Color color) {
        this.size = size;
        this.color = color;

    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(x, y , size, size);
    }


    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float[] getPhysicalProperties() {
        return this.physicalProperties;
    }

    public void setPhysicalProperties(Float[] physicalProperties) {
        this.physicalProperties = physicalProperties;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}