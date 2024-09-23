import java.util.ArrayList;
import java.util.List;

public class Movie {
   private final String title;
   private final int year;
   private final Person director;
   private final Person writer;
   private final String series;
   private final List<Person> cast;
   private final List<Place> locations;
   private final List<String> languages;
   private final List<String> genres;
   private final boolean isTelevision;
   private final boolean isNetflix;
   private final boolean isIndependent;

   public Movie(
      final String movieTitle,
      final int movieYear,
      final Person movieDirector,
      final Person movieWriter,
      final String movieSeries,
      final List<Person> movieCast,
      final List<Place> movieLocations,
      final List<String> movieLanguages,
      final List<String> movieGenres,
      final boolean television,
      final boolean netflix,
      final boolean independent)    {
      this.title = movieTitle;
      this.year = movieYear;
      this.director = movieDirector;
      this.writer = movieWriter;
      this.series = movieSeries;
      this.cast = movieCast;
      this.locations = movieLocations;
      this.languages = movieLanguages;
      this.genres = movieGenres;
      this.isTelevision = television;
      this.isNetflix = netflix;
      this.isIndependent = independent;
   }

   public static class Builder {
      private final String title;
      private final int year;
      private Person director;
      private Person writer;
      private String series;
      private List<Person> cast = new ArrayList<>();
      private List<Place> locations = new ArrayList<>();
      private List<String> languages = new ArrayList<>();
      private List<String> genres = new ArrayList<>();
      private boolean isTelevision;
      private boolean isNetflix;
      private boolean isIndependent;

      //definição dos métodos de construção do objeto que como só é um objeto não é necessário uma interface

      public Builder(String title, int year) {
         this.title = title;
         this.year = year;
      }

      public Builder director(Person director) {
         this.director = director;
         return this;
      }

      public Builder writer(Person writer) {
         this.writer = writer;
         return this;
      }

      public Builder series(String series) {
         this.series = series;
         return this;
      }

      public Builder addCast(List<Person> cast) {
         this.cast.addAll(cast);
         return this;
      }

      public Builder addLocations(List<Place> locations) {
         this.locations.addAll(locations);
         return this;
      }

      public Builder addLanguages(List<String> languages) {
         this.languages.addAll(languages);
         return this;
      }

      public Builder addGenres(List<String> genres) {
         this.languages.addAll(genres);
         return this;
      }

      public Builder isTelevision(boolean isTelevision) {
         this.isTelevision = isTelevision;
         return this;
      }

      public Builder isNetflix(boolean isNetflix) {
         this.isNetflix = isNetflix;
         return this;
      }

      public Builder isIndependent(boolean isIndependent) {
         this.isIndependent = isIndependent;
         return this;
      }

      public Movie build() {
         return new Movie(this);
      }

   }
   
   public Movie(Builder builder) {
      this.title = builder.title;
      this.year = builder.year;
      this.director = builder.director;
      this.writer = builder.writer;
      this.series = builder.series;
      this.cast = builder.cast;
      this.locations = builder.locations;
      this.languages = builder.languages;
      this.genres = builder.genres;
      this.isTelevision = builder.isTelevision;
      this.isNetflix = builder.isNetflix;
      this.isIndependent = builder.isIndependent;
   }

   @Override
   public String toString() {
       return String.format("Movie{\n" +
               "   title='%s',\n" +
               "   year=%d,\n" +
               "   director='%s',\n" +
               "   writer='%s',\n" +
               "   series='%s',\n" +
               "   cast=%s,\n" +
               "   locations=%s,\n" +
               "   languages=%s,\n" +
               "   genres=%s,\n" +
               "   isTelevision=%b,\n" +
               "   isNetflix=%b,\n" +
               "   isIndependent=%b\n" +
               "}",
               title,
               year,
               director,
               writer,
               series,
               cast,
               locations,
               languages,
               genres,
               isTelevision,
               isNetflix,
               isIndependent);
   }
   
}
