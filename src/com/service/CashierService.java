package com.service;
import java.util.List;

import com.model.*;
public interface CashierService {
    void addCashier(Cashier c);
    void deleteCashier(int cashierId);
    void updateCashier(Cashier c);
    List<Cashier> getAllCashier();
    boolean verifyCashier(String email,String password);
}
