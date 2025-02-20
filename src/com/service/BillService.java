package com.service;
import java.util.List;

import com.model.*;
public interface BillService {
    void addBill(Bill b);
    void removeBill(int billNo);
    List<Bill> searchBill(int billNo);
    List<Bill> getAllBill();
}
