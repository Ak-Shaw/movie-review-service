package movie.review.app.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import movie.review.app.dto.Movie;

public class DataExtractorTest {
    
  @Test
  public void extractMovieDetailsTest() {

    String addMovie = "Add Movie(\"Don\" released in Year 2006 for Genres \"Action\" & \"Comedy\")";

    DataExtractor dataExtractor = new DataExtractor();

    Movie movie = new DataExtractor().extractMovieDetails(addMovie);

    assertEquals("Don", movie.getName());
    assertEquals(2006, movie.getYearOfRelease());
    assertEquals("Action", movie.getGenres().get(0));
    assertEquals("Comedy", movie.getGenres().get(1));
  }
}
