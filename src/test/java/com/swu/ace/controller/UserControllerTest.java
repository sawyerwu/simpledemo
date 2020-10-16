package com.swu.ace.controller;


import com.swu.ace.model.User;
import com.swu.ace.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserController.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private UserService userService;

    private User user1;
    private User user2;
    private List<User> userList;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        user1  = new User("user1", 11);
        user2  = new User("user2", 22);
        userList = Arrays.asList(user1, user2);
    }

    String allUsersResult = "[{\"name\":\"user1\",\"age\":11},{\"name\":\"user2\",\"age\":22}]";
    String getUserResult = "{\"age\":11,\"name\":\"user1\"}";


    @Test
    public void testGetAllUser() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(userList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/users").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(allUsersResult, content);
    }

    @Test
    public void testGetUser() throws Exception {
        Mockito.when(userService.getUserByName(Mockito.anyString())).thenReturn(user1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/user/get/user1").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(getUserResult, content);
    }

    @Test
    public void testCreateUser() throws Exception {
        Mockito.when(userService.createUser(Mockito.anyString(), Mockito.anyInt())).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/user/create/user3/33").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("true", content);
    }

    @Test
    public void testDeleteUser() throws Exception {
        Mockito.when(userService.deleteUserByName(Mockito.anyString())).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/user/del/user1").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("true", content);
    }
}
