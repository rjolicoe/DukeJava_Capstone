import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {

    public void printAverageRatings() {
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("The number of raters: " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 35;
        ArrayList<Rating> ratings = tr.getAverageRatings(minimalRaters);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);
        for (Rating r : ratings) {
            System.out.println(r.getValue() + " " +
                    MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYear() {
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("The number of raters: " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 20;
        int year = 2000;
        Filter filterCriteria = new YearAfterFilter(year);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);
        for (Rating r : ratings) {
            System.out.println(r.getValue() + " " +
                    MovieDatabase.getTitle(r.getItem()));
        }

    }

    public void printAverageRatingsByGenre() {
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("The number of raters: " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 20;
        String genre = "Comedy";
        Filter filterCriteria = new GenreFilter(genre);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);
//        for (Rating r : ratings) {
//            System.out.println(r.getValue() + " " +
//                    MovieDatabase.getTitle(r.getItem()) + " " +
//                    MovieDatabase.getGenres(r.getItem()));
//        }

    }

    public void printAverageRatingsByMinutes() {
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("The number of raters: " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 5;
        int min = 105;
        int max = 135;
        Filter filterCriteria = new MinutesFilter(min, max);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        System.out.println("found " + ratings.size() + " movies");
//        Collections.sort(ratings);
//        for (Rating r : ratings) {
//            System.out.println(r.getValue() + " Time: " +
//                    MovieDatabase.getMinutes(r.getItem()) + " " +
//                    MovieDatabase.getTitle(r.getItem()));
//        }
    }

    public void printAverageRatingsByDirector() {
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("The number of raters: " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 4;
        String directors = "Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack";
        Filter filterCriteria = new DirectorsFilter(directors);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        System.out.println("found " + ratings.size() + " movies");
//        Collections.sort(ratings);
//        for (Rating r : ratings) {
//            System.out.println(r.getValue() + " " +
//                    MovieDatabase.getTitle(r.getItem()) +
//                    "\n " + MovieDatabase.getDirector(r.getItem()));
//        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("The number of raters: " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 8;
        String genre = "Drama";
        int year = 1990;
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new YearAfterFilter(year));
        filterCriteria.addFilter(new GenreFilter(genre));
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters,
                filterCriteria);
        Collections.sort(ratings);
        System.out.println(ratings.size() + " movie matched");
//        for (Rating r : ratings) {
//            System.out.println(r.getValue() + " " +
//                    MovieDatabase.getYear(r.getItem()) + " " +
//                    MovieDatabase.getTitle(r.getItem()) + "\n" + " " +
//                    MovieDatabase.getGenres(r.getItem()));
//        }
    }

    public void printAverageRatingsByDirectorsAndMinutes(){
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("The number of raters: " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 3;
        String directors = "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack";
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new MinutesFilter(90, 180));
        filterCriteria.addFilter(new DirectorsFilter(directors));
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        Collections.sort(ratings);
        System.out.println(ratings.size() + " movies matched");
//        for (Rating r: ratings){
//            System.out.println(r.getValue() + " Time: " +
//                    MovieDatabase.getMinutes(r.getItem()) + " " +
//                    MovieDatabase.getTitle(r.getItem()) + "\n " +
//                    MovieDatabase.getDirector(r.getItem()));
//        }
    }
}
