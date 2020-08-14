import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {

    public void printAverageRatings() {
        RaterDatabase.initialize("ratings_short.csv");
        FourthRatings fr = new FourthRatings();
        System.out.println("The number of raters: " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 1;
        ArrayList<Rating> ratings = fr.getAverageRatings(minimalRaters);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);
        for (Rating r : ratings) {
            System.out.println(r.getValue() + " " +
                    MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        RaterDatabase.initialize("ratings_short.csv");
        FourthRatings fr = new FourthRatings();
        System.out.println("The number of raters: " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 1;
        String genre = "Romance";
        int year = 1980;
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new YearAfterFilter(year));
        filterCriteria.addFilter(new GenreFilter(genre));
        ArrayList<Rating> ratings = fr.getAverageRatingsByFilter(minimalRaters,
                filterCriteria);
        Collections.sort(ratings);
        System.out.println(ratings.size() + " movie matched");
        for (Rating r : ratings) {
            System.out.println(r.getValue() + " " +
                    MovieDatabase.getYear(r.getItem()) + " " +
                    MovieDatabase.getTitle(r.getItem()) + "\n" + " " +
                    MovieDatabase.getGenres(r.getItem()));
        }
    }

    public void printSimilarRaters(){
        RaterDatabase.initialize("ratings.csv");
        FourthRatings fr = new FourthRatings();
        System.out.println("The number of raters: " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int minimalRaters = 5;
        String raterID = "71";
        int numSimilarRaters = 20;
        ArrayList<Rating> ratings = fr.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        for(int i= 0; i < ratings.size(); i++){
            if(i < 15){
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
            }
        }
    }

    public void printSimilarRatersByGenre(){
        RaterDatabase.initialize("ratings.csv");
        FourthRatings fr = new FourthRatings();
        System.out.println("The number of raters: " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        String genre = "Mystery";
        String raterID = "964";
        int minimalRaters = 5;
        int numSimilarRaters = 20;
        Filter filterCriteria = new GenreFilter(genre);
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID,numSimilarRaters,minimalRaters,filterCriteria);
        for(int i=0; i < ratings.size(); i++){
            if(i < 15){
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
            }
        }
    }

    public void printSimilarRatingsByDirector(){
        RaterDatabase.initialize("ratings.csv");
        FourthRatings fr = new FourthRatings();
        System.out.println("The number of raters: " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        String director = "Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh";
        String raterID = "120";
        int minimalRaters = 2;
        int numSimilarRaters = 10;
        Filter filterCriteria = new DirectorsFilter(director);
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filterCriteria);
        for(int i=0; i < ratings.size(); i++){
            if(i < 10){
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()));
            }
        }
    }

    public void printSimilarRatingsByGenreAndMinutes(){
        RaterDatabase.initialize("ratings.csv");
        FourthRatings fr = new FourthRatings();
        System.out.println("The number of raters: " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        String genre = "Drama";
        int min = 80;
        int max = 160;
        String raterID = "168";
        int minimalRaters = 3;
        int numSimilarRaters = 10;
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new GenreFilter(genre));
        filterCriteria.addFilter(new MinutesFilter(min,max));
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filterCriteria);
        for(int i=0; i < ratings.size(); i++){
            if(i < 10){
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()) +  ": Genre Type = " +
                        MovieDatabase.getGenres(ratings.get(i).getItem()));
            }
        }
    }

    public void printSimilarRatingsByYearAfterAndMinutes(){
        RaterDatabase.initialize("ratings.csv");
        FourthRatings fr = new FourthRatings();
        System.out.println("The number of raters: " + RaterDatabase.size() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("The number of movies are " +
                MovieDatabase.size());
        int year = 1975;
        int min = 70;
        int max = 200;
        String raterID = "314";
        int minimalRaters = 5;
        int numSimilarRaters = 10;
        AllFilters filterCriteria = new AllFilters();
        filterCriteria.addFilter(new YearAfterFilter(year));
        filterCriteria.addFilter(new MinutesFilter(min, max));
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(raterID, numSimilarRaters, minimalRaters, filterCriteria);
        for(int i=0; i < ratings.size(); i++){
            if(i< 10){
                System.out.printf("%d %.2f %s\n", i, ratings.get(i).getValue(), MovieDatabase.getTitle(ratings.get(i).getItem()) +  ": Running Time: " +
                        MovieDatabase.getMinutes(ratings.get(i).getItem()) + " and Year Released: " +
                        MovieDatabase.getYear(ratings.get(i).getItem()));
            }
        }
    }

}

