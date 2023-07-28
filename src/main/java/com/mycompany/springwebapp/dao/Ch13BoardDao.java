package com.mycompany.springwebapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;

@Mapper
public interface Ch13BoardDao {
	//board.xml와 같은 아이디로 메소드 선언
	public int insert(Ch13Board board);
	public List<Ch13Board> selectByPage(Ch13Pager pager);
	public Ch13Board selectByBno(int bno);
	public int updateByBno(Ch13Board board);
	public int deleteByBno(int bno);
	
	public int count();
}
