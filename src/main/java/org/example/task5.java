package org.example;
import java.util.Arrays;
import java.util.Scanner;
public class task5 {
    public static int[] makeDivisible(int[] arr, int begin){
        int[] tempArr = new int[arr.length-begin];
        int divisor = arr[begin-1];
        for (int i = 0; i < tempArr.length ; i++) {
            tempArr[i] = (arr[i+begin]/divisor) * divisor;

        }
        return tempArr;
    }
    public static int count(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++)
            sum+=arr[i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] freqs = new int[n];
        for (int i = 0; i < n; i++) {
            freqs[i]=sc.nextInt();
        }

        Arrays.sort(freqs);
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int curr = freqs[i];
            int[] tArr = makeDivisible(freqs,i+1);
            int currSum = count(tArr)+curr;
            if(currSum >maxSum){
                maxSum=currSum;
            }

        }
        System.out.println(maxSum);
    }
}
