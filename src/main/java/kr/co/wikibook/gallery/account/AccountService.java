package kr.co.wikibook.gallery.account;


import kr.co.wikibook.gallery.account.model.AccountJoinReq;
import kr.co.wikibook.gallery.account.model.AccountLoginReq;
import kr.co.wikibook.gallery.account.model.AccountLoginRes;
import kr.co.wikibook.gallery.common.util.HttpUtils;
import kr.co.wikibook.gallery.item.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountService {

    private final AccountMapper accountMapper;

    public int join (AccountJoinReq req)
    {
        String hashedPw = BCrypt.hashpw(req.getLoginPw(), BCrypt.gensalt());
        //암호화가 된 비밀번호는 갖는 AccountJoinReq객체 만들어주세요
        // 새로운 공간에서 만들어서 저장하는데 이뮤터블 하게 만들기위해
        AccountJoinReq changedReq = new AccountJoinReq(req.getName(),req.getLoginId(),hashedPw);
         return accountMapper.save(changedReq);

    }
    public AccountLoginRes login(AccountLoginReq req)
    {
        AccountLoginRes res = accountMapper.findByLoginId(req);
        log.info("id 1212:" + res);
        //비밀번호 체크
        if( res == null ||!BCrypt.checkpw(req.getLoginPw(), res.getLoginPw()))
        {

         return null; // 비밀번호가 다르면 null 처리
        }


        return res;




    }

}
