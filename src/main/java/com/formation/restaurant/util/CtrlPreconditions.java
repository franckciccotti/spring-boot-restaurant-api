package com.formation.restaurant.util;

import com.formation.restaurant.exceptions.ResourceNotFoundException;
import com.formation.restaurant.models.Restaurant;

public class CtrlPreconditions {

    public static Restaurant checkFound(Restaurant restaurant) {
        if(restaurant == null) {
            throw new ResourceNotFoundException();
        }
        return restaurant;
    }

}
