package idv.mission.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {
	public static void main(String[] args) {
		List<String> result = new ArrayList<String>();
		result.add("1");
		result.add("2");
		result.add("2");
		result.add("2");
		result.add("3");
        result = result.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
	}
}
