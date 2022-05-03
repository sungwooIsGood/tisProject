package com.tisproject.biz.user.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisproject.biz.title.TitleVO;
import com.tisproject.biz.user.DAO.UserDAO;
import com.tisproject.biz.user.DTO.Criteria;
import com.tisproject.biz.user.DTO.UserVO;
import com.tisproject.biz.user.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO selectOne(String userid) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectOne(userid);
	}
	
	
	@Override
	public void profileupdate(UserVO userVO) throws Exception{
		userDAO.profileupdate(userVO);
	}

	@Override
	public List<TitleVO> mymovielist(UserVO userVO) throws Exception{
		System.out.println(userVO.getUserid());
		return userDAO.mymovielist(userVO);
	}
	
	@Override
	public List<UserVO> mymovielist2(UserVO userVO) throws Exception{
		System.out.println(userVO.getUserid());
		return userDAO.mymovielist2(userVO);
	}

	@Override
	public UserVO loginDo(UserVO userVO) throws Exception{
		System.out.println("ID:");
		System.out.println("Password:");
		
		return userDAO.loginDo(userVO);
		
	}
	
	@Override
	public void rankupDo(UserVO userVO) throws Exception{
		
		userDAO.rankupDo(userVO);
	}
	
	@Override
	public void userleave(UserVO userVO) {
		
		userDAO.userleave(userVO);
		
	}


	//회원가입
	@Override
	public void SignUp(UserVO userVO) throws Exception{
		System.out.println("회원가입 서비스 시작");
		userDAO.signUp(userVO);
		System.out.println("회원가입 서비스 끝");
	}
	
	// 이름중복 체크
	@Override
	public Integer nameCheck(UserVO userVO) throws Exception {
		Integer result = userDAO.nameCheck(userVO);
		return result;
	}
			
	// 아이디 중복 체크
	@Override
	public Integer idCheck(UserVO userVO) throws Exception {
		Integer result = userDAO.idCheck(userVO);
		return result;
	}
	

	// userList
//	@Override
//	public List<UserVO> userList(UserVO userVO) throws Exception{
//		System.out.println(userVO.getUserid());
//		System.out.println("userServiceImpl: "+userVO);
//		return userDAO.userList(userVO);
//	}

	// userList page
	@Override
	public List<UserVO> userList(Criteria cri) {
		return userDAO.getListWithPaging(cri);
	}


	@Override
	public int getTotal(Criteria cri) {
		return userDAO.getTotalCount(cri);
	}


	// 안성우 추가
	   @Override
	   public UserVO sendEmail(UserVO userVO) throws Exception {
	      return userDAO.sendEmail(userVO);
	   }

	   // 임시 비밀번호로 수정
	   @Override
	   public void changePassword(UserVO userVO) throws Exception {
	      userDAO.changePassword(userVO);
	   }


	@Override
	public UserVO manager(UserVO userVO) throws Exception {
		return userDAO.manager(userVO);
	}
	
	@Override
	public void reasonDo(String reason) throws Exception {

		userDAO.reasonDo(reason);
	}
	
	@Override
	public void lockerDo(UserVO userVO) throws Exception {
		
		userDAO.lockerDo(userVO);
		
	}
	
	@Override
	public void lockerDel(UserVO userVO) throws Exception {
		
		userDAO.lockerDel(userVO);
		
	}
	

	

}
