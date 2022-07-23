package com.controlededespesas.controllers;

import com.controlededespesas.entities.Launch;
import com.controlededespesas.repositories.LaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/launch")
public class LaunchController {

    @Autowired
    private LaunchRepository launchRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Launch cadastrar(@RequestBody Launch launch){
        return launchRepository.save(launch);
    }

    @GetMapping
    public List<Launch> list(){
        return launchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Launch findById(@PathVariable Long id) {
        var launchOptional = launchRepository.findById(id);
        if (launchOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return launchOptional.get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        var launchOptional = launchRepository.findById(id);
        if (launchOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        launchRepository.delete(launchOptional.get());
    }

}
