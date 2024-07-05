package com.intern.irr.DAO;

import com.intern.irr.entity.User;
import com.intern.irr.entity.inspectionFormat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager em;

    //Constructor Injection of Entity manager
    @Autowired
    public UserDAOImpl(EntityManager emanager){
        this.em = emanager;
    }
    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> q = em.createQuery("SELECT user FROM User user",User.class );
        List<User> temp = q.getResultList();
        return temp;
    }
    @Override
    public List<User> loginUser(String cpf, String password) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.cpf = :cpf AND u.password = :password", User.class);
        query.setParameter("cpf", cpf);
        query.setParameter("password", password);
        return query.getResultList();  // Returns an empty list if no match is found
    }

}
