package CCB;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class networkDelayTime {
    static int INF = 0x3f3f3f3f;
    static int delayTime(int[][] G, int N) {
        int[] dis = new int[N + 1];
        boolean[] vis = new boolean[N + 1];
        for (int i = 0; i <= N; i++) dis[i] = G[1][i];
        for (int i = 0; i < N - 1; i++) {
            int Min = INF;
            int p = 1;
            for (int j = 1; j <= N; j++) {
                if (!vis[j] && dis[j] < Min) {
                    Min = dis[j];
                    p = j;
                }
            }
            vis[p] = true;
            for (int j = 1; j <= N; j++) {
                if (!vis[j] && dis[j] > dis[p] + G[p][j]) {
                    dis[j] = dis[p] + G[p][j];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dis[i]);
        }
        if (ans == INF) return -1;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] G = new int[num + 1][num + 1];
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                if (i == j) {
                    G[i][j] = 0;
                }else {
                    G[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < num - 1; i++) {
            String line = br.readLine();
            String[] temp = line.split(" ");
            for(int j = 0; j < temp.length; j++) {
                if (!temp[j].equals("x")) {
                    G[i + 2][j + 1] = Integer.parseInt(temp[j]);
                    G[j + 1][i + 2] = Integer.parseInt(temp[j]);
                }
            }
        }
        System.out.println(delayTime(G, num));


    }

}



