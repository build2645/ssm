package com.how2java.tmall.test;

import java.util.TreeMap;

class SortedTest implements Comparable<SortedTest> {

    private  String name;

    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedTest(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //自定义对象，实现compareTo(T o)方法：
    public int compareTo(SortedTest sortedTest) {
        int num = this.age - sortedTest.getAge();
        //为0时候，两者相同：
        if(num==0){
            return 0;
            //大于0时，传入的参数小：
        }else if(num>0){
            return 1;
            //小于0时，传入的参数大：
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "SortedTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TreeMapTest {
    public static void main(String[] agrs){
        //自然顺序比较
        naturalSort();
    }
    //自然排序顺序：
    public static void naturalSort(){
        //第一种情况：Integer对象
        TreeMap<Integer,String> treeMapFirst = new TreeMap<Integer, String>();
        treeMapFirst.put(1,"jiaboyan");
        treeMapFirst.put(6,"jiaboyan");
        treeMapFirst.put(3,"jiaboyan");
        treeMapFirst.put(10,"jiaboyan");
        treeMapFirst.put(7,"jiaboyan");
        treeMapFirst.put(13,"jiaboyan");
        System.out.println(treeMapFirst.toString());

        //第二种情况:SortedTest对象
        TreeMap<SortedTest,String> treeMapSecond = new TreeMap<SortedTest, String>();
        treeMapSecond.put(new SortedTest("a",10),"jiaboyan");
        treeMapSecond.put(new SortedTest("b",1),"jiaboyan");
        treeMapSecond.put(new SortedTest("z",13),"jiaboyan");
        treeMapSecond.put(new SortedTest("x",4),"jiaboyan");
        treeMapSecond.put(new SortedTest("d",0),"jiaboyan");
        treeMapSecond.put(new SortedTest("c",9),"jiaboyan");
        System.out.println(treeMapSecond.toString());
    }
}