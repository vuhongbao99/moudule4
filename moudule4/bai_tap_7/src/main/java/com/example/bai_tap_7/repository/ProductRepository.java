package com.example.bai_tap_7.repository;

import com.example.bai_tap_7.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"Nuoc Hoa Minh Beo",300000d,"Dung la suong","MinhBeo"));
        products.add(new Product(2,"Keo Dua",200000d,"An Ngon","Ben Tre"));
        products.add(new Product(3,"Banh Trang",140000d,"Bo duong","Sai Gon"));
    }


    public  List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        Integer id = products.get(products.size() - 1).getId() + 1;
        product.setId(id);
        products.add(product);
    }


    public Product findById(Integer id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Không tìm thấy
    }

    public void delete(int id) {
        Product toRemove = null;
        for (Product p : products) {
            if (p.getId() == id) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            products.remove(toRemove);
        }
    }

    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product); // Ghi đè sản phẩm mới lên
                break;
            }
        }
    }

}
