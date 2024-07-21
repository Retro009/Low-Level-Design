package com.scaler.services;

import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;
import com.scaler.repositories.MenuRepository;

import java.util.List;

public class MenuServiceImpl implements MenuService{
    private final MenuRepository repository;
    public MenuServiceImpl(MenuRepository repository){
        this.repository = repository;
    }
    @Override
    public List<MenuItem> getMenuItems(String itemType) throws Exception {
        if(itemType==null || itemType.isEmpty())
            return repository.getAll();
        if(itemType.equals(DietaryRequirement.VEG.name()) ||
            itemType.equals(DietaryRequirement.NON_VEG.name()) ||
            itemType.equals(DietaryRequirement.VEGAN.name())){
            return repository.getByDietaryRequirement(DietaryRequirement.valueOf(itemType));
        }
        throw new RuntimeException("Invalid Dietary Preferrence");
    }
}
