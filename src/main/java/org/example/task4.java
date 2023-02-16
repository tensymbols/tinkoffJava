package org.example;
import java.util.*;

public class task4 {
    public static void search(int[] adjList, int[] aList,
                              int[] lenList,int[] loadList){
        Queue<Integer> Q = new LinkedList<>();
        for(int i =1; i<adjList.length; i++){
            Q.add(i);
            int distance = 0;
            while(!Q.isEmpty()){

                int curr = Q.poll();
                if(curr==0) break;
                int neigh = adjList[curr];

                distance+=lenList[curr];
                if(distance<=aList[i]) loadList[neigh]+=1;
                Q.add(neigh);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] adjList=new int[n];
        int[] aList=new int[n];
        int[] lenList=new int[n];
        int[] loadList = new int[n];


        for (int i = 0; i < n; i++) {
            aList[i]=sc.nextInt();

        }
        adjList[0]=-1;
        for (int i = 1; i < n; i++) {
            adjList[i] =sc.nextInt()-1;
        }
        for (int i = 1; i < n; i++) {
            lenList[i]=sc.nextInt();
        }
        search(adjList,aList,lenList,loadList);
        for (int i = 0; i < loadList.length; i++) {
            System.out.print(loadList[i]+" ");
        }

    }
}
