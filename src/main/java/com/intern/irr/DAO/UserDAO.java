package com.intern.irr.DAO;

import com.intern.irr.entity.User;
import com.intern.irr.entity.inspectionFormat;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAllUsers();
    List<User> loginUser(String cpf, String password);
}
