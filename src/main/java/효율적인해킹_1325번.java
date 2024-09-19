import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 효율적인해킹_1325번 {
	static ArrayList<Integer>[] com;
	static boolean[] visited;
	static int[] ans;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		com = new ArrayList[N+1];
		ans = new int[N+1];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i <= N; i++) {
			com[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			
			com[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}
		
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			BFS(i);	
		}
		
		for(int i = 1; i <= N; i++) {
			if(max == ans[i]) {
				System.out.print(i + " ");
			}
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int v : com[current]) {
				if(!visited[v]) {
					visited[v] = true;
					
					ans[start]++;
					max = Math.max(max, ans[start]);
					
					queue.add(v);
				}
			}
		}
	}
}
