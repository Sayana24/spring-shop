package com.taraskina.top.springshop.dao;

import com.taraskina.top.springshop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ShopJdbcTemplateDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShopJdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Shop> findAll(){
        return jdbcTemplate.query("select * from shop",
                new ShopRowMapper());
    }
    public Shop find(int id){
        Shop shop;
        List<Shop> shops = jdbcTemplate.query("select * from shop where id=?", new Object[]{id}, new ShopRowMapper());
        if(shops.isEmpty())
            return null;
        else
            return shops.get(0);
    }
    public void save(Shop shop){

        jdbcTemplate.update("insert into shop (name, address, phone_number, email, url, category, description) " +
                "values (?, ?, ?, ?, ?, ?, ?)", shop.getName(), shop.getAddress(), shop.getPhoneNumber(),
                shop.getEmail(), shop.getUrl(), shop.getCategory(), shop.getDescription());
    }
    public void update(int id, Shop shop){
        jdbcTemplate.update("update shop set name = ?, address = ?, phone_number = ?, " +
                "email = ?, url = ?, category = ?, description = ? where id = ?",
                shop.getName(), shop.getAddress(), shop.getPhoneNumber(), shop.getEmail(),
                shop.getUrl(), shop.getCategory(), shop.getDescription(),id);
    }
    public void delete(int id){
        Shop shop;
        jdbcTemplate.update("delete from shop where id = ?", id);
    }
}
