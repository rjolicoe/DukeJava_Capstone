public class GenreFilter implements Filter{

    private String myGenre;

    public GenreFilter(String myGenre) {
        this.myGenre = myGenre;
    }

    @Override
    public boolean satisfies(String id) {

        return MovieDatabase.getGenres(id).contains(myGenre);
    }
}
