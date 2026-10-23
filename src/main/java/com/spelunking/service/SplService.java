package com.spelunking.service;

import java.util.List;

public interface SplService {

    Rock save(RockDto rockDto);
    List<Rock> findAll();
    Rock findById(Long id);
    Rock update(Long id, RockDto rockDto);
    void delete(Long id);
}
