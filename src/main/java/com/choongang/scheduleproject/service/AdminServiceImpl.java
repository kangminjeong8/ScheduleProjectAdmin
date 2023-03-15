package com.choongang.scheduleproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choongang.scheduleproject.command.CheckVO;
import com.choongang.scheduleproject.command.ProjectActiveVO;
import com.choongang.scheduleproject.command.ProjectCheckVO;
import com.choongang.scheduleproject.command.ProjectDetailMemberVO;
import com.choongang.scheduleproject.command.ProjectDetailVO;
import com.choongang.scheduleproject.command.ProjectVO;
import com.choongang.scheduleproject.command.UserActiveVO;
import com.choongang.scheduleproject.command.UserVO;
import com.choongang.scheduleproject.mapper.AdminMapper;
import com.choongang.scheduleproject.util.Criteria;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminMapper adminMapper;
	// 회원 목록
	@Override
	public ArrayList<UserVO> getMemberList(Criteria criteria) {
		return adminMapper.getMemberList(criteria); 
	}
	//총 회원 수
	@Override
	public int getMemberCount(Criteria criteria) {
		return adminMapper.getMemberCount(criteria);
	}
	//회원 체크박스 업데이트
	@Override
	public int checkMemberUpdate(ArrayList<CheckVO> list) {
		int result=0; //결과값 반환
		
		for(CheckVO vo : list) {
			if(vo.getPwReset().equals("on")) {
				result = adminMapper.checkMemberUpdate(vo);
			}
		}//리스트에 담긴 VO 객체 매퍼에 담아서 처리
		return result;
	}
	//회원 삭제
	@Override
	public int deleteMember(ArrayList<CheckVO> list) {
		int result=0; //결과값 반환
		
		for(CheckVO vo : list) {
			if(vo.getMemberDelete().equals("on")) {
				result = adminMapper.deleteMember(vo);
			}
		}//리스트에 담긴 VO 객체 매퍼에 담아서 처리
		return result;
	}
	//프로젝트 목록 출력
	@Override
	public ArrayList<ProjectVO> getProjectList(Criteria criteria) {
		return adminMapper.getProjectList(criteria); //반환
	}
	//검색 시 프로젝트 결과 총갯수
	@Override
	public int getProjectCount(Criteria criteria) {
		return adminMapper.getProjectCount(criteria);
	}
	//프로젝트 삭제 체크박스 업데이트
	@Override
	public int deleteProjectList(ArrayList<ProjectCheckVO> list) {
		int result = 0;
		for(ProjectCheckVO vo: list) {
			if(vo.isPj_delete() == true) {				
				result = adminMapper.deleteProjectList(vo); //반복문 사용으로 프로젝트 넘버 당 하나하나 delete 실행
			}
		}
		
		return result;
	}
	//프로젝트 상세보기 내용 구함
	@Override
	public ProjectDetailVO getProjectDetail(ProjectDetailVO vo) {
		return adminMapper.getProjectDetail(vo);
	}
	//프로젝트 상세보기 인원 구함
	@Override
	public ArrayList<ProjectDetailMemberVO> getProjectDetailMember(ProjectDetailVO vo) {
		return adminMapper.getProjectDetailMember(vo);
	}
	//유저 활성/비활성 기능
	@Override
	public int userActiveUpdate(UserActiveVO vo) {
		return adminMapper.userActiveUpdate(vo);
	}
	//프로젝트 활성 비활성 기능
	@Override
	public int projectActiveUpdate(ProjectActiveVO vo) {
		return adminMapper.projectActiveUpdate(vo);
	}
	
}
