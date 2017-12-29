package idv.mission.example.stream;

import java.util.stream.Stream;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;

public class Chapter3Answer {
    public static void main(String[] args) {
        question1A();
        // question2();
    }

    public static void question1A() {
        Stream<Integer> numbers = Stream.of(1, 2, 3);
        int sum = addUp(numbers);
        System.out.println("sum = " + sum);
    }

    public static void question1B() {
        Stream<Artist> artists = SampleData.threeArtists();

    }

    private static int addUp(Stream<Integer> input) {
        int result = input.reduce(0, (tempSum, tempVar) -> tempSum + tempVar);
        return result;
    }

    public static void question2() {
        Stream<Artist> artists = SampleData.threeArtists();
        // int count = artists.map(artist -> artist.getMembers().count()).reduce(0L, (tempSum, element) -> tempSum + element).intValue();

        int count = (int) artists.flatMap(artist -> artist.getMembers()).count();
        System.out.println("count = " + count);
    }
}
