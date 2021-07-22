package com.yun.board.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.yun.board.domain.BigTag;
import com.yun.board.domain.Cert;
import com.yun.board.domain.ClassOrder;
import com.yun.board.domain.ClassQna;
import com.yun.board.domain.Classes;
import com.yun.board.domain.Cs;
import com.yun.board.domain.Mentee;
import com.yun.board.domain.Mentor;
import com.yun.board.domain.MentorFile;
import com.yun.board.domain.MentorLicense;
import com.yun.board.domain.MentorTag;
import com.yun.board.domain.Product;
import com.yun.board.domain.ProductOrder;
import com.yun.board.domain.ProductQnA;
import com.yun.board.service.BigTagService;
import com.yun.board.service.CertService;
import com.yun.board.service.ClassOrderService;
import com.yun.board.service.ClassQnaService;
import com.yun.board.service.ClassService;
import com.yun.board.service.CsService;
import com.yun.board.service.MenteeService;
import com.yun.board.service.MentoTagService;
import com.yun.board.service.MentorFileService;
import com.yun.board.service.MentorLicenseService;
import com.yun.board.service.MentorService;
import com.yun.board.service.ProductOrderService;
import com.yun.board.service.ProductQnAService;
import com.yun.board.service.ProductService;
 
@Controller
@RequestMapping("/mypage")
public class MypageController {

  MenteeService menteeService;
  MentorService mentorService;
  CsService csService;
  ClassQnaService classQnaService;
  ProductQnAService productQnAService;
  ClassOrderService classOrderService;
  ProductOrderService productOrderSerivce;
  ClassService classService;
  ProductService productService;
  CertService certService;
  BigTagService bigTagService;
  MentoTagService mentoTagService;
  MentorFileService mentorFileService;
  MentorLicenseService mentorLicenseService;
  ServletContext sc;
  
  

  public MypageController(
      MenteeService menteeService,
      MentorService mentorService,
      CsService csService,
      ClassQnaService classQnaService,
      ProductQnAService productQnAService,
      ClassOrderService classOrderService,
      ProductOrderService productOrderService,
      ClassService classService,
      ProductService productService,
      CertService certService,
      BigTagService bigTagService,
      MentoTagService mentoTagService,
      MentorFileService mentorFileService,
      MentorLicenseService mentorLicenseService,
    ServletContext sc) {
   this.menteeService = menteeService;
   this.mentorService = mentorService;
   this.csService = csService;
   this.classQnaService = classQnaService;
   this.productQnAService = productQnAService;
   this.classOrderService = classOrderService;
   this.productOrderSerivce = productOrderService;
   this.classService = classService;
   this.productService = productService;
   this.certService = certService;
   this.bigTagService = bigTagService;
   this.mentoTagService = mentoTagService;
   this.mentorFileService=mentorFileService;
   this.mentorLicenseService=mentorLicenseService;
   this.sc = sc ;
   
   
  }
  
  @RequestMapping(value="deleteuser.do", method= {RequestMethod.POST})
  public @ResponseBody int deleteuser(String withdrawalpwd,HttpSession session){
    System.out.println("ASDASD");
    System.out.println(menteeService.delete(withdrawalpwd));
    if(menteeService.delete(withdrawalpwd) > 0) {
      session.invalidate(); 
      return menteeService.delete(withdrawalpwd);
    }
    return menteeService.delete(withdrawalpwd);
  }

  @GetMapping("mypage")
  public void mypage(Model model,HttpSession session) {
    
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    Mentee mentee = menteeService.get(reMeno);
    model.addAttribute("mentee", mentee);
    
    if(mentee.getPhot() == null) {
      mentee.setPhot("/upload/images/images.png");
      model.addAttribute("mentee", mentee);
    }else {
      model.addAttribute("mentee", mentee);
    }
    
    Mentor mentor = mentorService.get(reMeno);
    model.addAttribute("mentor", mentor);
    
  }
  
  @GetMapping("headerMainMy")
  public void headerMainMy(Model model,HttpSession session) {
    
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
   
    Mentee mentee = menteeService.get(reMeno);
    model.addAttribute("mentee", mentee);
    
    if(mentee.getPhot() == null) {
      mentee.setPhot("/upload/images/images.png");
      model.addAttribute("mentee", mentee);
    }else {
      model.addAttribute("mentee", mentee);
    }
    
    
  }
  
  @GetMapping("headerNavMy")
  public void headerNavMy(Model model,HttpSession session) {
  }
  
