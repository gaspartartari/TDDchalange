package com.devsuperior.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.EventRepository;
import com.devsuperior.demo.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {


    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        if(!eventRepository.existsById(id))
            throw new ResourceNotFoundException("Resource not found");
        Event entity = eventRepository.getReferenceById(id);
        entity.setCity(new City(dto.getCityId(), null));
        entity.setDate(dto.getDate());
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity = eventRepository.save(entity);
        return new EventDTO(entity);
    }
    
}
