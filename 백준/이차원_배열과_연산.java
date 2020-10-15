package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 이차원_배열과_연산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t <= 100; t++) {
			if (r < arr.length && c < arr[0].length && arr[r][c] == k) {
				System.out.println(t);
				return;
			}
			int min = Math.min(arr.length, arr[0].length);
			int max = Math.max(arr.length, arr[0].length);
			int len = 0;
			ArrayList<Integer>[] list = new ArrayList[max];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < max; i++) {
				Map<Integer, Integer> map = new LinkedHashMap<>();
				for (int j = 0; j < min; j++) {
					if (arr.length >= arr[0].length) {
						if (arr[i][j] == 0)
							continue;
						if (map.get(arr[i][j]) == null)
							map.put(arr[i][j], 0);
						map.put(arr[i][j], map.get(arr[i][j]) + 1);
					} else {
						if (arr[j][i] == 0)
							continue;
						if (map.get(arr[j][i]) == null)
							map.put(arr[j][i], 0);
						map.put(arr[j][i], map.get(arr[j][i]) + 1);
					}
				}
				List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
				Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						if (o1.getValue() == o2.getValue())
							return o1.getKey() - o2.getKey();
						return o1.getValue() - o2.getValue();
					}
				});
				Iterator<Entry<Integer, Integer>> iter = entries.iterator();
				int cnt = 0;
				while (iter.hasNext()) {
					Entry<Integer, Integer> next = iter.next();
					int key = next.getKey();
					int value = next.getValue();
					list[i].add(key);
					list[i].add(value);
					cnt++;
				}
				len = Math.max(cnt * 2, len);
			}
			if (arr.length >= arr[0].length) {
				arr = new int[max][len];
				for (int i = 0; i < list.length; i++) {
					for (int j = 0; j < list[i].size(); j++) {
						arr[i][j] = list[i].get(j);
					}
				}
			} else {
				arr = new int[len][max];
				for (int i = 0; i < list.length; i++) {
					for (int j = 0; j < list[i].size(); j++) {
						arr[j][i] = list[i].get(j);
					}
				}
			}
		}
		System.out.println(-1);
	}

}