  @GetMapping("menu1")
  public void menu1(Model model,HttpSession session) {
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
   
    Mentee mentee = menteeService.get(reMeno);
    if(mentee.getPhot() == null) {
      mentee.setPhot("/upload/images/images.png");
      model.addAttribute("mentee", mentee);
    }else {
      model.addAttribute("mentee", mentee);
    }
    
    
    Mentor mentor = mentorService.get(reMeno);
      model.addAttribute("mentor", mentor);
      
      List<BigTag> btag = bigTagService.list();
      model.addAttribute("btag", btag);
      
      
  }
   
  @RequestMapping(value = "photoupload", method=RequestMethod.POST)
  public String  photoupload(@RequestParam("photoUpdate") List<MultipartFile> photo,
      @RequestParam("meno") int meno,
       Mentee mentee,
       HttpSession session
      ) throws Exception {
    
    

    String filename = "";
    
    for(MultipartFile file : photo) {
      if(file.getOriginalFilename().length() > 2 ) {
        filename = UUID.randomUUID().toString();
        file.transferTo(new File(sc.getRealPath("/upload/img/" + filename+".png")));
      } 
    }
    
    System.out.println(filename);
    
    String phot ="/upload/img/"+ filename+".png";
    
    mentee.setNo(meno);
    mentee.setPhot(phot);
    
    System.out.println(mentee.getPhot());
    
    menteeService.updatePhoto(mentee);
    Mentee loginUser = menteeService.get(mentee.getNo());
    session.setAttribute("loginUser", loginUser);
    
  return "redirect:mypage";
}
  
  @RequestMapping(value = "imgupload", method=RequestMethod.POST)
  public String  imgupload(@RequestParam("fileUpload1") List<MultipartFile> files,
      @RequestParam("fileUpload2") List<MultipartFile> files2,
      @RequestParam("no") int noin,
      @RequestParam("carrin") String carrin, 
      @RequestParam("btno") int btnoin,
      MentorTag mentorTag, Mentee mentee,MentorFile mentorFile,MentorLicense mentorLicense) throws Exception {
     System.out.println(noin);
     System.out.println(carrin);
     System.out.println(btnoin);
      // string 에서 int값만 뽑아서  을 int type으로 변환
    
    
    String str1 = carrin;
    String str3 = new String();



    for(int i = 0 ; i < str1.length(); i ++)
    {    
      if(48 <= str1.charAt(i) && str1.charAt(i) <= 57)
        str3 += str1.charAt(i);
    }

    int newCarr = Integer.parseInt(str3);
    // string 에서 int값만 뽑아서  을 int type으로 변환
    
    
   
    // 멘토 신청 처음
    
     
    if ( mentorService.get(noin) == null) {
      char mtstat = 'I';
      mentee.setMtstat(mtstat);
  
      Mentor mentor = new Mentor();
      mentor.setNo(noin);
      mentor.setCarr(newCarr);
      
      mentorTag.setMono(noin);
      mentorTag.setBtno(btnoin);
      
      menteeService.updateMtstat(mentee);
      
      mentorService.add(mentor);
      
      mentoTagService.add(mentorTag);
      
      
    }
    
    // 신청한적이있다면 
    else {
      char mtstat = 'I';
      mentee.setMtstat(mtstat);

      Mentor mentor = new Mentor();
      mentor.setNo(noin);
      mentor.setCarr(newCarr);


      menteeService.updateMtstat(mentee); // 신청할때마다 I로 넘김

      mentorService.update(mentor);  // 경력은 업데이트
      
      List<MentorTag> mo = mentoTagService.listByMono(1, 10, noin);
      List<Integer> setMtaglist = new ArrayList<>();
      
      for(MentorTag  m: mo) {
        setMtaglist.add(m.getBtno());
      }
      
      if(setMtaglist.contains(btnoin)) {
      }
      else {
        mentorTag.setMono(noin);
        mentorTag.setBtno(btnoin);
        mentoTagService.add(mentorTag);
      }
      
    }


    String filename = "";
        
    for(MultipartFile file : files) {
      
      filename = "";
      
      if(file.getOriginalFilename().length() > 2 ) {
        filename = UUID.randomUUID().toString();
        file.transferTo(new File(sc.getRealPath("/upload/img/meto_file/" + filename+".png")));
        
        String phot ="/upload/img/meto_file/"+ filename+".png";
        
        mentorFile.setMono(noin);
        mentorFile.setMfname(phot);
        mentorFileService.add(mentorFile);
        
      } 
    }
    
    
    for(MultipartFile file : files2) {
      
    filename = "";
      
      if(file.getOriginalFilename().length() > 2 ) {

        filename = UUID.randomUUID().toString();
        file.transferTo(new File(sc.getRealPath("/upload/img/meto_licn/" + filename+".png")));
        
        String phot ="/upload/img/meto_licn/"+ filename+".png";
        
        mentorLicense.setMono(noin);
        mentorLicense.setPhot(phot);
        mentorLicense.setLname("자격증");
        mentorLicenseService.add(mentorLicense);
        
      } 
    }
    
    
    return "redirect:mypage";
  }

  
/*  
  @RequestMapping(value = "mentorInsert.do", method = {RequestMethod.POST})
  public @ResponseBody int add(Mentor mentor,HttpSession session) {
    
    Mentee mentee = (Mentee) session.getAttribute("loginUser");
    
    mentee.getNo()
    
    return mentorService.add(mentor);
  }

    */  
    
  
  @RequestMapping(value = "updateProfile.do", method = {RequestMethod.POST})
  public @ResponseBody int updateProfile(Mentee mentee) {
    
    return menteeService.updateProfile(mentee);
  }
  
