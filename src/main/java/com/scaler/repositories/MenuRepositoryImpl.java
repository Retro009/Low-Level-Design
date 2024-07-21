package com.scaler.repositories;

import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepositoryImpl implements MenuRepository{

    private List<MenuItem> allMenuItems = new ArrayList<>();
    @Override
    public MenuItem add(MenuItem menuItem) {
        allMenuItems.add(menuItem);
        return menuItem;
    }

    @Override
    public List<MenuItem> getAll() {
        return allMenuItems;
    }

    @Override
    public List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement) {
        return allMenuItems.stream().filter(menuItem -> menuItem.getDietaryRequirement().equals(dietaryRequirement)).collect(Collectors.toList());
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return add(menuItem);
    }
}
