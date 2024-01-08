package com.formation.restaurant.services.impl;

import com.formation.restaurant.dao.MenuRepository;
import com.formation.restaurant.dao.RestaurantRepository;
import com.formation.restaurant.models.Menu;
import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private RestaurantRepository restoRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> findAll() {
        List<Menu> liste = new ArrayList<Menu>();
        menuRepository.findAll().forEach(liste::add);
        return liste;
    }

    @Override
    public Set<Menu> findAllOfRestaurant(String idRestaurant) {
        return restoRepository.findById(idRestaurant).get().getMenus();
    }

    @Override
    public Menu findById(String id) {
        if(menuRepository.findById(id).isPresent()) {
            return menuRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public String create(String idRestaurant, Menu menu) {
        Restaurant restoEntity = restoRepository.findById(idRestaurant).get();
        restoEntity.getMenus().add(menu);
        restoRepository.save(restoEntity);
        Menu menuEntity = restoEntity.getMenus().stream().filter(m -> m.equals(menu)).findFirst().get();
        return menuEntity.getIdentifiant();
    }

    @Override
    public void update(String id, Menu menu) {
        menu.setIdentifiant(id);
        menuRepository.save(menu);
    }

    @Override
    public void partialUpdate(String id, Map<String, Object> updates) {
        Menu menuToUpdate = menuRepository.findById(id).get();
        for (String key : updates.keySet()) {
            switch (key) {
                case "entrees": {
                    menuToUpdate.setEntrees((String) updates.get(key));
                    break;
                }
                case "plats": {
                    menuToUpdate.setPlats((String) updates.get(key));
                    break;
                }
                case "desserts": {
                    menuToUpdate.setDesserts((String) updates.get(key));
                    break;
                }
            }
        }
        menuRepository.save(menuToUpdate);
    }

    @Override
    public void deleteById(String idRestaurant, String idMenu) {
        Restaurant restoToUpdate = restoRepository.findById(idRestaurant).get();
        Set<Menu> menus = restoToUpdate.getMenus();
        Menu menu = menus.stream().filter(m -> m.getIdentifiant().equals(idMenu)).findFirst().get();
        menus.remove(menu);
        restoToUpdate.setMenus(menus);
        restoRepository.save(restoToUpdate);
        menuRepository.delete(menu);
    }
}
