package thro.fpk.external_song;

public class ExternalSong {
    private String trackName;
    private String musucian;
    private String recordLabel;

    public ExternalSong(String trackName, String musucian, String recordLabel) {
        this.trackName = trackName;
        this.musucian = musucian;
        this.recordLabel = recordLabel;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getMusucian() {
        return musucian;
    }

    public String getRecordLabel() {
        return recordLabel;
    }
}
