package com.spelunking.service;

import java.util.List;

import com.spelunking.dto.*;
import com.spelunking.entity.*;

public interface SplService {

    Rock saveRock(RockDto rockDto);
    List<Rock> findAllRocks();
    Rock findRockById(Long id);
    Rock updateRock(Long id, RockDto rockDto);
    void deleteRock(Long id);
    List<Rock> findRocksByMinerId(Long minerId);

    Miner saveMiner(MinerDto minerDto);
    List<Miner> findAllMiners();
    Miner findMinerById(Long id);
    Miner updateMiner(Long id, MinerDto minerDto);
    void deleteMiner(Long id);

}
