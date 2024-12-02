package thro.fpk.song_metadata;

import java.util.HashMap;
import java.util.Map;
import thro.fpk.song_metadata.SongMetadata;

public class SongMetadataFactory {
    private Map<String, SongMetadata> metadataMap = new HashMap<>();

    public SongMetadata getMetadata(String artist, String album, String genre) {
       String key = artist + album + genre;
       if(!metadataMap.containsKey(key)) {
           metadataMap.put(key, new SongMetadata(artist, album, genre));
       }
       return metadataMap.get(key);
    }

}
