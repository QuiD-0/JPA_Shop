package jpa.jpa_study.stomp.controller;

import jpa.jpa_study.stomp.model.ChatMessage;
import jpa.jpa_study.stomp.mongo_test.MongoTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessageSendingOperations sendingOperations;

    private final MongoTestService mongoTestService;

    @MessageMapping("/chat/message")
    public void enter(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setMessage(message.getSender() + "님이 입장하였습니다.");
        } else if (ChatMessage.MessageType.TALK.equals(message.getType())) {
            mongoTestService.test(message);
        } else if (ChatMessage.MessageType.OUT.equals(message.getType())) {
            message.setMessage(message.getSender() + "님이 퇴장하였습니다.");
        }
        System.out.println(message);
        sendingOperations.convertAndSend("/topic/chat/room/" + message.getRoomId(), message);
    }
}