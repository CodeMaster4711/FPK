package thro.fpk;

import thro.fpk.song.Song;
import thro.fpk.song.SongProxy;

public class User {
    private String name;
    private Boolean isPremium;

    public User(String name, Boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public String getName() {
        return name;
    }

    public void playSong(Song song) {
        SongProxy proxy = new SongProxy(song, this);
        proxy.play();
    }
}
