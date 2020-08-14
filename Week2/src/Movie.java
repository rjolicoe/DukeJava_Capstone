public class Movie {

    private String id;
    private String title;
    private int year;
    private String genres;
    private String director;
    private String country;
    private int minutes;
    private String poster;

    public Movie(String anID, String aTitle, String aYear, String theGenres, String theDirectors,
                 String aCountry, int theMinutes, String aPoster){
        // just in case data file contains extra whitespace
        id = anID.trim();
        title = aTitle.trim();
        year = Integer.parseInt(aYear.trim());
        genres = theGenres;
        director = theDirectors;
        country = aCountry;
        minutes = theMinutes;
        poster = aPoster;
    }

    public String getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenres() {
        return genres;
    }

    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getPoster() {
        return poster;
    }

    public String toString(){
        String result = "Movie [id= " + id + ", title= " + title + ", year" + year;
        result  += ", genres= " + genres + "]";
        return result;
    }
}
