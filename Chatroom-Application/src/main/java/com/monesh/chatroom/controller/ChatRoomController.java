package com.monesh.chatroom.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.monesh.chatroom.dto.Message;

@Controller
public class ChatRoomController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message) throws Exception {
        return new Message(HtmlUtils.htmlEscape(message.getUsername()), HtmlUtils.htmlEscape(message.getContent()));
    }

    @MessageMapping("/leave")
    @SendTo("/topic/messages")
    public Message leave(Message message) throws Exception {
        return new Message(HtmlUtils.htmlEscape(message.getUsername()), HtmlUtils.htmlEscape(message.getContent() + " has left the chat"));
    }

    @GetMapping("/chatapp/login")
    public String login() {
        return "login";
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "chat";
    }
}
