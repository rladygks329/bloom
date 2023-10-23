package com.edu.blooming.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edu.blooming.domain.LectureReplyVO;

@Repository
public class LectureReplyDAOImpl implements LectureReplyDAO {

  private static final Logger logger = LoggerFactory.getLogger(LectureReplyDAOImpl.class);
  private static final String NAMESPACE = "com.edu.blooming.LectureReplyMapper";

  @Autowired
  private SqlSession sqlSession;

  @Override
  public int insert(LectureReplyVO vo) {
    logger.info("insert() 호출,  vo : " + vo.toString());
    return sqlSession.insert(NAMESPACE + ".insert", vo);
  }

  @Override
  public int update(LectureReplyVO vo) {
    logger.info("update() 호출,  vo : " + vo.toString());
    return sqlSession.insert(NAMESPACE + ".update", vo);
  }

  @Override
  public int delete(int lectureReplyId) {
    logger.info("delete() 호출,  lectureReplyId : " + lectureReplyId);

    Map<String, Integer> args = new HashMap<>();
    args.put("lectureReplyId", lectureReplyId);

    return sqlSession.insert(NAMESPACE + ".delete", args);
  }

  @Override
  public LectureReplyVO selectByLectureReplyId(int lectureReplyId) {
    logger.info("selectByLectureReplyId() 호출,  lectureReplyId : " + lectureReplyId);

    Map<String, Integer> args = new HashMap<>();
    args.put("lectureReplyId", lectureReplyId);

    return sqlSession.selectOne(NAMESPACE + ".select_by_lecture_reply_id", args);
  }

  @Override
  public List<LectureReplyVO> selectByLectureId(int lectureId) {
    logger.info("selectByLectureId() 호출,  lectureId : " + lectureId);

    Map<String, Integer> args = new HashMap<>();
    args.put("lectureId", lectureId);

    return sqlSession.selectList(NAMESPACE + ".select_by_lecture_id", args);
  }

}
