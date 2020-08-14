public class Main {

    public static void main(String[] args) {
        MovieRunnerAverage mra = new MovieRunnerAverage();
        mra.getAverageRatingOneMovie();
      //  mra.printAverageRatings();
        SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
   //    System.out.println("The average rating is " + sr.getAverageByID("1798709", 2));
    }
}
