package com.yun.board.web;
//package com.yun.board.web;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.yun.board.domain.Mentee;
//import com.yun.board.service.AuthService;
//
//@Controller
//@RequestMapping("/facebook")
//public class FacebookController {
//
//  AuthService authService;
//
//  public FacebookController(AuthService authService) {
//    this.authService = authService;
//  }
//
//  @GetMapping("form")
//  public void form() {
//  }
//
//  @PostMapping("login")
//  public String login(
//      String type,
//      String email,
//      String password,
//      String save,
//      HttpServletResponse response,
//      HttpSession session) {
//
//    if (save != null) {// 이메일 저장하기를 체크했다면,
//      Cookie cookie = new Cookie("email", email);
//      cookie.setMaxAge(60 * 60 * 24 * 15);
//      response.addCookie(cookie);
//
//    } else {// 이메일을 저장하고 싶지 않다면,
//      Cookie cookie = new Cookie("email", "");
//      cookie.setMaxAge(0);
//      response.addCookie(cookie);
//    }
//
//    Mentee loginUser = authService.getMentee(email, password);
//
//    if (loginUser != null) {
//      // 회원 정보를 세션에 보관한다.
//      session.setAttribute("loginUser", loginUser);
//      String redirectUrl = null;
//
//      switch (type) {
//        case "manager":
//          redirectUrl = "../mem/list";
//          break; 
//      }
//      return "redirect:" + redirectUrl;
//
//    } else {
//      session.invalidate();
//      return "redirect:form";
//    }
//  }
//
//  @GetMapping("logout")
//  public String logout(HttpSession session) {
//    session.invalidate();
//    return "redirect:form";
//  }
//
//  @RequestMapping("fl")
//  public String fblogin(
//      String accessToken,
//      String type,
//      HttpSession session) {
//
//    return "redirect:form";
//
//    /*try {
//          Member loginUser = authService.getFacebookMember(accessToken, type);
//
//          // 회원 정보를 세션에 보관한다.
//          session.setAttribute("loginUser", loginUser);
//          String redirectUrl = null;
//
//          switch (type) {
//          case "manager":
//              redirectUrl = "../manager/list";
//              break; 
//          }
//          return "redirect:" + redirectUrl;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.invalidate();
//            return "redirect:form";
//        }*/
//  }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
