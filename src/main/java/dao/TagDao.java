package dao;

import dao.generic.AbstractJpaDao;
import models.Tag;

public class TagDao extends AbstractJpaDao<Long,Tag> {

    public TagDao() {
        super(Tag.class);
    }
    
}
