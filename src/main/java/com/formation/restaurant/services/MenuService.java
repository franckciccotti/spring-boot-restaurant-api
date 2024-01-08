package com.formation.restaurant.services;

import com.formation.restaurant.models.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MenuService {
    public List<Menu> findAll();
    public Set<Menu> findAllOfRestaurant(String id);
    public Menu findById(String id);
    public String create(String idRestaurant, Menu idMenu);
    public void update(String id, Menu menu);
    public void partialUpdate(String id, Map<String, Object> updates);
    public void deleteById(String idRestaurant, String idMenu);
}
