package com.custom.demo.service.impl;


import com.custom.demo.pojo.Message;
import com.custom.demo.repository.MessageRepository;
import com.custom.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl  implements MessageService {
    @Autowired
    private MessageRepository repository;
    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Message update(Message message) {
        return repository.update(message);
    }

    @Override
    public Message updateText(Message message) {
        return repository.updateText(message);
    }
}
