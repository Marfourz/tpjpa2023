package dao;

import dao.generic.AbstractJpaDao;
import models.Project;

public class ProjectDao extends AbstractJpaDao<Long,Project> {

    public ProjectDao(){
        super(Project.class);
    }
}
