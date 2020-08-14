import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecommendationRunner implements Recommender {

    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> movies = new ArrayList<>();
        ArrayList<String> movieID = MovieDatabase.filterBy(new TrueFilter());
        for (int i = 0; i < movies.size(); i++) {
            if (!movies.contains(movieID))
                movies.add(movies.get(i));
        }
        return movies;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings fr = new FourthRatings();
        int numSimilarRaters = 20;
        int minimalRaters = 5;
        ArrayList<Rating> ratings = fr.getSimilarRatings(webRaterID, numSimilarRaters, minimalRaters);
        if (ratings.size() == 0) {
            System.out.println("<h2> There are no movies available from ratings</h2>");
        } else {
            ArrayList<String> movies = getItemsToRate();
            ArrayList<Rating> movieID = new ArrayList<>();
            int counter = 0;
            for (int i = 0; i < ratings.size(); i++) {
                if (!movies.contains(ratings.get(i).getItem())) {
                    movieID.add(ratings.get(i));
                } else counter++;
            }
            System.out.println("Movies Rated = " + movieID.size());
            System.out.println("<table id = \"rater\">");
            System.out.println("<tr>");
            System.out.println("<th>Movie Ranking</th>");
            System.out.println("<th>Movie Title </th>");
            System.out.println("<th>Movie Genre </th>");
            System.out.println("<th>Movie Release Year</th>");
            System.out.println("</tr>");
            int rank = 1;
            for(Rating i: movieID) {
                if (rank < 20) {
                    System.out.println("<tr><td>" + rank + "</td>" +
                            "<td>" + MovieDatabase.getTitle(i.getItem()) + "</td>" +
                            "<td>" + MovieDatabase.getGenres(i.getItem()) + "</td>" +
                            "<td>" + MovieDatabase.getYear(i.getItem()) + "</td>");
                    rank++;
                }
            }
        }
        System.out.println("</table>");
        System.out.println("<h3> Similar movie rankings to you! </h3>");
    }
}
