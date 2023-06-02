package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.memberVO;
import repository.memberDAO;
import repository.memberDAOImpl;

public class memberServiceImpl implements memberService {
	private static final Logger log = LoggerFactory.getLogger(memberServiceImpl.class);
	private memberDAO mdao;
	
	public memberServiceImpl() {
		mdao = new memberDAOImpl();
	}
	
	@Override
	public void insert(memberVO mvo) {
		mdao.insert(mvo);
	}

	@Override
	public int search(memberVO mvo) {
		return mdao.search(mvo);
	}

	@Override
	public memberVO findMvo(memberVO mvo) {
		return  mdao.findMvo(mvo);
	}

	@Override
	public List<memberVO> list() {
		return mdao.list();
	}

	@Override
	public void remove(String parameter) {
		mdao.remove(parameter);
	}

}
