package com.spelunking.controller;

import com.spelunking.service.SplService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.spelunking.entity.*;

@RequestMapping("/rocks")
@RestController
@RequiredArgsConstructor

public class SplController {
    private final SplService splService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rock save(@Valid @RequestBody RockDto rock) {
        return SplService.save(rock);
    }

    @GetMapping
    public List<Rock> getAll() {
        return splService.findAll();
    }

    @GetMapping("/{id}")
    public Rock getById(@PathVariable Long id) {
        return splService.findById(id);
    }

    @PutMapping("/{id}")
    public Rock update(@PathVariable Long id, @Valid @RequestBody RockDto rock) {
        return splService.update(id, rock);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        splService.delete(id);
    }

}