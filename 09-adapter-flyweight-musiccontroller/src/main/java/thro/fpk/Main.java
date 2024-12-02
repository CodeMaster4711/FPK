package thro.fpk;

// since we really need all imports wildcard is okay
import thro.fpk.external_song.*;
import thro.fpk.song.*;
import thro.fpk.song_metadata.*;

public class Main {
    public static void main(String[] args) {
        SongMetadataFactory metadataFactory = new SongMetadataFactory();

        // Create users
        User premiumUser = new User("PetePremium", true);
        User freeUser = new User("FreddyFree", false);

        // Create shared metadata
        SongMetadata LateralusMetadata = metadataFactory.getMetadata("Tool", "Lateralus", "Progressive Metal");
        SongMetadata SunriseOnSlaughterBeach = metadataFactory.getMetadata("Clutch", "Sunrise on Slaughter Beach", "Stoner Rock");


        // Create songs
        PremiumSong lateralus = new PremiumSong("Lateralus", LateralusMetadata);
        PremiumSong parabol = new PremiumSong("Parabol", LateralusMetadata);
        PremiumSong theGrudge = new PremiumSong("The Grudge", LateralusMetadata);
        StandardSong thePatient = new StandardSong("The Patient", LateralusMetadata);
        StandardSong schism = new StandardSong("Schism", LateralusMetadata);
        PremiumSong ticksAndLeeches = new PremiumSong("Ticks and Leeches", LateralusMetadata);

        PremiumSong slaughterBeach = new PremiumSong("Slaughter Beach", SunriseOnSlaughterBeach);
        StandardSong skeletonsOnMars = new StandardSong("Skeletons on Mars", SunriseOnSlaughterBeach);
        StandardSong nosferatuMadre = new StandardSong("Nosferatu Madre", SunriseOnSlaughterBeach);
        PremiumSong mercyBrown = new PremiumSong("Mercy Brown", SunriseOnSlaughterBeach);

        // Create external song
        ExternalSong externalSong = new ExternalSong("The Trooper", "Iron Maiden", "EMI");

        // Create external song adapter
        ExternalSongAdapter externalSongAdapter = new ExternalSongAdapter(externalSong);


        // Play songs
        freeUser.playSong(lateralus);

        freeUser.playSong(schism);

        premiumUser.playSong(theGrudge);

        premiumUser.playSong(externalSongAdapter);


    }

}