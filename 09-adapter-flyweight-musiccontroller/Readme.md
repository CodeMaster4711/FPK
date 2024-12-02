# Design Patterns - adapter, proxy, flyweight

## Scenario
You're building a Java-based Music Streaming Service. This service allows users to play songs, but there are challenges to address, requiring the use of design patterns. 

## Requirements

### Proxy Pattern: Premium User Access
Only premium users can play high-quality music. Implement a proxy to restrict access to high-quality streaming for free users.

Tasks:
- Create a ``Song`` interface with a ``play()`` method, and a way of checking if the Song is a premium song.
- Implement two classes:
  - ``HighQualitySong``: Implements Song and simulates playing high-quality audio, accessible only to premium users.
  - ``StandardSong``: Implements Song and simulates playing standard audio, accessible to all users.
- ``SongProxy``: Wraps a Song. It checks user access before allowing playback, give users an instance of this class, users call play on their own proxy instance, which will check access and play the song
- Add a ``User`` class with attributes like ``isPremium`` to determine access level.

Hint: simulation is already fine as a simple print statement.

### Adapter Pattern: Third-Party Music Library

The service needs to integrate with a third-party music library API. However, the API returns song data in a different format. Write an adapter to convert the API data into your application's format.

Tasks:
- Assume you have a third-party library (ThirdPartyMusicAPI) that provides song details in the format:

```` java
class ExternalSong {
String trackName;
String musician;
String recordLabel;
// Getters and setters...
}
````

- Write an adapter ``(ExternalSongAdapter)`` to map this format to your internal ``Song`` class with attributes  title, artist, and album.
- Note: you can't provide what you don't have, which is fine. Also, you don't need to use external data that our Songs don't have. Find a solution.

### Flyweight Pattern: Song Metadata

Many songs share metadata like artist name, album title, or genre. Implement a flyweight pattern to minimize memory usage for this shared data.



Tasks:
- Implement a SongMetadata flyweight class to store shared song attributes: artist, album, and genre.
- Modify the Song implementation to use a SongMetadataFactory, which ensures shared instances of metadata are reused.


### Testing
- the main class is there, to guide you in your development, but before we release our product, you need to at least write unit tests
- Good tests are not only testing the happy path but also the edge cases. What are our edge cases?

### Simulation
- Feel free to write your own main, but you can use the provided one:
  - Simulate a small "DB" , (see Main), containing at least 10 songs.
    - At least 5 songs are from the same artist.
    - Good songs will provide bonus points :)
  - Create at least one song that simulates the third-party library.
  - Create a few users, some premium, some not.
  - Demonstrate:
    - Access control for premium songs.
    - Integration with the third-party library. (Integration of songs with different format)
    - Create a lot of songs with the same metadata and show that memory usage is minimized. (at least show the theory)