public class Main {

    public static void main(String[] args) {

        MovieRunnerWithFilters mrwf = new MovieRunnerWithFilters();
        // mrwf.printAverageRatingsByDirectorsAndMinutes();
        RecommendationRunner rr = new RecommendationRunner();
        rr.printRecommendationsFor("71");

    }
}
