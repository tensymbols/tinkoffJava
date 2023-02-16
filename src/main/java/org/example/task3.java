package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i =0; i<adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        int telescopeModes[] = new int[n];
        boolean[] visited = new boolean[adjList.length];

        for(int i=0; i<n; i++){
            telescopeModes[i]=sc.nextInt();
        }
        for(int i =0;i<m;i++){
            int from = sc.nextInt()-1;

            int to = sc.nextInt()-1;
            adjList[from].add(to);
            adjList[to].add(from);
        }
        int switchesCnt=0;
        for (int i = 0; i<n;i++){
            if(!visited[i]) switchesCnt+= bfs(i, adjList, telescopeModes,visited, k);
        }
        System.out.println(switchesCnt);
    }
    private static int bfs(int start, ArrayList<Integer>[] adjList, int telescopeModes[], boolean[] visited, int k ) {

        int[] modesQ = new int[k+1];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visited[start]=true;
        modesQ[telescopeModes[start]] += 1;
        while(!Q.isEmpty()){
            int curr = Q.poll();
            for(int i=0; i<adjList[curr].size();i++){
                int neighbour = adjList[curr].get(i);
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    Q.add(neighbour);
                    modesQ[telescopeModes[neighbour]] += 1;
                }
            }
        }
        int mostPopularQuantity = 0;
        int mostPopularIndex= 0;
        for(int i =1; i<k+1; i++){
            if(modesQ[i]>mostPopularQuantity){
                mostPopularIndex=i;
                mostPopularQuantity=modesQ[i];
            }
        }
        int switchesCnt = 0;
        Q.add(start);
        for(int i = 0;i<visited.length;i++){
            visited[i]=false;
        }

        //второй обход
        visited[start]=true;
        if(telescopeModes[start]!=mostPopularIndex) switchesCnt++;
        while(!Q.isEmpty()){
            int curr = Q.poll();

            for(int i=0; i<adjList[curr].size();i++){
                int neighbour = adjList[curr].get(i);

                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    Q.add(neighbour);
                    if(telescopeModes[neighbour]!=mostPopularIndex) switchesCnt++;

                }
            }
        }
        return switchesCnt;
    }
}