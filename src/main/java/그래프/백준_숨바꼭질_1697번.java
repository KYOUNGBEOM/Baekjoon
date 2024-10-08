package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 백준_숨바꼭질_1697번 {
	static List<Integer>[] list;
	static int[] visited;
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		if(N <= K) {
			list = new ArrayList[100001];
			visited = new int[100001];
			
			for(int i = 0; i <= 100000; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			list[N].add(N-1);
			list[N].add(N+1);
			list[N].add(N*2);

			BFS(N);

			System.out.println(visited[K]-1); 
		} else {
			System.out.println(N-K);
		}
	}

	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited[start]++;

		while(!queue.isEmpty()) {
			int current = queue.poll();

			for(int edge : list[current]) {

				if(0 <= edge && edge <= 100000) {
					if(visited[edge] == 0) {

						visited[edge] = visited[current] + 1;

						if(0 <= edge-1 && edge-1 <= 100000) { 
							list[edge].add(edge-1);
						}

						if(edge+1 <= 100000) { 	
							list[edge].add(edge+1);
						}

						if(edge*2 <= 100000) { 
							list[edge].add(edge*2);
						}

						queue.add(edge);
					}
				}
			}
		}
	}
}
