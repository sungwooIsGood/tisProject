package com.tisproject.user.mapper;

import java.util.List;

import com.tisproject.biz.title.TitleVO;
import com.tisproject.biz.user.DTO.Criteria;
import com.tisproject.biz.user.DTO.UserVO;

public interface UserMapper {
	
	public UserVO loginDo(UserVO userVO) throws Exception;
	
	public UserVO selectOne(String userid) throws Exception;
	
	public void profileupdate(UserVO userVO) throws Exception;
	
	List<TitleVO> mymovielist(UserVO userVO) throws Exception;
	
	List<UserVO> mymovielist2(UserVO userVO) throws Exception;
	
	public UserVO rankupDo(UserVO userVO) throws Exception;

	public void userleave(UserVO userVO);
	
	public void signUp(UserVO userVO) throws Exception;
	
	public Integer nameCheck(UserVO userVO) throws Exception;
	
	public Integer idCheck(UserVO userVO) throws Exception;
	
	public void lockerDel(UserVO userVO) throws Exception;
	
	public void lockerDo(UserVO userVO) throws Exception;
	
	// userList
	List<UserVO> userList(UserVO userVO) throws Exception;
	
	List<UserVO> getListWithPaging(Criteria cri);

	public int getTotalCount(Criteria cri);

	// email
	public UserVO sendEmail(UserVO userVO) throws Exception;

	public void changePassword(UserVO userVO) throws Exception;
	
	public UserVO manager(UserVO userVO) throws Exception;
	
	public void reasonDo(String reason) throws Exception;
}
