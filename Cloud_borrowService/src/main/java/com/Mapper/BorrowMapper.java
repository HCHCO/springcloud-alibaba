package com.Mapper;

import entity.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from DB_BORROW where uid =#{uid}")
    List<Borrow> getBorrowByUid(int uid);

    @Select("select * from DB_BORROW where bid = #{bid}")
    List<Borrow> getBorrowByBid(int bid);

    @Select("select * from DB_BORROW where uid = #{uid} and bid = #{bid}")
    List<Borrow> getBorrow(int uid,int bid);

    @Insert("insert into DB_BORROW(uid,bid)values(#{uid},#{bid})")
    int addBorrow(int uid,int bid);


}
