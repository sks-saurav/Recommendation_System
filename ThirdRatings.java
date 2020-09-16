
/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class ThirdRatings {
    private ArrayList<EfficientRater> myRaters;

    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
        //this("ratedmovies_short.csv","ratings_short.csv");
    }

    public ThirdRatings(String ratingsfile) {
        FirstRatings obj = new FirstRatings();
        myRaters = obj.loadRaters(ratingsfile);
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
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> list = new ArrayList<>();
        for (String id : movies) {
            double rating = getAverageByID(id, minimalRaters);
            if (rating > 0.0) {
                list.add(new Rating(id, rating));
            }
        }
        return list;
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> list = new ArrayList<>();
        for (String id : movies) {
            double rating = getAverageByID(id, minimalRaters);
            if (rating > 0.0) {
                list.add(new Rating(id, rating));
            }
        }
        return list;
    }

}
