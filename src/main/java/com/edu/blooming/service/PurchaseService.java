package com.edu.blooming.service;

import java.util.List;
import com.edu.blooming.domain.LectureVO;

public interface PurchaseService {

  int purchase(int memberId, List<Integer> lectureIds);

  int purchase(int memberId, int lectureId);

  int refund(int memberId, int lectureId);

  List<LectureVO> getPurchaseList(int memberId);

  boolean checkPurchase(int memberId, int lectureId);
}