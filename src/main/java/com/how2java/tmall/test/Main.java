package com.how2java.tmall.test;

import java.util.*;
public class Main {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String input = in.next();
//            int i = 0, end = 0, j = 1;
//            while(j < input.length()){
//                while(j < input.length() && input.charAt(i) != input.charAt(j)){
//                    j++;
//                }
//                end = j;
//                while(j<input.length() && input.charAt(i) == input.charAt(j)){
//                    i++;
//                    j++;
//                    if (i == end){
//                        i = 0;
//                    }
//                }
//                if(j != input.length()){
//                    i = 0;
//                    j = end + 1;
//                }
//            }
//            String res = input.substring(0,end);
//            if(input.length() % res.length()==0)
//                System.out.println(res);
//            else
//                System.out.println(input);
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine().trim());
        while(in.hasNext()){
            if((N--)== 0){
                break;
            }
            String str = in.nextLine();
            String[] strings= str.split(" ");
            long res = 0;
            int yu = 1000000000 + 7;
            int a = Integer.parseInt(strings[0])%yu;
            int b = Integer.parseInt(strings[1])%yu;
            switch (strings[2]){
                case "+":
                    res = (a + b);
                    break;
                case  "-":
                    res = (a - b);
                    break;
                case  "*":
                    res = (a * b);
                    break;
                case  "^":
                    res = (long)Math.pow(a,b);
                    break;
                 default:
                     break;
            }
            System.out.println(res%yu);

        }
    }

}
