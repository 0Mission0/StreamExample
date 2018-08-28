package idv.mission.example.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayAndJoinExample {
	public static void main(String[] args) {
		String[] strArray = {"1", "2", "3"};
        String result = Stream.of(strArray).map(str -> "'" + str + "'").collect(Collectors.joining(", "));
        System.out.println("result = " + result);
	}
}
