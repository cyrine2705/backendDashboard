package com.example.demo.notifications;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<PushNotificationRequest,String> {
    List<PushNotificationRequest> findByToken(String token);
}
