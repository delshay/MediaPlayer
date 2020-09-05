import mediatype.Media;
import mediatype.Movie;
import mediatype.Playlist;
import mediatype.Song;

import static playmode.PlayMode.*;

public class Main {

    public static void main(String[] args) {
        Media movie1 = new Movie("X-MEN");
        Media movie2 = new Movie("Śmierć w Wenecji");
        Media song1 = new Song("Wszytsko jedno", "Taco Hemingway");
        Playlist playlist = new Playlist();
        playlist.add(song1);
        playlist.add(movie1);
        playlist.add(movie2);

        Media movie3 = new Movie("Listy do M cz. 5");
        Media song2 = new Song("Twój ból jest lepszy niż mój", "Kazik");
        Media movie4 = new Movie("Scary movie 5");
        Playlist playlist2 = new Playlist();
        playlist2.add(movie3);
        playlist2.add(movie4);
        playlist2.add(song2);
        playlist2.setPlayMode(NORMAL);

        playlist.add(playlist2);

        playlist.setPlayMode(SHUFFLE);
        Media song3 = new Song("Koniec", "Elektryczne Gitary");
        playlist.add(song3);
        playlist.play();
    }
}