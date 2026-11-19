package com.spelunking.controller;

import com.spelunking.dto.MinerDto;
import com.spelunking.dto.RockDto;
import com.spelunking.entity.Miner;
import com.spelunking.entity.Rock;
import com.spelunking.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class SplController {
    private final SplService splService;

    @PostMapping("/rock")
    @ResponseStatus(HttpStatus.CREATED)
    public Rock saveRock(@Valid @RequestBody RockDto rock) {
        return splService.saveRock(rock);
    }

    @GetMapping("/rock")
    public List<Rock> getAllRocks() {
        return splService.findAllRocks();
    }

    @GetMapping("/rock/{id}")
    public Rock getRockById(@PathVariable Long id) {
        return splService.findRockById(id);
    }

    @PutMapping("/rock/{id}")
    public Rock updateRock(@PathVariable Long id, @Valid @RequestBody RockDto rock) {
        return splService.updateRock(id, rock);
    }

    @DeleteMapping("/rock/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRock(@PathVariable Long id) {
        splService.deleteRock(id);
    }

    @PostMapping("/miner")
    @ResponseStatus(HttpStatus.CREATED)
    public Miner saveMiner(@Valid @RequestBody MinerDto miner) {
        return splService.saveMiner(miner);
    }

    @GetMapping("/miner")
    public List<Miner> getAllMiners() {
        return splService.findAllMiners();
    }

    @GetMapping("/miner/{id}")
    public Miner getMinerById(@PathVariable Long id) {
        return splService.findMinerById(id);
    }

    @PutMapping("/miner/{id}")
    public Miner updateMiner(@PathVariable Long id, @Valid @RequestBody MinerDto miner) {
        return splService.updateMiner(id, miner);
    }

    @DeleteMapping("/miner/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMiner(@PathVariable Long id) {
        splService.deleteMiner(id);
    }

}