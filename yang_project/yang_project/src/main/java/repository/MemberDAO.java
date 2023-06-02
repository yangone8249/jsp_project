package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	void insert(MemberVO mvo);

	MemberVO select(MemberVO mvo);

	void delete(String id);

	List<MemberVO> list();

	void update(MemberVO mvo);

}
