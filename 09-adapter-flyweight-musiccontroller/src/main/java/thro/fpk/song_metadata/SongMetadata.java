package thro.fpk.song_metadata;

public class SongMetadata {
    private String artist;
    private String album;
    private String genre;

    public SongMetadata(String artist, String album, String genre) {
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }
}
