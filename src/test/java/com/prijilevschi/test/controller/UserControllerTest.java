package com.prijilevschi.test.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;

import com.prijilevschi.service.UserService;

public class UserControllerTest {
    @Mock
    UserService userService;

    @Test
    public void test(){
        assertEquals(true, true);
    }
}
