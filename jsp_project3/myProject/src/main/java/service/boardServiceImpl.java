package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.PagingVO;
import domain.boardVO;
import repository.boardDAO;
import repository.boardDAOImpl;

public class boardServiceImpl implements boardService{
	private static final Logger log = LoggerFactory.getLogger(boardServiceImpl.class);
	private boardDAO bdao;
	
	public boardServiceImpl() {
		bdao = new boardDAOImpl();
	}

	@Override
	public void create(boardVO bvo) {
		bdao.create(bvo);
	}

	@Override
	public List<boardVO> list() {
		return bdao.list();
	}

	@Override
	public void counter(int string) {
		bdao.counter(string);
	}

	@Override
	public void update(boardVO updateBvo) {
		bdao.update(updateBvo);
	}

	@Override
	public void remove(int num) {
		bdao.remove(num);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		return bdao.getTotal(pgvo);
	}

	@Override
	public List<boardVO> getPageList(PagingVO pgvo) {
		return bdao.getPageList(pgvo);
	}
	
	
	
	
	

}
