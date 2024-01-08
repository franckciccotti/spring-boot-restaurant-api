package com.formation.restaurant.dao;

import com.formation.restaurant.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, String> {
}
