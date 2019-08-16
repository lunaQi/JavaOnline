package CCB;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class networkDelayTime {
    static int delayTime(int[][] times, int N, int K) {
        int[][] G = new int[N+ 1][N + 1];
        int INF = 0x3f3f3f;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    G[i][j] = 0;
                }else {
                    G[i][j] = INF;
                }

            }
        }
        for (int i = 0; i < times.length; i++) {
            G[times[i][0]][times[i][1]] = times[i][2];
        }
        int[] dis = new int[N + 1];
        boolean[] vis = new boolean[N + 1];
        for (int i = 0; i <= N; i++) dis[i] = G[K][i];
        for (int i = 0; i < N - 1; i++) {
            int Min = INF;
            int p = K;
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
        String[] str = new String[num];
        int[][] times = new int[][3];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            str[i] = br.readLine();
            String[] temp = str[i].split(" ");
            List<Integer> all = new ArrayList<>();

            for(int j = 0; j < temp.length; j++) {
                if (!temp[j].equals("x"))
                    all.add(num + 2, )

            }
        }


    }
}


