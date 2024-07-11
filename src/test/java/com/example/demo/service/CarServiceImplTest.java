package com.example.demo.service;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;
    @Mock
    private MocPassportServiceImpl mocPassportService;

    @Test
    void math() {
        //given
        int first = 3;
        int second = 2;
        //when
        when(mocPassportService.test()).thenReturn(5);
        //then
        int result = carService.math(first, second);
        assertEquals(30, result);
    }
}