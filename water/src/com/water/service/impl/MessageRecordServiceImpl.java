package com.water.service.impl;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import com.water.model.MessageRecord;
import com.water.service.MessageRecordService;

@Service
public class MessageRecordServiceImpl extends MyBaseServiceImpl<MessageRecord> implements MessageRecordService{

}
