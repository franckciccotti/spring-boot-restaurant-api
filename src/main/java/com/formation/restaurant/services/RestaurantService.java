package com.formation.restaurant.services;

import com.formation.restaurant.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    public List<Restaurant> findAll();

    /*public Restaurant findById(Long id);*/
    public Restaurant findById(String id);

    public String create(Restaurant restaurant);

    public Restaurant update(String identifiant, Restaurant restaurant);

    public void partialUpdate(String identifiant, Map<String, Object> updates);

    public void deleteById(String identifiant);
}
