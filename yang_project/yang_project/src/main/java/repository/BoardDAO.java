package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	void insert(BoardVO bvo);

	List<BoardVO> list();

	BoardVO detail(int parameter);

	void count(int parseInt);

	void update(BoardVO boardVO);

	void remove(int parseInt);

	int getTotal(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);

}
