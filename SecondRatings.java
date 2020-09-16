
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<EfficientRater> myRaters;

    public SecondRatings() {
        // default constructor
        //this("ratedmoviesfull.csv", "ratings.csv");
        this("ratedmovies_short.csv","ratings_short.csv");
    }

    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings obj = new FirstRatings();
        myMovies = obj.loadMovies(moviefile);
        myRaters = obj.loadRaters(ratingsfile);
    }

    public int getMovieSize() {
        return myMovies.size();
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    public double getAverageByID(String id, int minimalRaters) {
        int count = 0;
        int totalRating = 0;
        for (EfficientRater rater : myRaters) {
            double rating = rater.getRating(id);
            if (rating >= 0) {
                count++;
                totalRating += rating;
            }
        }

        if (count < minimalRaters || count == 0) {
            return 0.0;
        } else {
            return totalRating / (double) count;
        }
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> list = new ArrayList<>();
        for (Movie m : myMovies) {
            double rating = getAverageByID(m.getID(), minimalRaters);
            if (rating > 0.0) {
                list.add(new Rating(m.getID(), rating));
            }
        }
        return list;
    }

    public String getTitle(String id) {
        for (Movie m : myMovies) {
            if (id.equals(m.getID())) {
                return m.getTitle();
            }
        }
        return "ID was not found";
    }

    public String getID(String title) {
        for (Movie m : myMovies) {
            if (title.equals(m.getTitle())) {
                return m.getID();
            }
        }
        return "NO SUCH TITLE";
    }
}