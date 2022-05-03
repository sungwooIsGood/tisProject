package com.tisproject.biz.user.Service;

import java.util.List;

import com.tisproject.biz.title.TitleVO;
import com.tisproject.biz.user.DTO.Criteria;
import com.tisproject.biz.user.DTO.UserVO;

public interface UserService {

	public UserVO loginDo(UserVO userVO) throws Exception;
	
	public UserVO selectOne(String userid) throws Exception;
	
	public void profileupdate(UserVO userVO) throws Exception;
	
	List<TitleVO> mymovielist(UserVO userVO) throws Exception;
	
	List<UserVO> mymovielist2(UserVO userVO) throws Exception;
	
	public void rankupDo(UserVO userVO) throws Exception;
	
	public void userleave(UserVO userVO);
	
	public void SignUp(UserVO userVO) throws Exception;
	
	public Integer nameCheck(UserVO userVO) throws Exception;
	
	public Integer idCheck(UserVO userVO) throws Exception;
	
	public void lockerDel(UserVO userVO) throws Exception;
	
	public void lockerDo(UserVO userVO) throws Exception;
	
	// userList
//	public List<UserVO> userList(UserVO userVO) throws Exception;

	public List<UserVO> userList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	// 안성우 추가 user Email 확인
	public UserVO sendEmail(UserVO userVO) throws Exception;
	
	// 임시 비밀번호로 수정
	public void changePassword(UserVO userVO) throws Exception;
	
	public UserVO manager(UserVO userVO) throws Exception;
	
	public void reasonDo(String reason) throws Exception;
}
