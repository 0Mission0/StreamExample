package idv.mission.example.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctExample {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "2");
		map.put("4", "2");
		map.put("5", "3");
		
        List<String> result = map.values().stream().distinct().collect(Collectors.toList());
        System.out.println(result);
	}
}
