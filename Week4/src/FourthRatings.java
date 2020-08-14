import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Collections;

public class FourthRatings {

    public double getAverageByID(String id, int minimalRatings){
        ArrayList<Rater> myRaters = RaterDatabase.getRaters();
        double average=0;
        double sum=0;
        int countRaters=0;
        for (Rater r: myRaters) {
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

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (String id : movies) {
            double averageRating = getAverageByID(id, minimalRaters);
            if (averageRating != 0) {
                Rating r = new Rating(id, averageRating);
                ratings.add(r);
            }
        }
        return ratings;
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for(String id: movies){
            double averageRating = getAverageByID(id, minimalRaters);
            if (averageRating != 0) {
                Rating r = new Rating(id, averageRating);
                ratings.add(r);
            }
        }
        return ratings;
    }

    private double dotProduct(Rater me, Rater r) {
        double dotProduct = 0;
        ArrayList<String> myMovies = me.getItemsRated();
        for (String id: myMovies)
        {
            if (r.hasRating(id))
            {
                double myRating = me.getRating(id);
                double rRating = r.getRating(id);
                myRating -= 5;
                rRating -= 5;
                dotProduct += myRating * rRating;
            }
        }
        return dotProduct;
    }

    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> list = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r: RaterDatabase.getRaters()){
            if(!r.equals(me)){
                double product = dotProduct(me, r);
                if(product > 0)
                    list.add(new Rating(r.getID(),product));
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
        ArrayList<Rating> list = new ArrayList<Rating>();
        ArrayList<Rating> sim = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String movieId: movies){
            double wa = 0;
            double sum = 0;
            int cr = 0;
            for(int i=0; i < numSimilarRaters; i++){
                Rating r = sim.get(i);
                double w = r.getValue();
                String raterID = r.getItem();
                Rater myRater = RaterDatabase.getRater(raterID);
                if(myRater.hasRating(movieId)){
                    cr++;
                    sum += w*myRater.getRating(movieId);
                }
            }
            if(cr >= minimalRaters){
                wa = sum/cr;
                list.add(new Rating(movieId, wa));
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> list = new ArrayList<Rating>();
        ArrayList<Rating> sim = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String movieId: movies){
            double wa = 0;
            double sum = 0;
            int cr = 0;
            for(int i=0; i < numSimilarRaters; i++){
                Rating r = sim.get(i);
                double w = r.getValue();
                String raterID = r.getItem();
                Rater myRater = RaterDatabase.getRater(raterID);
                if(myRater.hasRating(movieId)){
                    cr++;
                    sum += w*myRater.getRating(movieId);
                }
            }
            if(cr >= minimalRaters){
                wa = sum/cr;
                list.add(new Rating(movieId, wa));
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
}
