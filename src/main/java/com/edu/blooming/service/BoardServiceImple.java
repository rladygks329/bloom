package com.edu.blooming.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.edu.blooming.domain.BoardVO;
import com.edu.blooming.persistence.BoardDAO;
import com.edu.blooming.util.PageCriteria;

@Service
public class BoardServiceImple implements BoardService {
  private static final Logger logger = LoggerFactory.getLogger(BoardServiceImple.class);
  @Autowired
  private BoardDAO boardDAO;

  @Override
  public int create(BoardVO vo) {
    logger.info("create() 호출 : vo = " + vo.toString());
    return boardDAO.insert(vo);
  }

  @Override
  public List<BoardVO> read(PageCriteria criteria) {
    logger.info("read() 호출");
    logger.info("start = " + criteria.getStart());
    logger.info("end = " + criteria.getEnd());
    return boardDAO.select(criteria);
  }

  @Override
  public List<BoardVO> read(PageCriteria criteria, String keyword) {
    logger.info("read() 호출 keyword: " + keyword);
    logger.info("start = " + criteria.getStart());
    logger.info("end = " + criteria.getEnd());
    return boardDAO.select(criteria, keyword);
  }

  @Override
  public List<BoardVO> read(PageCriteria criteria, int memberId) {
    logger.info("findLectureByAuthorId() 호출");
    logger.info("start = " + criteria.getStart());
    logger.info("end = " + criteria.getEnd());
    return boardDAO.select(criteria, memberId);
  }

  @Override
  public int getTotalCounts() {
    logger.info("getTotalCounts() 호출");
    return boardDAO.getTotalCounts();
  }

  @Override
  public BoardVO read(int boardId) {
    logger.info("read() 호출: boardId = " + boardId);
    return boardDAO.select(boardId);
  }

  @Override
  public int update(BoardVO vo) {
    logger.info("update() 호출: vo = " + vo.toString());
    return boardDAO.update(vo);
  }

  @Override
  public int updateViewCount(int boardId) {
    logger.info("updateViewCount()호출: boardId = " + boardId);
    return boardDAO.updateViewCount(boardId);
  }

  @Transactional(value = "transactionManager")
  @Override
  public int likeBoard(int boardId, int memberId) {
    logger.info("likeBoard() 호출, boardId : " + boardId + " memberId : " + memberId);
    boardDAO.updateLikeCount(boardId, 1);
    return boardDAO.insertLike(memberId, boardId);
  }

  @Transactional(value = "transactionManager")
  @Override
  public int dislikeBoard(int boardId, int memberId) {
    logger.info("dislikeBoard() 호출, boardId : " + boardId + " memberId : " + memberId);
    boardDAO.updateLikeCount(boardId, -1);
    return boardDAO.deleteLike(memberId, boardId);
  }

  @Override
  public boolean checkIsLike(int memberId, int boardId) {
    logger.info("checkIsLike() 호출");
    return boardDAO.selectIsMemberLikeBoard(memberId, boardId);
  }

  @Override
  public int getTotalCountsByKeyword() {
    logger.info("getTotalCountsByKeyword() 호출");
    return boardDAO.getTotalCountsByKeyword();
  }

  @Override
  public int getTotalCountsByMemberId() {
    logger.info("getTotalCountsByMemberId() 호출");
    return boardDAO.getTotalCountsByMemberId();
  }



}


