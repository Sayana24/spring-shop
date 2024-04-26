package com.taraskina.top.springshop.dao;

import com.taraskina.top.springshop.model.Shop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopRowMapper implements RowMapper<Shop> {
@Override
    public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shop shop = new Shop();
        shop.setId(rs.getInt("id"));
        shop.setName(rs.getString(2));
        shop.setAddress(rs.getString(3));
        shop.setPhoneNumber(rs.getString(4));
        shop.setEmail(rs.getString(5));
        shop.setUrl(rs.getString(6));
        shop.setCategory(rs.getString(7));
        shop.setDescription(rs.getString(8));

        return shop;
    }
}
