public class Voo {
    String codigo;
    Plane aviao;
    int reservas;
    int available_seats_turistic;
    int available_seats_executive;
    boolean possible_booking = true;
    char letter_fila;
    int letter_fila_num;
    String lugares_atribuidos = "";
    boolean contains_executive = false;

    public Voo(String codigo, Plane aviao) {
        this.codigo = codigo;
        this.aviao = aviao;
        this.reservas = 0;
        if (aviao.getSeats_Executive() != null) {
            this.available_seats_executive = aviao.getSeats_Executive().length * aviao.getSeats_Executive()[0].length;
        }
        else {
            this.available_seats_executive = 0;
        }
        this.available_seats_turistic = aviao.getSeats_Turistic().length * aviao.getSeats_Turistic()[0].length;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Plane getAviao() {
        return this.aviao;
    }

    public void setAviao(Plane aviao) {
        this.aviao = aviao;
    }

    public int getReservas() {
        return this.reservas;
    }

    public void setReservas(int reservas) {
        this.reservas = reservas;
    }

    public boolean ContainsExecutive(){
        return contains_executive;

    }

    public boolean addReserva(int[][] seats, int number_of_seats, String class_type) {
        int fila_vazia = -1;
        lugares_atribuidos = "";
        possible_booking = true;

        

        int available_seats = class_type.equals("Turistic") ? this.available_seats_turistic : this.available_seats_executive;

        if (available_seats < number_of_seats) {     
            possible_booking = false;       
            String class_type_string = class_type.equals("Turistic") ? "T" : "E";
            System.out.println("Não foi possível obter lugares para a reserva: " + class_type_string + " " + number_of_seats);
            return false;
        }

        if (possible_booking) {
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    //verifica se a fila está vazia
                    if (seats[i][j] != 0) {
                        break;
                    }
                    else if (seats[i][j] == 0) {
                        fila_vazia = i;
                        break;
                    }
                    
                }
                if (fila_vazia != -1) {
                    break;
                }
            }
    
            int count = 0;
    
            if (fila_vazia == -1) {
                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < seats[i].length; j++) {
                        letter_fila_num = 65 + j; // 'A' ascii
                        letter_fila = (char) letter_fila_num;
                        if (seats[i][j] == 0) {
                            seats[i][j] = this.reservas + 1;
                            if (class_type.equals("Turistic")) {
                                this.available_seats_turistic--;
                            }
                            else {
                                this.available_seats_executive--;
                            }
                            count++;
                            if (class_type.equals("Executive")) {
                                lugares_atribuidos += (i+1) + "" + letter_fila + " | " ;
    
                            } else {
                                //int number_of_seats_executive = this.aviao.getSeats_Executive()[0].length() * this.aviao.getSeats_Executive().length;
                                if (this.aviao.getSeats_Executive() != null) {
                                    lugares_atribuidos += (i+1+this.aviao.getSeats_Executive().length) + "" + letter_fila + " | " ;
                                }
                                else {
                                    lugares_atribuidos += (i+1) + "" + letter_fila + " | " ;
                                }
                            }
                        }

                        if (count == number_of_seats) {
                            this.reservas++;
                            break;
                        }
                        
                    }

                    

                    if (count == number_of_seats) {
                        break;
                        
                    }   
                }
    
                if (count < number_of_seats) {
                    return false;
                }
                else {
                    if (class_type.equals("Turistic")) {
                        this.aviao.setSeats_Turistic(seats);
                        return true;
                    }
                    else {
                        this.aviao.setSeats_Executive(seats);
                        return true;
                    }
                }
    
    
            }
        
            else {
                for (int fila  = fila_vazia; fila < seats.length; fila++) {
                    for (int coluna = 0; coluna < seats[fila].length; coluna++) {
                        if (seats[fila][coluna] == 0) {
                            letter_fila_num = 65 + coluna; // 'A' ascii
                            letter_fila = (char) letter_fila_num;
                            seats[fila][coluna] = this.reservas + 1;
                            if (class_type.equals("Turistic")) {
                                this.available_seats_turistic--;
                            }
                            else {
                                this.available_seats_executive--;
                            }
                            count++;   
                            if (class_type.equals("Executive")) {
                                lugares_atribuidos += (fila+1) + "" + letter_fila + " | " ;
    
                            } else {
                                if (this.aviao.getSeats_Executive() != null) {
                                    lugares_atribuidos += (fila+1+this.aviao.getSeats_Executive().length) + "" + letter_fila + " | " ;
                                }
                                else {
                                    lugares_atribuidos += (fila+1) + "" + letter_fila + " | " ;
                                }
                               
                            }
                        }

                        if (count == number_of_seats) {
                            this.reservas++;
                            break;
    
                        }
                        
                    }

                    
                    if (count == number_of_seats) {
                        break;
                    }
                
            }            

            if (count < number_of_seats) {
                return false;
            }
            else {
                if (class_type.equals("Turistic")) {
                    this.aviao.setSeats_Turistic(seats);
                    return true;
                }
                else {
                    this.aviao.setSeats_Executive(seats);
                    return true;
                }
            }
        }

        }
        return false;
    }

    public void printLugaresReservados() {
        lugares_atribuidos = lugares_atribuidos.substring(0, lugares_atribuidos.length() - 2);
        System.out.println(lugares_atribuidos);
    }

    public void removeReserva(int reserva_number){

        if (this.aviao.getSeats_Executive() != null) {
            for (int i = 0; i < this.aviao.getSeats_Executive().length; i++) {
                for (int j = 0; j < this.aviao.getSeats_Executive()[i].length; j++) {
                    if (this.aviao.getSeats_Executive()[i][j] == reserva_number) {
                        this.aviao.getSeats_Executive()[i][j] = 0;
                        this.available_seats_executive++;
                    }
                }
            }
        }
        for (int i = 0; i < this.aviao.getSeats_Turistic().length; i++) {
            for (int j = 0; j < this.aviao.getSeats_Turistic()[i].length; j++) {
                if (this.aviao.getSeats_Turistic()[i][j] == reserva_number) {
                    this.aviao.getSeats_Turistic()[i][j] = 0;
                    this.available_seats_turistic++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", aviao='" + getAviao() + "'" +
            ", reservas='" + getReservas() + "'" +
            "}";
    }

    
}



