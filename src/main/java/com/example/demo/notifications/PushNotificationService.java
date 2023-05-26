package com.example.demo.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PushNotificationService {
@Autowired
private NotificationRepository notif;
    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    private FCMService fcmService;

    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }


    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(request);
            notif.save(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    public List<PushNotificationRequest> getNotifications(String device){
          return notif.findByToken(device);

    }

}