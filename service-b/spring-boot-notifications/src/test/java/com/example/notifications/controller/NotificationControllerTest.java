package com.example.notifications.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.example.notifications.model.Notification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest(classes = com.example.notifications.NotificationsApplication.class)
@AutoConfigureMockMvc
public class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new NotificationController()).build();
    }

    @Test
    public void testNotifyUser() throws Exception {
        Notification notification = new Notification();
        notification.setId(1L);
        notification.setMessage("Test notification");
        notification.setTimestamp(String.valueOf(System.currentTimeMillis()));

        mockMvc.perform(post("/notify")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"message\":\"Test notification\",\"timestamp\":" + notification.getTimestamp() + "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Test notification"));
    }

    @Test
    public void testNotifyEndpoint() throws Exception {
        mockMvc.perform(post("/notify")
                .contentType("application/json")
                .content("{\"message\": \"Test notification\"}"))
                .andExpect(status().isCreated());
    }
}