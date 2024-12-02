package thro.fpk.external_song;

import thro.fpk.external_song.ExternalSong;
import thro.fpk.song.Song;

public class ExternalSongAdapter implements Song {
    private ExternalSong externalSong;

    public ExternalSongAdapter(ExternalSong externalSong) {
        this.externalSong = externalSong;
    }

    @Override
    public void play() {
        System.out.println("Playing external song: " + externalSong.getTrackName());
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
