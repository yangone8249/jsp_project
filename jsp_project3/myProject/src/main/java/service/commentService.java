package service;

import java.util.List;

import domain.commentVO;

public interface commentService {

	int post(commentVO cvo);

	List<commentVO> getList(int bno);

	int remove(int cno);

	int update(commentVO cvo);

}
