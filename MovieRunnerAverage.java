import java.util.*;

/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovieRunnerAverage {
    public void printAverageRatings(int minimalRaters) {
        SecondRatings obj = new SecondRatings();
        System.out.println(obj.getMovieSize());
        System.out.println(obj.getRaterSize());
        double val = 0.00;
        ArrayList<Rating> result = obj.getAverageRatings(minimalRaters);
        Collections.sort(result);
        for (Rating rating : result) {
            val = rating.getValue(); 
            System.out.printf("%.2f", val); 
            System.out.println(" "+rating.getItem());
        }
    }
    
    public void getAverageRatingOneMOvie(String title) {
        SecondRatings obj = new SecondRatings();
        String id = obj.getID(title);
        double rating = obj.getAverageByID(id,0);
        System.out.println(rating);
    }
}
