package movie.review.app.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import movie.review.app.dto.Movie;

public class DataExtractor {

  public Movie extractMovieDetails(String addMovie) {
      
  ArrayList<String> words = this.searchForAlternatingDoubleInvertedCommaEnclosedBlocks(addMovie);

  String name = words.get(0);

  ArrayList<String> genres = new ArrayList<>();

  for (int i = 1; i < words.size(); i++) {
    genres.add(words.get(i));
  }

  Pattern p = Pattern.compile("(\\d\\d\\d\\d)");
  Matcher m = p.matcher(addMovie);
  m.find();
  int yearOfRelease = Integer.parseInt(m.group());

  return new Movie(name, yearOfRelease, genres);
  }

  private ArrayList<String> searchForAlternatingDoubleInvertedCommaEnclosedBlocks(String searchString) {

    ArrayList<String> words = new ArrayList<>();

    ArrayList<Integer> indicesForDoubleInvertedCommas = new ArrayList<>();

    int i = 0;
    for (char c : searchString.toCharArray()) {

    if (c == '\"') {
      indicesForDoubleInvertedCommas.add(i);
    }

      i++;
    }

    for (int j = 0; j < indicesForDoubleInvertedCommas.size(); j += 2) {

      int leftDoubleInvertedCommaIndex = indicesForDoubleInvertedCommas.get(j);
      int rightDoubleInvertedCommaIndex = indicesForDoubleInvertedCommas.get(j + 1);
      words.add(searchString.substring(leftDoubleInvertedCommaIndex + 1, rightDoubleInvertedCommaIndex));
    }

    return words;
    
  }
    
}
