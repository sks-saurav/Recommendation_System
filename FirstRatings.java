
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
            CSVParser parser = new CSVParser(new FileReader(filename), format);

            for (CSVRecord record : parser) {
                String id = record.get("id");
                String title = record.get("title");
                String year = record.get("year");
                String country = record.get("country");
                String genre = record.get("genre");
                String director = record.get("director");
                int minutes = Integer.parseInt(record.get("minutes"));
                String poster = record.get("poster");
                Movie movie = new Movie(id, title, year, genre, director, country, poster, minutes);
                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // movie_id,rating
    public ArrayList<EfficientRater> loadRaters(String filename) {
        ArrayList<EfficientRater> list = new ArrayList<>();
        Map<String, EfficientRater> map = new HashMap<>();
        try {
            CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
            CSVParser parser = new CSVParser(new FileReader(filename), format);

            for (CSVRecord record : parser) {
                String rater_id = record.get("rater_id");
                String movie_id = record.get("movie_id");
                Double ratings = Double.parseDouble(record.get("rating"));
                if (map.containsKey(rater_id)) {
                    EfficientRater rater = map.get(rater_id);
                    rater.addRating(movie_id, ratings);
                } else {
                    EfficientRater rater = new EfficientRater(rater_id);
                    rater.addRating(movie_id, ratings);
                    map.put(rater_id, rater);
                    list.add(rater);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void testLoadMovies(String filename) {
        ArrayList<Movie> list = loadMovies(filename);
        System.out.println(list.size());
        
        int count = 0;
        
        for (Movie movie : list) {
            //String dir = 
            if(movie.getMinutes() >= 150){
                count++;
            }
            
        }
        System.out.println("longer the 150 : "+count);
    }

    public void testLoadRaters(String filename) {
        ArrayList<EfficientRater> list = loadRaters(filename);
        System.out.println("nummber of raters = " + list.size());
        
        int min = -1;
        String ratid = "";
        for (EfficientRater rater : list) {
            if(rater.getID().equals("193")){
                System.out.println("num of raters : "+rater.numRatings());
                break;
            }
        }
        
        
        
    }
}
