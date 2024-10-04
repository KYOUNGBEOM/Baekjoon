package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 알고리즘수업_병합정렬1_24060번 {
	static List<Integer> ans;
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		int[] arr = new int[N];
		ans = new ArrayList<Integer>();
		
		input = br.readLine().split(" ");

		for(int i = 0; i < input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		merge_sort(arr, 0, arr.length-1);
		
		if(ans.size() < K) {
			System.out.println(-1);
		} else {
			System.out.println(ans.get(K-1));
		}
	}
	
	static void merge_sort(int[] arr, int p, int r) {
		if(p < r && ans.size() < K) {
			int q = (p+r) / 2;
			merge_sort(arr, p, q);
			merge_sort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		
		int i = p;
		int j = q+1;
		int t = 0;
		
		int[] tmp = new int[r+1];
		
		while(i <= q && j <= r) {
			if(arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		
		while(i <= q) {
			tmp[t++] = arr[i++];
		}
		
		while(j <= r) {
			tmp[t++] = arr[j++];
		}
		
		i = p;
		t = 0;
		
		while(i <= r) {
			arr[i++] = tmp[t++];
			ans.add(arr[i-1]);
			if(ans.size() == K) {
				return;
			}
		}
	}
}
