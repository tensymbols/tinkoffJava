package org.example;
import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.util.Scanner;

public class task1 {
    public static int countDistinct(String s, int[] digitq){
        int cnt=0;

        for (int i =0; i<10; i++){
            if(s.charAt(i)=='?') {
                cnt++;
                continue;
            }
            int currDigit = Character.getNumericValue(s.charAt(i));
            if(currDigit>9 || currDigit<0) return -1;

            if(digitq[currDigit]==0) cnt++;
            digitq[currDigit]++;

        }
        return cnt;
    }
    public static void main(String[] args)  {
        InputStream is = new ByteArrayInputStream(new String("0?2?4?6\n" +
                "?802?").getBytes());

        Scanner sc = new Scanner(is);

        StringBuilder stream = new StringBuilder("");
        while (sc.hasNext()){
            stream.append(sc.next());
        }
        String s = stream.toString();

        if(s.length() <10) {
            System.out.println("NO");
            return;
        }
        int[] digitq = new int[10];
        int currDistinctQuantity =  countDistinct(s, digitq);

        if(currDistinctQuantity ==-1) {
            System.out.println("NO");
            return;
        }
        int maxDistinct=currDistinctQuantity;
        for(int i = 10; i< s.length();i++){
            int leftDigit = Character.getNumericValue(s.charAt(i - 10));
            int rightDigit = Character.getNumericValue(s.charAt(i));
            if(s.charAt(i-10)=='?') currDistinctQuantity--;
            else {
                if (leftDigit > 9 || leftDigit < 0) {
                    System.out.println("NO");
                    return;
                }
                digitq[leftDigit]--;
                if(digitq[leftDigit]==0) currDistinctQuantity--;
            }
            if(s.charAt(i)=='?') currDistinctQuantity++;
            else
            {
                if ( rightDigit > 9 || rightDigit <0) {
                    System.out.println("NO");
                    return;
                }
                if(digitq[rightDigit]==0) currDistinctQuantity++;
                digitq[rightDigit]++;
            }
            if(currDistinctQuantity>maxDistinct) maxDistinct = currDistinctQuantity;
        }
        if(maxDistinct==10)
            System.out.println("YES");
        else{
            System.out.println("NO");
        }
    }
}