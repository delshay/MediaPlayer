package mediatype;

public class Song implements Media {

    private String artist;
    private String title;

    public Song(String title, String artist) {
        this.title = artist;
        this.artist = title;
    }

    public void play() {
        System.out.println(this.title + ", " + this.artist);
    }
}