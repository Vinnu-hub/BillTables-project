package com.example.SpringBoot_Table_task.service;

import com.example.SpringBoot_Table_task.dto.Dto;
import com.example.SpringBoot_Table_task.entity.Product;
import com.example.SpringBoot_Table_task.entity.Sale;
import com.example.SpringBoot_Table_task.entity.Store;
import com.example.SpringBoot_Table_task.repository.ProductRepository;
import com.example.SpringBoot_Table_task.repository.SaleRepository;
import com.example.SpringBoot_Table_task.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogicService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private StoreRepository storeRepository;

//    public List<Dto> getoutput(String name) {
//        List<Dto> list = new ArrayList<>();
//
//        Store store = storeRepository.findByName(name); // storing the name
//        List<Product> products = productRepository.findAll(); // iterating all
//        List<Sale> sales = saleRepository.findByStore(store); // iterating and filtering the record with matching store
//
//        for (Product product : products) {
//            Long quantity = 0L;
//            boolean flag = false;
//            for (Sale sale : sales) {
//                if (product.getP_id().equals(sale.getProduct().getP_id())) {
//                    quantity += sale.getSale_quantity();
//                    flag = true;
//                }
//            }
//            if (flag) {
//                Dto dto = new Dto();
//                dto.setProduct_name(product.getName());
//                dto.setSale(quantity);
//                dto.setMrp(product.getMrp());
//                dto.setAmount(quantity * product.getMrp());
//                list.add(dto);
//            }
//        }
//        return list;
//    }

    public List<Dto> getoutput(String name) {
        List<Dto> list = new ArrayList<>();

        // Fetch the store by name
        Store store = storeRepository.findByName(name);

        // Fetch all products and sales associated with the store
        List<Product> products = productRepository.findAll();
        List<Sale> sales = saleRepository.findByStore(store);

        // Create a map to store total quantities sold per product ID
        Map<Long, Long> productSalesMap = new HashMap<>();

        // Populate the map with quantities from sales
        for (Sale sale : sales) {
            Long productId = sale.getProduct().getP_id();
            Long quantity = sale.getSale_quantity();

            // If the product ID already exists in the map, increment the quantity
            productSalesMap.put(productId, productSalesMap.getOrDefault(productId, 0L) + quantity);
        }

        // Iterate over products to create Dto objects for those with sales
        for (Product product : products) {
            Long totalQuantity = productSalesMap.get(product.getP_id());

            // Only create a Dto if there were sales for this product
            if (totalQuantity != null && totalQuantity > 0) {
                Dto dto = new Dto();
                dto.setProduct_name(product.getName());
                dto.setSale(totalQuantity);
                dto.setMrp(product.getMrp());
                dto.setAmount(totalQuantity * product.getMrp());
                list.add(dto);
            }
        }

        return list;
    }


}