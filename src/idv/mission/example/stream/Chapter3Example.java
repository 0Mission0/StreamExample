package idv.mission.example.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;

public class Chapter3Example {
    public static void main(String[] args) {
        List<Artist> artistList = SampleData.membersOfTheBeatles;
        long count = artistList.stream().filter(artist -> artist.isFrom("UK")).count();
        System.out.println("count = " + count);

        count = artistList.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("UK");
        }).count();

        Album album = SampleData.aLoveSupreme;

        Set<String> origins = album.getAllMusicians().filter(musician -> musician.getName().startsWith("The")).map(musician -> musician.getNationality()).collect(Collectors.toSet());
        System.out.println("origins = " + origins);

        findLongTracks();
    }

    public static Set<String> findLongTracks() {
        List<Album> albums = SampleData.albums.collect(Collectors.toList());
        Set<String> trackNames = new HashSet<String>();

        // Step 1
        // albums.stream().forEach(album -> {
        // album.getTracks().forEach(track -> {
        // int trackLength = track.getLength();
        // if (trackLength > 60) {
        // String trackName = track.getName();
        // trackNames.add(trackName);
        // }
        // });
        // });
        // return trackNames;

        // Step 2
        // albums.stream().forEach(album -> {
        // album.getTracks().filter(track -> track.getLength() > 60).map(track -> track.getName()).forEach(name -> trackNames.add(name));
        // });

        // Step 3
        trackNames = albums.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60).map(track -> track.getName()).collect(Collectors.toSet());

        System.out.println(trackNames);
        return trackNames;

    }
}
