package com.formation.restaurant.dao;

import com.formation.restaurant.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}*/

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}
