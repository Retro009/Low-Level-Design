package com.scaler.controllers;

import com.scaler.dtos.*;
import com.scaler.services.MenuService;


public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    public GetMenuItemsResponseDto getMenuItems(GetMenuItemsRequestDto requestDto){
        GetMenuItemsResponseDto responseDto = new GetMenuItemsResponseDto();
        try{
            responseDto.setMenuItems(menuService.getMenuItems(requestDto.getDietaryRequirement()));
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
