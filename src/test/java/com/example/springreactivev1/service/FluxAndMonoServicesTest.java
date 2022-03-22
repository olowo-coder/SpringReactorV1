package com.example.springreactivev1.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitFlux() {
        var fruitFlux = fluxAndMonoServices.fruitFlux();
        StepVerifier.create(fruitFlux).expectNext("Mango", "Orange", "Banana").verifyComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono = fluxAndMonoServices.fruitMono();
        StepVerifier.create(fruitMono).expectNext("Mango").verifyComplete();
    }

    @Test
    void fruitFluxMap() {
        var fruitFlux = fluxAndMonoServices.fruitFluxMap();
        StepVerifier.create(fruitFlux).expectNext("MANGO", "ORANGE", "BANANA").verifyComplete();
    }

    @Test
    void fruitFluxFilter() {
        var fruitFlux = fluxAndMonoServices.fruitFluxFilter(4);
        StepVerifier.create(fruitFlux).expectNext("Mango","Orange", "Banana").verifyComplete();
    }

    @Test
    void fruitFluxFilterMap() {
        var fruitFlux = fluxAndMonoServices.fruitFluxFilterMap(5);
        StepVerifier.create(fruitFlux).expectNext("ORANGE", "BANANA").verifyComplete();
    }

    @Test
    void fruitFluxFlatMap() {
        var fruitFlux = fluxAndMonoServices.fruitFluxFlatMap();
        StepVerifier.create(fruitFlux).expectNextCount(17).verifyComplete();
    }

    @Test
    void fruitFluxFlatMapAsync() {
        var fruitFlux = fluxAndMonoServices.fruitFluxFlatMapAsync();
        StepVerifier.create(fruitFlux).expectNextCount(17).verifyComplete();
    }

    @Test
    void fruitMonoFlatMap() {
        var fruitMono = fluxAndMonoServices.fruitMonoFlatMap();
        StepVerifier.create(fruitMono).expectNextCount(1).verifyComplete();
    }

    @Test
    void fruitFluxConcatMap() {
        var fruitFlux = fluxAndMonoServices.fruitFluxConcatMap();
        StepVerifier.create(fruitFlux).expectNextCount(17).verifyComplete();
    }

    @Test
    void fruitMonoFlatMapMany() {
        var fruitFlux = fluxAndMonoServices.fruitMonoFlatMapMany();
        StepVerifier.create(fruitFlux).expectNextCount(5).verifyComplete();
    }
}