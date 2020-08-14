import java.util.*;

public class SecondRating {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myPlainRaters;

    public SecondRating() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }

    public SecondRating(String moviefile, String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myPlainRaters = fr.loadRaters(ratingsfile);
    }

    public int getMovieSize(){
        return myMovies.size();
    }

    public int getRaterSize(){
        return myPlainRaters.size();
    }

    private double getAverageByID(String id, int minimalRatings){
        double average=0;
        double sum=0;
        int countRaters=0;
        for (Rater r: myPlainRaters) {
            if (r.hasRating(id)) {
                countRaters++;
                sum += r.getRating(id);

            }
        }
        if(countRaters >= minimalRatings){
            average = sum/countRaters;
        }
        return average;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (Movie m: myMovies){
            double averageRating = getAverageByID(m.getId(),minimalRaters);
            if(averageRating !=0){
                Rating r = new Rating(m.getId(), averageRating);
                ratings.add(r);
            }
        }
        return ratings;
    }

    public String getTitle(String id){
        for(Movie m: myMovies){
            if(m.getId().equals(id)){
                return m.getTitle();
            }
        }
        return "The movie ID " + id + " was not found";
    }

    public String getID(String title){
        for(Movie m: myMovies){
            if(m.getTitle().equals(title)){
                return m.getId();
            }
        }
        return "The movie title " + title + " was not found";
    }



}