  @RequestMapping(value = "updatePwd.do", method = {RequestMethod.POST})
  public @ResponseBody int updatePwd(Mentee mentee) {
    
    return menteeService.updatePwd(mentee);
  }
  
  @RequestMapping(value = "updatePhone.do", method = {RequestMethod.POST})
  public @ResponseBody int updatePhone(Mentee mentee) {
    
    return menteeService.updatePhone(mentee);
  }
  
  @RequestMapping(value = "updateAddr.do", method = {RequestMethod.POST})
  public @ResponseBody int updateAddr(Mentee mentee) {
    
    return menteeService.updateAddr(mentee);
  }
  
 /* @RequestMapping(value = "updatePhoto.do", method = {RequestMethod.POST})
  public @ResponseBody int updatePhoto(Mentee mentee) {
    
    return menteeService.updatePhoto(mentee);
  }
  */
  
  
  @GetMapping("menu2")
  public void menu2(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {

    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<ClassOrder> colist = classOrderService.listByMeno(reMeno,pageNo,pageSize);
    model.addAttribute("colist", colist );
    
  }
  
  
  @GetMapping("menu3-1")
  public void menu3_1(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    System.out.println(reMeno);
    List<ClassOrder> colist = classOrderService.listByMeno(reMeno , pageNo,pageSize);
    
    model.addAttribute("colist", colist );
 }
  
  @GetMapping("menu3-2")
  public void menu3_2(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<ProductOrder> polist = productOrderSerivce.listByMeno(reMeno,pageNo,pageSize);
    model.addAttribute("polist", polist );
    
  }
  
  @GetMapping("menu4-1")
  public void menu4_1(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<Cs> cslist = csService.list(reMeno,pageNo,pageSize);
    
    model.addAttribute("cslist",cslist);
    
    
    
  }
  
  @GetMapping("menu4-2")
  public void menu4_2(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<ClassQna> cqlist = classQnaService.classqnalist(reMeno,pageNo,pageSize);
    model.addAttribute("cqlist", cqlist );
    
  }
  
  @GetMapping("menu4-3")
  public void menu4_3(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<ClassQna> cqlist2 = classQnaService.classqnalist2(reMeno,pageNo,pageSize);
    model.addAttribute("cqlist2", cqlist2 );
    
  }
  /* menu4-3 */
  @RequestMapping(value = "clsansupdate.do", method = {RequestMethod.POST})
  public @ResponseBody List<ClassQna> clsansupdate(int no , String anser,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    
    ClassQna classqna = classQnaService.get(no);
    classqna.setAnser(anser);
    
    classQnaService.ansupdate(classqna);
    
    Mentee mentee = (Mentee) session.getAttribute("loginUser");
    
    List<ClassQna> clsqnalist = classQnaService.classqnalist2(mentee.getNo(), pageNo, pageSize);
    
    return clsqnalist;
  }
  
  @GetMapping("menu4-4")
  public void menu4_4(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<ProductQnA> pqlist = productQnAService.listByMeno(reMeno,pageNo,pageSize);
    model.addAttribute("pqlist", pqlist );
    
  }
  
  @GetMapping("menu4-5")
  public void menu4_5(Model model,HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<ProductQnA> pqlist2 = productQnAService.listByMeno2(reMeno,pageNo,pageSize);
    model.addAttribute("pqlist2", pqlist2 );
  }
  /* menu4-5 */
  @RequestMapping(value = "ansupdate.do", method = {RequestMethod.POST})
  public @ResponseBody List<ProductQnA> ansupdate(int no , String anser,HttpSession session) {
    
    ProductQnA productqna = productQnAService.get(no);
    productqna.setAnser(anser);
    
    productQnAService.updateAnser(productqna);
    
    Mentee mentee = (Mentee) session.getAttribute("loginUser");
    
    List<ProductQnA> qnalist = productQnAService.listByMeno2(mentee.getNo(), 1, 10);
    
    return qnalist;
  }
  
  @GetMapping("menu5")
  public void menu5(Model model,HttpSession session, 
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="5") int pageSize) { 
    
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    int countmanage = classService.countmanageByMono(reMeno);
    
    List<Classes> cmanage = classService.manageByMono(reMeno,pageNo,pageSize);
    model.addAttribute("cmanage",cmanage);
    model.addAttribute("countmanage",countmanage);
    
 /*   List<Classes> cm = classService.manageByCno(cno);
    
    model.addAttribute("cm", cm);*/
        
  }
  
