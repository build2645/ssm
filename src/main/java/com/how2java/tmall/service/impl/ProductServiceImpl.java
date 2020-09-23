package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductExample;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
    @Override
    public List<Product> list(int cid) {
            ProductExample example = new ProductExample();
            example.createCriteria().andCidEqualTo(cid);
            example.setOrderByClause("id desc");

            List<Product> ps = productMapper.selectByExample(example);
            setCategory(ps);
            setFirstProductImage(ps);
            return ps;

    }

    @Override
    public void add(Product p) {
        productMapper.insertSelective(p);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Product get(int id) {
        Product product = productMapper.selectByPrimaryKey(id);
        setFirstProductImage(product);
        setCategory(product);
        return product;
    }

    private void setCategory(Product p){
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
    }

    private void setCategory(List<Product> ps){
        for(Product p:ps){
            setCategory(p);
        }
    }
    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }

    //为单个产品设置图片
    @Override
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
        if(!pis.isEmpty()){
            ProductImage pi = pis.get(0);
            p.setFirstProductImage(pi);
        }
    }

    @Override
    public void fill(List<Category> categorys) {
        for (Category c:categorys) {
            fill(c);
        }
    }

    @Override
    public void fill(Category category) {
        List<Product> ps = list(category.getId());
        category.setProducts(ps);
    }

    @Override
    public void fillByRow(List<Category> categorys) {
        int productNumberEachRow = 8;
        for (Category c : categorys){
            List<Product> products = c.getProducts();
            List<List<Product>> productsByRow = new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }

    @Override
    public void setSaleAndReviewNumber(Product p) {
        int saleCount = orderItemService.getSaleCount(p.getId());
        p.setSaleCount(saleCount);
        int reviewCount = reviewService.getCount(p.getId());
        p.setReviewCount(reviewCount);
    }

    @Override
    public void setSaleAndReviewNumber(List<Product> ps) {
        for (Product p:ps){
            setSaleAndReviewNumber(p);
        }
    }

    @Override
    public List<Product> search(String keyword) {
        ProductExample example = new ProductExample();
        example.createCriteria().andNameLike("%" + keyword + "%");
        example.setOrderByClause("id desc");
        List<Product> products = productMapper.selectByExample(example);
        setFirstProductImage(products);
        setCategory(products);
        return products;
    }

    public void setFirstProductImage(List<Product> ps){
        for (Product p:ps){
            setFirstProductImage(p);
        }
    }
}
