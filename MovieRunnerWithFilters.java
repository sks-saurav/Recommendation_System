
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Collections;
import java.util.ArrayList;

public class MovieRunnerWithFilters {
    public void printAverageRatings(int minimalRaters) {
        ThirdRatings obj = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for "+obj.getRaterSize()+" raters");
        
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> result = obj.getAverageRatings(minimalRaters);
        System.out.println("found "+result.size()+" movies");
        Collections.sort(result);
        for (Rating rating : result) {
            double val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" "+MovieDatabase.getTitle(rating.getItem()));
        }
    }
    
    public void printAverageByYear(int minimalRaters, int year){
        ThirdRatings obj = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for "+obj.getRaterSize()+" raters");
        
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        YearAfterFilter filter = new YearAfterFilter(year);
        ArrayList<Rating> result = obj.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("found "+result.size()+" movies");
        Collections.sort(result);
        for (Rating rating : result) {
            double val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" "+MovieDatabase.getTitle(rating.getItem()));
        }
    }
    
    public void printAverageByGenre(int minimalRaters, String genre){
        ThirdRatings obj = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for "+obj.getRaterSize()+" raters");
        
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        GenreFilter filter = new GenreFilter(genre);
        ArrayList<Rating> result = obj.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("found "+result.size()+" movies");
        Collections.sort(result);
        for (Rating rating : result) {
            double val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println(MovieDatabase.getGenres(rating.getItem())); 
        }
    }
    
    public void printAverageRatingsByMinutes(int minimalRaters, int minMinutes, int maxMinutes){
        ThirdRatings obj = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for "+obj.getRaterSize()+" raters");
        
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        MinutesFilter filter = new MinutesFilter(minMinutes, maxMinutes);
        ArrayList<Rating> result = obj.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("found "+result.size()+" movies");
        Collections.sort(result);
        for (Rating rating : result) {
            double val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" Time: "+MovieDatabase.getMinutes(rating.getItem())+" "+MovieDatabase.getTitle(rating.getItem()));
        }
    }
    
    public void printAverageRatingsByDirectors(int minimalRaters, String directors){
        ThirdRatings obj = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for "+obj.getRaterSize()+" raters");
        
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        DirectorsFilter filter = new DirectorsFilter(directors);
        ArrayList<Rating> result = obj.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("found "+result.size()+" movies");
        Collections.sort(result);
        for (Rating rating : result) {
            double val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println(MovieDatabase.getDirector(rating.getItem()));
        }
    }
    
    public void printAverageRatingsByYearAfterAndGenre(int minimalRaters, int year, String genre){
        ThirdRatings obj = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for "+obj.getRaterSize()+" raters");
        
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        GenreFilter gfilter = new GenreFilter(genre);
        YearAfterFilter yfilter = new YearAfterFilter(year);
        AllFilters filter = new AllFilters();
        filter.addFilter(gfilter);
        filter.addFilter(yfilter);
        
        ArrayList<Rating> result = obj.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("found "+result.size()+" movies");
        Collections.sort(result);
        for (Rating rating : result) {
            double val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" "+MovieDatabase.getYear(rating.getItem())+" "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println(MovieDatabase.getGenres(rating.getItem())); 
        }
    }
    
    public void printAverageRatingsByDirectorsAndMinutes(int minimalRaters,int minMinutes, int maxMinutes ,String directors){
         ThirdRatings obj = new ThirdRatings("ratings_short.csv");
        System.out.println("read data for "+obj.getRaterSize()+" raters");
        
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        MinutesFilter mfilter = new MinutesFilter(minMinutes, maxMinutes);
        DirectorsFilter dfilter = new DirectorsFilter(directors);
        AllFilters filter = new AllFilters();
        filter.addFilter(mfilter);
        filter.addFilter(dfilter);
        
        
        ArrayList<Rating> result = obj.getAverageRatingsByFilter(minimalRaters, filter);
        System.out.println("found "+result.size()+" movies");
        Collections.sort(result);
        for (Rating rating : result) {
            double val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" Time: "+MovieDatabase.getMinutes(rating.getItem())+" "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println(MovieDatabase.getDirector(rating.getItem()));
        }
    }
}
