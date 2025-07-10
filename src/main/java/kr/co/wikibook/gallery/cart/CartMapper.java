package kr.co.wikibook.gallery.cart;


import kr.co.wikibook.gallery.account.model.AccountJoinReq;

import kr.co.wikibook.gallery.cart.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface CartMapper {

     List<CartGetRes> findAllWithItembyMemberId(Integer id);
    int save(CartPostReq req);
    int deleteByCartIdAndMemberId(CartDeleteReq req);
    int deleteCartByMemberId(int memberId);
}
