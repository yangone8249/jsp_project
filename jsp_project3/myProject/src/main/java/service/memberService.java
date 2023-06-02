package service;

import java.util.List;

import domain.memberVO;

public interface memberService {

	void insert(memberVO mvo);

	int search(memberVO mvo);

	memberVO findMvo(memberVO mvo);

	List<memberVO> list();

	void remove(String parameter);

}
