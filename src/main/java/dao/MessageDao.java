package dao;

import dao.generic.AbstractJpaDao;
import models.Message;

public class MessageDao extends AbstractJpaDao<Long, Message> {

    public MessageDao() {
        super(Message.class);
    }
    
}
