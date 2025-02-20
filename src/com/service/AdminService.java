package com.service;
import com.model.*;

public interface AdminService {
    void addAdmin(Admin a);
     boolean verifyAdmin(String username,String password);
}
