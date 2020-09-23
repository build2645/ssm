package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> list(int cid);

    void add(Product p);

    void delete(int id);

    Product get(int id);

    void update(Product p);

    void setFirstProductImage(Product p);

    void fill(List<Category> categorys);
    void fill(Category category);
    void fillByRow(List<Category> categorys);


    void setSaleAndReviewNumber(Product p);
    void setSaleAndReviewNumber(List<Product> ps);

    List<Product> search(String keyword);
}
