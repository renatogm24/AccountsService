package com.group7.accountsservice.controller;

import com.group7.accountsservice.dto.MovementRequest;
import com.group7.accountsservice.dto.MovementResponse;
import com.group7.accountsservice.service.MovementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts/movement")
@AllArgsConstructor
@Slf4j
public class MovementController {
    private MovementService service;

    @GetMapping
    public Flux<MovementResponse> getAllMovements(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public Mono<MovementResponse> getMovement(@PathVariable String id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovementResponse> saveMovement(@RequestBody MovementRequest movementRequest){
        return service.save(movementRequest);
    }

    @PutMapping("{id}")
    public Mono<MovementResponse> updateMovement(@PathVariable String id,
                                                        @RequestBody MovementRequest movementRequest){
        return service.update(id, movementRequest);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteMovement(@PathVariable String id){
        return service.delete(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAllMovements(){
        return service.deleteAll();
    }
}
