import java.util.Collections;
import java.util.ArrayList;


/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class MovieRunnerSimilarRatings {
    
    
    
    public void printAverageRatings(int minimalRaters) {
        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        FourthRatings obj = new FourthRatings();
        
        System.out.println("read data for "+RaterDatabase.size()+" raters");
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
    
    public void printAverageRatingsByYearAfterAndGenre(int minimalRaters, int year, String genre){
        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        FourthRatings obj = new FourthRatings();
        
        System.out.println("read data for "+RaterDatabase.size()+" raters");
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
    
    public void printAverageByYear(int minimalRaters, int year){
        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        FourthRatings obj = new FourthRatings();
        
        System.out.println("read data for "+RaterDatabase.size()+" raters");
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
        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        FourthRatings obj = new FourthRatings();
        
        System.out.println("read data for "+RaterDatabase.size()+" raters");
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
        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        FourthRatings obj = new FourthRatings();
        
        System.out.println("read data for "+RaterDatabase.size()+" raters");
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
        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        FourthRatings obj = new FourthRatings();
        
        System.out.println("read data for "+RaterDatabase.size()+" raters");
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
    
    
    public void printAverageRatingsByDirectorsAndMinutes(int minimalRaters,int minMinutes, int maxMinutes ,String directors){
        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        FourthRatings obj = new FourthRatings();
        
        System.out.println("read data for "+RaterDatabase.size()+" raters");
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
    
    public void printSimilarRatings(){
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings obj = new FourthRatings();
        
        ArrayList<Rating> result = obj.getSimilarRatings("65",20,5);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
        //System.out.println("found "+result.size()+" movies");
        //for (Rating rating : result) {
            //double val = rating.getValue(); 
            //System.out.printf("%.2f", val); 
            //System.out.println(MovieDatabase.getTitle(rating.getItem()));
        //}
    }
    
    public void printSimilarRatingsByGenre(){
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings obj = new FourthRatings();
        
        GenreFilter filter = new GenreFilter("Action");
        ArrayList<Rating> result = obj.getSimilarRatingsByFilter("65",20,5,filter);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
    
    public void printSimilarRatingsByDirector(){
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings obj = new FourthRatings();
        
        DirectorsFilter filter = new DirectorsFilter("Clint Eastwood,Sydney Pollack,DavidCronenberg,Oliver Stone");
        ArrayList<Rating> result = obj.getSimilarRatingsByFilter("1034",10,3,filter);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
    
    public void printSimilarRatingsByGenreAndMinute(){
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings obj = new FourthRatings();
        
        MinutesFilter mfilter = new MinutesFilter(100, 200);
        GenreFilter gfilter = new GenreFilter("Adventure");
        AllFilters filter = new AllFilters();
        filter.addFilter(mfilter);
        filter.addFilter(gfilter);
        ArrayList<Rating> result = obj.getSimilarRatingsByFilter("65",10,5,filter);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
    
    public void printSimilarRatingsByYearAfterAndMinutes(){
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings obj = new FourthRatings();
        
        MinutesFilter mfilter = new MinutesFilter(80, 100);
        YearAfterFilter yfilter = new YearAfterFilter(2000);
        AllFilters filter = new AllFilters();
        filter.addFilter(mfilter);
        filter.addFilter(yfilter);
        ArrayList<Rating> result = obj.getSimilarRatingsByFilter("65",10,5,filter);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
}
