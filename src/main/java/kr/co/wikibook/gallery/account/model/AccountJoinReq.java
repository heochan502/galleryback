package kr.co.wikibook.gallery.account.model;

import kr.co.wikibook.gallery.account.AccountMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//기본생성자 만드는거
//@NoArgsConstructor
@AllArgsConstructor
public class AccountJoinReq {
    private String name;
    private String loginId;
    private String loginPw;

}
