package com.internal.alertmanager.controller;

import com.internal.alertmanager.service.NotificationService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notification",method = { RequestMethod.GET, RequestMethod.POST })
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/jira/{summary}")
    public String createJiraNotification(@PathVariable String summary) throws URISyntaxException {
        ResponseEntity responseEntity = notificationService.createJiraNotification(summary);
        return responseEntity.getBody().toString();
    }

}
