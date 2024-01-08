package com.formation.restaurant.rest;

import com.formation.restaurant.models.Menu;
import com.formation.restaurant.services.MenuService;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.util.CtrlPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class MenuController {

    @Autowired
    public MenuService menuService;

    @Autowired
    public RestaurantService restoService;

    @GetMapping("/menus")
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @GetMapping("/restaurants/{idResto}/menus")
    public Set<Menu> findAllOfRestaurant(@PathVariable("idResto") String idRestaurant) {
        CtrlPreconditions.checkFound(restoService.findById(idRestaurant));
        return menuService.findAllOfRestaurant(idRestaurant);
    }

    @GetMapping("/menus/{id}")
    public Menu findById(@PathVariable("id") String id) {
        Menu reponse = menuService.findById(id);
        CtrlPreconditions.checkFound(reponse);
        return reponse;
    }

    @PostMapping("/restaurants/{idResto}/menus")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@PathVariable("idResto") String idRestaurant, @RequestBody Menu menu) {
        CtrlPreconditions.checkFound(restoService.findById(idRestaurant));
        return menuService.create(idRestaurant, menu);
    }

    @PutMapping("/menus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody Menu menu) {
        CtrlPreconditions.checkFound(menuService.findById(id));
        menuService.update(id, menu);
    }

    @PatchMapping("/menus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String id, @RequestBody Map<String, Object> updates) {
        CtrlPreconditions.checkFound(menuService.findById(id));
        menuService.partialUpdate(id, updates);
    }

    @DeleteMapping("/restaurants/{idResto}/menus/{idMenus}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("idResto") String idRestaurant, @PathVariable("idMenus") String idMenu) {
        CtrlPreconditions.checkFound(restoService.findById(idRestaurant));
        CtrlPreconditions.checkFound(menuService.findById(idMenu));
        menuService.deleteById(idRestaurant, idMenu);
    }

}
