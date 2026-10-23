package com.spelunking.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface SplRepository extends JpaRepository<Rock, Long> {

}
