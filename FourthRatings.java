import java.util.*;

/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class FourthRatings {
    
    public double getAverageByID(String id, int minimalRaters) {
        int count = 0;
        int totalRating = 0;
        for (Rater rater : RaterDatabase.getRaters()) {
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
    
    private double dotProduct(Rater me, Rater r){
        double dotpdt = 0d;
        ArrayList<String> list1 = me.getItemsRated();
        for(String id : list1){
            double rval = r.getRating(id);
            double meval = me.getRating(id);
            if(rval > 0){
                rval = rval-5;
                meval = meval-5;
                dotpdt += rval*meval;
            }
        }
        return dotpdt;
    }
    
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> result = new ArrayList<>();
        ArrayList<Rater> list =  RaterDatabase.getRaters();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r : list){
            if(r.getID().equals(id))
                continue;
            double dotpdt = dotProduct(me, r);
            if(dotpdt > 0){
                result.add(new Rating(r.getID(), dotpdt));
            }
        }
        Collections.sort(result, Comparator.reverseOrder());
        return result;
    }
    
    private double getSimilarAvgById(String mov_id, int minimalRaters,int numSimilarRaters ,ArrayList<Rating> similarities){
        int count = 0;
        double total_wt = 0d;
        for(Rating wt : similarities){
            if(numSimilarRaters <= 0)
                break;
            String rat_id = wt.getItem();
            Rater rater = RaterDatabase.getRater(rat_id);
            if(rater.hasRating(mov_id)){
                count++;
                total_wt += (rater.getRating(mov_id)*wt.getValue());
            }
            numSimilarRaters--;
        }
        
        if (count < minimalRaters || count == 0) {
            return 0d;
        } else {
            return total_wt / (double) count;
        }
        
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
        ArrayList<Rating> similarities = getSimilarities(id);
        
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> list = new ArrayList<>();
        for (String mov_id : movies) {
            double rating = getSimilarAvgById(mov_id, minimalRaters,numSimilarRaters ,similarities);
            if (rating > 0.0) {
                list.add(new Rating(mov_id, rating));
            }
        }
        Collections.sort(list, Comparator.reverseOrder());
        return list;
        
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> similarities = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> list = new ArrayList<>();
        for (String mov_id : movies) {
            double rating = getSimilarAvgById(mov_id, minimalRaters,numSimilarRaters ,similarities);
            if (rating > 0.0) {
                list.add(new Rating(mov_id, rating));
            }
        }
        Collections.sort(list, Comparator.reverseOrder());
        return list;
    }
}
