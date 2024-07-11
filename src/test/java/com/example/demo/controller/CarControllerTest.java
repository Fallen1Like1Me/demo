package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CarServiceImpl carService;
@Test
    void getAllCars() throws Exception {
        Mockito.when(carService.getAllCars()).thenReturn(new ArrayList<Car>());

        mockMvc.perform(get("/getAllCars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
}