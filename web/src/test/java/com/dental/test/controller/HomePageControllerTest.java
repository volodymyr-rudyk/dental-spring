package com.dental.test.controller;

import com.dental.config.AppConfig;
import com.dental.controller.HomePageController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by vrudyk on 6/10/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class HomePageControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private HomePageController homePageController;

  private MockMvc mockMvc;

  @Before
  public void before() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }
  @Test
  public void testMock() {
    Assert.assertNotNull(mockMvc);
  }

  @Test
  public void testHomeControllerLoaded() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
//        .andExpect(MockMvcResultMatchers.content());
//    Assert.assertNotNull(homePageController);
  }

}
