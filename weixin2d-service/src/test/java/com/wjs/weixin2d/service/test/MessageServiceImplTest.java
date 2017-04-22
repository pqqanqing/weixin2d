package com.wjs.weixin2d.service.test;

import com.wjs.weixin2d.service.message.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testReceiveMessage() {
        Map<String, Object> map = new HashMap<>();
        map.put("toUserName", "1");
        map.put("fromUserName", "2");
        map.put("createTime", "3");
        map.put("msgType", "event");
        map.put("event", "SCAN");
        map.put("eventKey", "4");
        map.put("ticket", "5");
        messageService.receive(map);
    }
}
