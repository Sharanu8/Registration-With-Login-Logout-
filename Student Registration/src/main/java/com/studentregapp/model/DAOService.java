package com.studentregapp.model;

import java.sql.ResultSet;

public interface DAOService {
public void connectionDB();
public boolean verifyCredentials(String email, String password);
public void saveReg(String name, String city, String email, String mobile);
public ResultSet listRegistrations();
public void deleteByEmail(String email);
public void updateReg(String email, String mobile);
}
