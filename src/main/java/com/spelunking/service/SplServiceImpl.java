package com.spelunking.service;

import com.spelunking.dto.MinerDto;
import com.spelunking.repository.MinerRepository;
import com.spelunking.repository.RockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import com.spelunking.entity.*;
import com.spelunking.dto.*;

@Service
@Transactional
@RequiredArgsConstructor
public class SplServiceImpl implements SplService {

    private final RockRepository rockRepository ;
    private final MinerRepository minerRepository ;

    @Override
    public Rock saveRock(RockDto rockDto) {
        Rock rock = new Rock();
        rock.setName(rockDto.name());
        rock.setType(rockDto.type());
        rock.setMohsScale(rockDto.mohsScale());
        rock.setWeight(rockDto.weight());
        rock.setReference(rockDto.reference());
        rock.setColor(rockDto.color());
        rock.setDiscoveredPlace(rockDto.discoveredPlace());
        rock.setDescription(rockDto.description());
        rock.setOwner( this.findMinerById(rockDto.ownerId()) );
        return rockRepository.save(rock);
    }

    @Override
    public List<Rock> findAllRocks() {
        return rockRepository.findAll();
    }

    @Override
    public Rock findRockById(Long id) {
        // which id ? id Rock : id Mineur
        return rockRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Rock not found :("));
    }

    @Override
    public Rock updateRock(Long id, RockDto rockDto) {
        Rock rock = this.findRockById(id);
        rock.setName(rockDto.name());
        rock.setType(rockDto.type());
        rock.setMohsScale(rockDto.mohsScale());
        rock.setWeight(rockDto.weight());
        rock.setColor(rockDto.color());
        rock.setDiscoveredPlace(rockDto.discoveredPlace());
        rock.setDescription(rockDto.description());
        rock.setOwner( this.findMinerById(rockDto.ownerId()) );
        return rockRepository.save(rock);
    }

    @Override
    public void deleteRock(Long id) {
        Rock rock = this.findRockById(id);
        rockRepository.delete(rock);
    }

    @Override
    public Miner saveMiner(MinerDto minerDto) {
        Miner miner = new Miner();
        miner.setId(minerDto.id());
        miner.setName(minerDto.name());
        return minerRepository.save(miner);
    }

    @Override
    public List<Miner> findAllMiners() { return minerRepository.findAll(); }

    @Override
    public Miner findMinerById(Long id) {
        return minerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Miner not found :(")
        );
    }

    @Override
    public Miner updateMiner(Long id, MinerDto minerDto) {
        Miner miner = new Miner();
        miner.setId(minerDto.id());
        miner.setName(minerDto.name());
        return minerRepository.save(miner);
    }

    @Override
    public void deleteMiner(Long id) {
        Miner miner = findMinerById(id);
        minerRepository.delete(miner);
    }

}
