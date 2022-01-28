package com.example.press_play_store_website.services;

import com.example.press_play_store_website.entities.tables.StaffEntity;

public class StaffService {
    public void update(StaffEntity updatedCustomer, StaffEntity staff) {
        //staff.setStaffId(updatedCustomer.getStaffId());
        staff.setFirstName(updatedCustomer.getFirstName());
        staff.setLastName(updatedCustomer.getLastName());
        //staff.setAddressId(updatedCustomer.getAddressId());
        //staff.setPicture(updatedCustomer.getPicture());
        staff.setEmail(updatedCustomer.getEmail());
        //staff.setStoreId(updatedCustomer.getStoreId());
        //staff.setActive(updatedCustomer.getActive());
        //staff.setUsername(updatedCustomer.getUsername());
        //staff.setPassword(updatedCustomer.getPassword());
    }
}
