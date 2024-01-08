package com.formation.restaurant.rest;

import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.util.CtrlPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restoService;

    @GetMapping
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = restoService.findAll();
        for(Restaurant restaurant : restaurants) {
            Link selfLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(restaurant.getId()).withSelfRel();
            restaurant.add(selfLink);
        }
        return restoService.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") String identifiant) {
        Restaurant reponse = restoService.findById(identifiant);
        CtrlPreconditions.checkFound(reponse);
        Link menusLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(reponse.getId()).slash("menus").withRel("menus");
        reponse.add(menusLink);
        return reponse;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String Create(@RequestBody Restaurant restaurant) {
        return restoService.create(restaurant);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Restaurant update(@PathVariable("id") String identifiant, @RequestBody Restaurant restaurant) {
        CtrlPreconditions.checkFound(restoService.findById(identifiant));
        restoService.update(identifiant, restaurant);
        return restaurant;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String identifiant, @RequestBody Map<String, Object> updates){
        CtrlPreconditions.checkFound(restoService.findById(identifiant));
        restoService.partialUpdate(identifiant, updates);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Restaurant> deleteById(@PathVariable("id") String identifiant) {
        CtrlPreconditions.checkFound(restoService.findById(identifiant));
        restoService.deleteById(identifiant);
        return restoService.findAll();
    }

}
