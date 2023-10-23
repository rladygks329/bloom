package com.edu.blooming.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.blooming.domain.MemberVO;
import com.edu.blooming.persistence.MemberDAO;

@Service
public class MemberServiceImple implements MemberService {
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberServiceImple.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public int create(MemberVO vo) {
		logger.info("create()호출: vo = " + vo.toString());
		return dao.insert(vo);
	} // end create()

	@Override
	public int emailCheck(String memberEmail) throws Exception {
		logger.info("emailCheck() 호출: email = " + memberEmail);
		return dao.emailCheck(memberEmail);
	}


	@Override
	public MemberVO memberLogin(MemberVO vo) throws Exception {
		logger.info("memberLogin() 호출");
		return dao.memberLogin(vo);
		
	}



	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}





	
	
} // end MemberService







