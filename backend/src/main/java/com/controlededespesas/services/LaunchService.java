package com.controlededespesas.services;

import com.controlededespesas.entities.Launch;
import com.controlededespesas.repositories.LaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class LaunchService {

    @Autowired
    private LaunchRepository launchRepository;

}
