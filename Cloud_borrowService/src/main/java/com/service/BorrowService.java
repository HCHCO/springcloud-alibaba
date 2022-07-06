package com.service;

import com.entity.UserBorrowDetail;
import entity.Borrow;

import java.util.List;

public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(int uid);
    boolean doBorrow(int uid,int bid);
    boolean testBorrow(int uid, int bid);
}
