public class Main {

    public static void main(String[] args) {
        FirstRatings fr = new FirstRatings();
       // fr.testLoadRaters();
        MovieRunnerWithFilters mrwf = new MovieRunnerWithFilters();
        mrwf.printAverageRatingsByDirectorsAndMinutes();
    }
}
