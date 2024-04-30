package dao;
import dao.generic.AbstractJpaDao;
import models.User;

public class UserDao extends AbstractJpaDao<Long,User> {

    public UserDao() {
        super(User.class);
    }


    public User findByUsername(String username){
        String query = "select u from User u where u.username =: username";
        
        try {
            User user = this.entityManager.createQuery(query, User.class)
                        .setParameter("username", username)
                        .getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }

        
    }


}

    
