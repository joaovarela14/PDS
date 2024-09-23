public class Plane {
    String plane_code;
    int[][] seats_Executive;
    int[][] seats_Turistic;

    public Plane(int rows, int columns) {
        this.seats_Turistic = new int[rows][columns];
    }

    public Plane(int rows, int columns, int rows_executive, int columns_executive) {
        this.seats_Turistic = new int[rows][columns];
        this.seats_Executive = new int[rows_executive][columns_executive];
    }

    public String getPlane_code() {
        return this.plane_code;
    }

    public void setPlane_code(String plane_code) {
        this.plane_code = plane_code;
    }

    public int[][] getSeats_Executive() {
        return this.seats_Executive;
    }

    public void setSeats_Executive(int[][] seats_Executive) {
        this.seats_Executive = seats_Executive;
    }

    public int[][] getSeats_Turistic() {
        return this.seats_Turistic;
    }

    public void setSeats_Turistic(int[][] seats_Turistic) {
        this.seats_Turistic = seats_Turistic;
    }

    

    
}
