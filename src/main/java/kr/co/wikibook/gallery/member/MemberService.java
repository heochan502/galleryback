package kr.co.wikibook.gallery.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private MemberMapper memeberMapper;
}
