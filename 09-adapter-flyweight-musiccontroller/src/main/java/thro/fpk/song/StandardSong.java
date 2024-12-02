package thro.fpk.song;


import thro.fpk.song_metadata.SongMetadata;

public class StandardSong implements Song {
    private String title;
    private SongMetadata metadata;

    public StandardSong(String title, SongMetadata metadata) {
        this.title = title;
        this.metadata = metadata;
    }

    @Override
    public void play() {
        System.out.println("Playing standard song: " + title);
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
