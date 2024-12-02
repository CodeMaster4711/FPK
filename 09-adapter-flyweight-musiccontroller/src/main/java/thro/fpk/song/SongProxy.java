package thro.fpk.song;

import thro.fpk.User;

public class SongProxy implements Song {
    private Song song;
    private User user;

    public SongProxy(Song song, User user) {
        this.song = song;
        this.user = user;
    }

    @Override
    public void play() {
        if(song.isPremium() && !user.isPremium()) {
            System.out.println("You need to be a premium user to play this song.");
        } else {
            song.play();
        }
    }

    @Override
    public boolean isPremium() {
        return song.isPremium();
    }
}
