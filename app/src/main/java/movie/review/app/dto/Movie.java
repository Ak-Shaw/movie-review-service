package movie.review.app.dto;

import java.util.ArrayList;

public class Movie {

  private String name;
  private int yearOfRelease;
  private ArrayList<String> genres;

  public Movie(String name, int yearOfRelease, ArrayList<String> genres) {
    this.name = name;
    this.yearOfRelease = yearOfRelease;
    this.genres = genres;
  }

  public String getName() {
    return name;
  }

  public int getYearOfRelease() {
    return yearOfRelease;
  }

  public ArrayList<String> getGenres() {
    return genres;
  }
    
}
