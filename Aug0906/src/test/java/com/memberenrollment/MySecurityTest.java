package com.memberenrollment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MySecurityTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSecuredEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secured-endpoint"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUnauthorizedAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secured-endpoint"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
}
