package com.tisproject.biz.user.DAO.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tisproject.biz.title.TitleVO;
import com.tisproject.biz.user.DAO.UserDAO;
import com.tisproject.biz.user.DTO.Criteria;
import com.tisproject.biz.user.DTO.UserVO;
import com.tisproject.user.mapper.UserMapper;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;
	


	
	@Override
	public UserVO selectOne(String userid) throws Exception {
		// TODO Auto-generated method stub
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.selectOne(userid);
	}



	@Override
	public void profileupdate(UserVO vo) throws Exception {
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.profileupdate(vo);
	}
	
	@Override
	public List<TitleVO> mymovielist(UserVO userVO) throws Exception{
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.mymovielist(userVO);
	}
	
	@Override
	public List<UserVO> mymovielist2(UserVO userVO) throws Exception{
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.mymovielist2(userVO);
	}
	
	@Override
	public UserVO loginDo(UserVO userVO) throws Exception{
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.loginDo(userVO);
	}
	
	@Override
	public UserVO rankupDo(UserVO userVO) throws Exception{
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.rankupDo(userVO);
	}

	
	@Override
	public void userleave(UserVO userVO) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.userleave(userVO);
	}
	
	@Override
	public void signUp(UserVO userVO) throws Exception{
		System.out.println("회원가입 dao 시작");
//		sqlSession.insert("userMapper.signUp", userVO);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.signUp(userVO);
		System.out.println("회원가입 dao 끝");
	}
	
	//이름 중복 확인
	@Override
	public Integer nameCheck(UserVO userVO) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.nameCheck(userVO);
//		int result = sqlSession.selectOne("UserMapper.nameCheck", nickname);
//		return result;
	}
		
	//아이디 중복 확인
	@Override
	public Integer idCheck(UserVO userVO) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.idCheck(userVO);
//		int result = sqlSession.selectOne("UserMapper.nameCheck", nickname);
//		return result;
	}

	
	// userList
//	@Override
//	public List<UserVO> userList(UserVO userVO) throws Exception{
////		List<UserVO> list = sqlSession.selectList("com.tisproject.user.mapper.UserMapper.userList");
//		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		System.out.println("userDAOImpl: "+userVO);
//		return mapper.userList(userVO);
//	}



	@Override
	public List<UserVO> getListWithPaging(Criteria cri) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.getTotalCount(cri);
	}

	// 안성우 추가
	@Override
	public UserVO sendEmail(UserVO userVO) throws Exception {
	   UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	   return mapper.sendEmail(userVO);
	}
	   
	// 임시비밀번호로 수정
	public void changePassword(UserVO userVO) throws Exception {
	   UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	   mapper.changePassword(userVO);
	}



	@Override
	public UserVO manager(UserVO userVO) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		return mapper.manager(userVO);
	}
	
	
	@Override
	public void reasonDo(String reason) throws Exception {

		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.reasonDo(reason);
	}
	
	@Override
	public void lockerDo(UserVO userVO) throws Exception{
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.lockerDo(userVO);
		
	}
	
	@Override
	public void lockerDel(UserVO userVO) throws Exception{
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.lockerDel(userVO);
	}
}
