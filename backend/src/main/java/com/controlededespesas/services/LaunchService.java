package com.controlededespesas.services;
import com.controlededespesas.repositories.LaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LaunchService {

    @Autowired
    private LaunchRepository launchRepository;

}
