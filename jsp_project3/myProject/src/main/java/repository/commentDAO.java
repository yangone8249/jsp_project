package repository;

import java.util.List;

import domain.commentVO;

public interface commentDAO {

	int post(commentVO cvo);

	List<commentVO> getList(int bno);

	int remove(int cno);

	int update(commentVO cvo);

}
