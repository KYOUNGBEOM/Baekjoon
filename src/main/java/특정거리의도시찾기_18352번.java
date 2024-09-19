import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 특정거리의도시찾기_18352번 {
	static ArrayList<Integer>[] city;
	static boolean[] visited;
	static int[] distance;
	static List<Integer> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		int X = Integer.parseInt(input[3]);
		
		city = new ArrayList[N+1];
		visited = new boolean[N+1];
		distance = new int[N+1];
		ans = new ArrayList<>();

		for(int i = 0; i <= N; i++) {
			city[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			city[start].add(end);
		}
		
		BFS(X, K);
		
		if(ans.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(ans);
			for(int i : ans) {
				System.out.println(i);
			}
		}
	}
	
	static void BFS(int X, int K) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(X);
		visited[X] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int v : city[current]) {
				if(!visited[v]) {
					visited[v] = true;
					
					distance[v] = distance[current] + 1;
					
					if(distance[v] == K) {
						ans.add(v);
					}
					
					queue.add(v);
				}
			}
		}
		
	}
}