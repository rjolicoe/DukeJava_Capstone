public class Main {

    public static void main(String[] args) {

        MovieRunnerWithFilters mrwf = new MovieRunnerWithFilters();
        // mrwf.printAverageRatingsByDirectorsAndMinutes();
        MovieRunnerSimilarRatings mrsr = new MovieRunnerSimilarRatings();
        mrsr.printSimilarRatingsByGenreAndMinutes();
    }
}
