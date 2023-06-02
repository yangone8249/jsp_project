package repository;

import java.util.List;

import domain.memberVO;

public interface memberDAO {

	void insert(memberVO mvo);

	int search(memberVO mvo);

	memberVO findMvo(memberVO mvo);

	List<memberVO> list();

	void remove(String parameter);

}
