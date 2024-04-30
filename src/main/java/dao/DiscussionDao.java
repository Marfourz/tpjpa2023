package dao;

import dao.generic.AbstractJpaDao;
import models.Discussion;

public class DiscussionDao extends AbstractJpaDao<Long, Discussion> {

    public DiscussionDao() {
        super(Discussion.class);
    }
    
}
