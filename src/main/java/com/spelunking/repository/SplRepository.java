package com.spelunking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spelunking.entity.*;

@Repository
public interface SplRepository extends JpaRepository<Rock, Long> {

}
