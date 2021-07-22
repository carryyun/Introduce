package com.yun.board.service;

import java.util.List;
import com.yun.board.domain.Product;

public interface ProductService {
 
  List<Product> list(); 
  
  List<Product> listForScroll(int pageNo, int pageSize); 
  
  List<Product> findAllByList(int pageNo, int pageSize); // 전체 상품 조회
  List<Product> pdalist(int pageNo, int pageSize);
  int countpdall();
  
  Product get(int no); // 공예품 번호로 조회
  
  List<Product> hotItemlist(); // 인기순위
  
  List<Product> listByMeno(int pageNo, int pageSize, int meno); // 판매자번호로 조회
  
  List<Product> listByStno(int pageNo, int pageSize, int stno); // 소분류번호로 조회
  
  List<Product> listByMtno(int pageNo, int pageSize, int mtno); // 중분류번호로 조회
  
  List<Product> listBySeller(int meno,int pageNo, int pageSize); // 판매자번호로 조회 - 마이페이지
  
  List<Product> listBySeller2(int pageNo, int pageSize, int ptno); // 판매자번호로 조회2 - 마이페이지
  
  List<Product> serchByTitl(int pageNo, int pageSize, String titl); // 판매자번호로 조회2 - 마이페이지
  
  int add(Product product);

  int update(Product product);
  
  int updatestat(Product product);
  
  
}
