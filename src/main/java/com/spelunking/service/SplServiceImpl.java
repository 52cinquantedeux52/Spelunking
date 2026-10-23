package com.spelunking.service;

import com.spelunking.repository.SplRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SplServiceImpl implements SplService {

    private final SplRepository splRepository;

    @Override
    public Rock save(RockDto rockDto) {
        Rock rock = new Rock();
        rock.setName(rockDto.getName());
        rock.setType(rockDto.getType());
        rock.setMohsScale(rockDto.getMohsScale());
        rock.setWeight(rockDto.getWeight());
        rock.setColor(rockDto.getColor());
        rock.setDiscoverPlace(rockDto.getDiscoverPlace());
        rock.setDescription(rockDto.getDescription());
        return splRepository.save(rock);
    }

    @Override
    public List<Rock> findAll() {
        return splRepository.findAll();
    }

    @Override
    public Rock findById(Long id) {
        // which id ? id Rock : id Mineur
        return splRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Rock not found :("));
    }

    @Override
    public Rock update(Long id, RockDto rockDto) {
        Rock rock = findById(id);
        rock.setName(rockDto.getName());
        rock.setType(rockDto.getType());
        rock.setMohsScale(rockDto.getMohsScale());
        rock.setWeight(rockDto.getWeight());
        rock.setColor(rockDto.getColor());
        rock.setDiscoverPlace(rockDto.getDiscoverPlace());
        rock.setDescription(rockDto.getDescription());
        return splRepository.save(rock);
    }

    @Override
    public void delete(Long id) {
        Rock rock = findById(id);
        splRepository.delete(rock);
    }

}
