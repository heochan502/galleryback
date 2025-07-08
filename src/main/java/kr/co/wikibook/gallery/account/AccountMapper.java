package kr.co.wikibook.gallery.account;


import kr.co.wikibook.gallery.account.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    AccountLoginRes findByLoginId (AccountLoginReq req);
    int save(AccountJoinReq req);

}
