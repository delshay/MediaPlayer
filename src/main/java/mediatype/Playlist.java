package mediatype;

import playmode.PlayMode;
import java.util.LinkedList;
import java.util.Random;

public class Playlist {

    private LinkedList<Object> playlist = new LinkedList<>();
    private PlayMode playMode = PlayMode.NORMAL;

    public void add(Object media) {
        this.playlist.add(media);
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public void play() {
        switch (playMode) {
            case NORMAL -> {
                for (int i = 0; i < playlist.size(); i++) {
                    if (playlist.get(i) instanceof Song) {
                        ((Song) playlist.get(i)).play();
                    }
                    if (playlist.get(i) instanceof Movie) {
                        ((Movie) playlist.get(i)).play();
                    }
                    if (playlist.get(i) instanceof Playlist) {
                        ((Playlist) playlist.get(i)).play();
                    }
                }
            }
            case SHUFFLE -> {
                LinkedList<Object> shufflePlaylist = playlist;
                int trackNumber = getRnFromRange(shufflePlaylist.size() - 1);
                while (shufflePlaylist.size() > 0) {
                    if (shufflePlaylist.get(trackNumber) instanceof Song) {
                        ((Song) shufflePlaylist.get(trackNumber)).play();
                    }
                    if (shufflePlaylist.get(trackNumber) instanceof Movie) {
                        ((Movie) shufflePlaylist.get(trackNumber)).play();
                    }
                    if (shufflePlaylist.get(trackNumber) instanceof Playlist) {
                        ((Playlist) shufflePlaylist.get(trackNumber)).play();
                    }
                    shufflePlaylist.remove(trackNumber);
                    if (trackNumber > 0) {
                        trackNumber = getRnFromRange(shufflePlaylist.size() - 1);
                    }
                }
            }
            case REPEAT_ALL -> {
                for (int repeat = 0; repeat < 5; repeat++) {
                    for (int i = 0; i < playlist.size(); i++) {
                        if (playlist.get(i) instanceof Song) {
                            ((Song) playlist.get(i)).play();
                        }
                        if (playlist.get(i) instanceof Movie) {
                            ((Movie) playlist.get(i)).play();
                        }
                        if (playlist.get(i) instanceof Playlist) {
                            ((Playlist) playlist.get(i)).play();
                        }
                    }
                }
            }
        }
    }

    private static int getRnFromRange(int maxValue) {
        Random rand = new Random();
        return rand.nextInt((maxValue + 1));
    }
}