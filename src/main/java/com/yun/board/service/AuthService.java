package com.yun.board.service;

import java.util.Map;
import com.yun.board.domain.Mentee;

public interface AuthService {
    Mentee getMentee(String email, String pwd);
    Mentee getFacebookMember(String accessToken);
    Mentee getNaverMember(String accessToken);
    Mentee getKakaoMember(Map<String, String> map);
}