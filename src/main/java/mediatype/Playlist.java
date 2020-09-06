package mediatype;

import playmode.PlayMode;
import java.util.Collections;
import java.util.LinkedList;

public class Playlist implements Playable {

    private final int MAX_REPEAT_LOOPS = 10;

    private LinkedList<Playable> playlist = new LinkedList<>();
    private PlayMode playMode;

    public Playlist(PlayMode playMode) {
        this.playMode = playMode;
    }

    public void add(Playable media) {
        this.playlist.add(media);
    }

    public void setPlaymode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public void play() {
        switch (this.playMode) {
            case NORMAL -> {
                this.playlist.stream()
                        .forEach(Playable::play);
            }
            case SHUFFLE -> {
                LinkedList<Playable> shufflePlaylist = new LinkedList<>(this.playlist);
                Collections.shuffle(shufflePlaylist);
                shufflePlaylist.stream()
                        .forEach(Playable::play);
            }
            case REPEAT_ALL -> {
                for (int i = 0; i < MAX_REPEAT_LOOPS; i++) {
                    this.playlist.stream()
                            .forEach(Playable::play);
                }
            }
        }
    }
}