package com.formation.restaurant.util;

import com.formation.restaurant.exceptions.ResourceNotFoundException;

public class CtrlPreconditions {

    public static <T> T checkFound(T object) {
        if(object == null) {
            throw new ResourceNotFoundException();
        }
        return object;
    }

}
