import mediatype.Movie;
import mediatype.Playlist;
import mediatype.Song;
import org.junit.Test;

import static playmode.PlayMode.*;

public class MediaPlayerTestCases {

    @Test
    public void shouldPlaySequentially() {
        Playlist playlist = new Playlist(NORMAL);;
        playlist.add(new Movie("X-MEN"));
        playlist.add(new Song("Wszytsko jedno", "Taco Hemingway"));

        Playlist subPlaylist = new Playlist(NORMAL);
        subPlaylist.add(new Movie("Listy do M cz. 5"));
        subPlaylist.add(new Song("Twój ból jest lepszy niż mój", "Kazik"));

        playlist.add(subPlaylist);
        playlist.play();
    }

    @Test
    public void shouldPlaySubPlaylistShuffle() {
        Playlist playlist = new Playlist(NORMAL);;
        playlist.add(new Movie("X-MEN"));
        playlist.add(new Song("Wszytsko jedno", "Taco Hemingway"));

        Playlist subPlaylist = new Playlist(SHUFFLE);
        subPlaylist.add(new Movie("Listy do M cz. 5"));
        subPlaylist.add(new Song("Twój ból jest lepszy niż mój", "Kazik"));
        subPlaylist.add(new Movie("Śmierć w wenecji"));

        playlist.add(subPlaylist);
        playlist.play();
    }

    @Test
    public void shouldPlaySubplaylistWithSubplaylistsShuffle() {
        Playlist playlist = new Playlist(NORMAL);;
        playlist.add(new Movie("X-MEN"));
        playlist.add(new Song("Wszytsko jedno", "Taco Hemingway"));

        Playlist subPlaylist = new Playlist(SHUFFLE);
        subPlaylist.add(new Movie("Listy do M cz. 5"));
        subPlaylist.add(new Song("Twój ból jest lepszy niż mój", "Kazik"));
        subPlaylist.add(new Movie("Śmierć w wenecji"));

        playlist.add(subPlaylist);
        playlist.add(subPlaylist);
        playlist.play();
        playlist.play();
    }

    @Test
    public void shouldRepeatPlaylistMaxTimes() {
        Playlist playlist = new Playlist(REPEAT_ALL);;
        playlist.add(new Movie("X-MEN"));

        playlist.play();
    }
}
