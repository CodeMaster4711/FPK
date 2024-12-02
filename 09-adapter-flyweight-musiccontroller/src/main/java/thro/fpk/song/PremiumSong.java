package thro.fpk.song;

import thro.fpk.song_metadata.SongMetadata;

public class PremiumSong implements Song {
    private String title;
    private SongMetadata metadata;

    public PremiumSong(String title, SongMetadata metadata) {
        this.title = title;
        this.metadata = metadata;
    }

    @Override
    public void play() {
        System.out.println("Playing high quality song: " + title);
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
