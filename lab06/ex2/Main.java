

import java.util.List;

public class Main {
    public static void main(String[] args) { 
        Movie movie1 = new Movie.Builder("Title", 2024)
            .director(new Person("Director"))
            .writer(new Person("Writer"))
            .series("Series")
            .addCast(List.of(new Person("Joao")))
            .addLocations(List.of(new Place("Portugal")))
            .addLanguages(List.of("Portuguese"))
            .addGenres(List.of("Comedy"))
            .isTelevision(true)
            .isNetflix(true)
            .isIndependent(true)
            .build();
       
        System.out.println(movie1);
    }

}
