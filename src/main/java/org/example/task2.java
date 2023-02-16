package org.example;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int minv = Integer.MIN_VALUE;
        int maxv = Integer.MAX_VALUE;
        int prevMin=Integer.MIN_VALUE;
        int prevMax=Integer.MAX_VALUE;
        sc.nextInt();

        int prevSign=( sc.next().equals("0+")) ? 1 :-1;

        for (int i = 1; i < n; i++) {
            int change = sc.nextInt();
            int sign = ( sc.next().equals("0+")) ? 1 :-1;

            if(sign+prevSign==0) {
                if(prevSign==-1){
                    prevMin=0-change;
                    prevMax=-1;
                }
                if(prevSign==1){
                    prevMin=0;
                    prevMax=(-change)-1;
                }
            }
            minv=prevMin+change;
            maxv=prevMax+change;
            prevSign=sign;
            prevMin=minv;
            prevMax=maxv;
        }
        if(maxv==Integer.MAX_VALUE) System.out.println("inf");
        else
        System.out.println(maxv);
    }
}
