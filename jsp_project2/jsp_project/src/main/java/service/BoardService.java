package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	void insert(BoardVO bvo);

	List<BoardVO> list();

	void update(BoardVO bvo);

	void remove(int parameter);

	void counter(int i);

}
