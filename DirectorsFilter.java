
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter{
    private String directors;
    
    public DirectorsFilter(String directors){
        this.directors = directors;
    }
    
    @Override
    public boolean satisfies(String id){
        return MovieDatabase.getDirector(id).contains(directors) || directors.contains(MovieDatabase.getDirector(id));
    }
}
