package com.spelunking.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spelunking.entity.*;

@Repository
public interface RockRepository extends JpaRepository<Rock, Long> {
    boolean existsByOwnerId(Long ownerId);
    List<Rock> findByOwnerId(Long ownerId);
}