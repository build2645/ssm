package com.how2java.tmall.test;


import java.util.Arrays;
import java.util.Scanner;

class PrintNum implements Runnable{
    int num = 1;

    @Override
    public void run() {
        synchronized(this){
            while(true){
                if (num <= 100){
                    notify();
                    System.out.println(Thread.currentThread().getName() + ": "+ num);
                    num++;
                }else {
                    notify();
                    break;
                }
                try {
                    wait();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ListNode{
    int value;
    ListNode next;
    public ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

public class TestTmall {

    public static void main(String args[]){
//        PrintNum p = new PrintNum();
//        Thread thread1 = new Thread(p);
//        Thread thread2 = new Thread(p);
//        thread1.setName("甲");
//        thread2.setName("乙");
//        thread1.start();
//        thread2.start();

        Scanner in = new Scanner(System.in);


        while (in.hasNext()){
            ListNode node = new ListNode(0,null);
            ListNode head = node;
            String str = in.nextLine();
            String[] strings = str.split(" ");
            System.out.println(Arrays.toString(strings));
            for (int i=0;i<strings.length;i++){
                node.next = new ListNode(Integer.parseInt(strings[i]),null);
                node = node.next;
            }

            ListNode res = jie(head.next);
            System.out.println(res.value);
        }





    }

    private static ListNode jie(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        int flag = 1;
        while(fast.next != null && (++flag)!= 0 && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            flag++;
        }
        if (flag%2 == 1)
            return slow;
        return slow.next;
    }

    private static Character jie(String str){
        char[] chars = new char[128];

        for(int i=0;i<str.length();i++){
            chars[str.charAt(i)]++;
        }
        int max1 = chars[str.charAt(0)];
        char flag1 = str.charAt(0);
        for (int i=1;i<str.length();i++){
            if(max1 < chars[str.charAt(i)]){
                flag1 = str.charAt(i);
                max1 = chars[str.charAt(i)];
            }
        }
        chars[flag1] = 0;
        int max2 = chars[str.charAt(0)];
        char flag2 = str.charAt(0);
        for (int i=1;i<str.length();i++){
            if(max2 < chars[str.charAt(i)]){
                flag2 = str.charAt(i);
                max2 = chars[str.charAt(i)];
            }
        }
        if (max1 == max2) return null;
        return flag2;
    }

}