  @RequestMapping(value = "menu5page.do", method = {RequestMethod.POST})
  public @ResponseBody List<Classes> menu5page(HttpSession session, 
      @RequestParam(defaultValue="2") int pageNo, @RequestParam(defaultValue="5") int pageSize) {
    
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<Classes> clsmenu5list = classService.manageByMono(reMeno, pageNo, pageSize);
    
    return clsmenu5list;
  }
  
  @RequestMapping(value = "insertCert.do", method = {RequestMethod.POST})
  public @ResponseBody int insertCert(Cert cert) {

    return certService.insertCert(cert);
  }
  
 
  
  @GetMapping("menu5disable")
  public void menu5disable(Model model) { 

  }
  
  @GetMapping("menu5disable2")
  public void menu5disable2(Model model) { 

  }
  
  
  @GetMapping("menu6")
  public void menu6(Model model,HttpSession session, 
      @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="5") int pageSize) {
    Mentee imentee = (Mentee) session.getAttribute("loginUser");
    int reMeno = imentee.getNo();
    
    List<Product> pmanage = productService.listBySeller(reMeno,pageNo,pageSize);
    model.addAttribute("pmanage", pmanage );
    
  }
   
  
  @RequestMapping(value="menu6buyer", method = {RequestMethod.GET, RequestMethod.POST})
  public void menu6buyer(Model model,int ptno) {
    System.out.println(ptno);
    
    List<Product> pmanage2 = productService.listBySeller2(1,10,ptno);
    model.addAttribute("pmanage2", pmanage2 );
    
       
  }
  
  
  
  @RequestMapping(value = "getMenteeList.do", method = {RequestMethod.POST})
  public @ResponseBody List<Classes> getMenteeList(int no) {
    List<Classes> alllist = classService.manageByCno(no);
    
    // cert 발급여부를 체크하기위해 임시로 star사용
    List<Classes> checklist = classService.checkForCert(alllist.get(0).getNo());
    for(Classes origin : alllist) {
      
      origin.setStar(5);
      
      for(Classes c : checklist) {
        
        if(c.getMentee2().getNo() == origin.getMentee2().getNo()){
          origin.setStar(1);
        }
        
      }
      
    }
    
//    return classService.manageByCno(no);
    return alllist;
  }
  @RequestMapping(value = "deliveryinsert.do", method = {RequestMethod.POST})
  public @ResponseBody int deliveryInsert(String parcname,String parcno, int ono) {
    
    System.out.println(parcno);
    
    ProductOrder order = new ProductOrder();
    order.setParc_name(parcname);
    order.setParc_no(parcno);
    order.setNo(ono);
    return productOrderSerivce.adddeliveryinfo(order);
  }
  
  @RequestMapping(value = "questionInsert.do", method = {RequestMethod.POST})
  public @ResponseBody int questionInsert(HttpSession session, Cs cs) {
    Mentee mentee = (Mentee) session.getAttribute("loginUser");
    cs.setMeno(mentee.getNo());
    return csService.addQuestioninfo(cs);
  }
  
/*  @RequestMapping(value = "buyerList.do", method = {RequestMethod.POST})
  public @ResponseBody List<Product> buyerList(int ptno) {
    
    return productService.listBySeller2(1, 10, ptno);
  }*/
  

  
  
}





