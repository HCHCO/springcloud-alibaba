package com.service;

import com.entity.UserBorrowDetail;

public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(int uid);
    boolean doBorrow(int uid,int bid);
}
