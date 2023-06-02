package repository;

import java.util.List;

import domain.ProductVO;

public interface DAO {

	int insert(ProductVO pvo);

	List<ProductVO> selectList();

	ProductVO selectOne(int pno);

	int update(int pno, String updateName, int updatePrice, String updateMadeby);

	void remove(int pno3);



}
