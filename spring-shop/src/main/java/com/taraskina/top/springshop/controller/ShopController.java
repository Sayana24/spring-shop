package com.taraskina.top.springshop.controller;

import com.taraskina.top.springshop.dao.ShopJdbcTemplateDao;
import com.taraskina.top.springshop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/shops")
public class ShopController {
    private ShopJdbcTemplateDao shopDao;

    @Autowired
    public ShopController(ShopJdbcTemplateDao shopDao) {
        this.shopDao = shopDao;
    }

    @GetMapping
    public String index(Model model){
        List<Shop> shops = shopDao.findAll();
        model.addAttribute("shops", shops);
        return "shops/index";
    }

    @GetMapping("/new")
    public String newShop(Model model){
        model.addAttribute("shop", new Shop());

        return "shops/new";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("shop", shopDao.find(id));
        return "shops/show";
    }
    @PostMapping
    public String create(@ModelAttribute("shop") Shop shop){

        shopDao.save(shop);
        return "redirect:/shops";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("shop", shopDao.find(id));
        return "shops/edit";
    }
    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("shop") Shop shop){
        shopDao.update(id, shop);
        return "redirect:/shops";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        shopDao.delete(id);
        return "redirect:/shops";
    }
}
