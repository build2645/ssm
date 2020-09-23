package com.how2java.tmall.test;

import com.how2java.tmall.pojo.Category;
/*
解释：
<insert id="add" keyProperty="id" useGeneratedKeys="true" >
 */
public class Test {

    @org.junit.Test
    public void controller() {
        Category category = new Category();
        service(category);
        System.out.println(category.getId());
    }


    public void service(Category category){
        mapper(category);
    }

    public void mapper(Category category){
        category.setId(100);
    }
}
