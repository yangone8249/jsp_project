package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.commentVO;
import repository.commentDAO;
import repository.commentDAOImpl;

public class commentServiceImpl implements commentService {
	private static Logger log = LoggerFactory.getLogger(commentServiceImpl.class);
	private commentDAO cdao;
	
	public commentServiceImpl() {
		cdao = new commentDAOImpl();
	}
	
	@Override
	public int post(commentVO cvo) {
		log.info(">>> comment post > service in");
		return cdao.post(cvo);
	}

	@Override
	public List<commentVO> getList(int bno) {
		log.info(">>> comment getList > service in");
		return cdao.getList(bno);
	}

	@Override
	public int remove(int cno) {
		return cdao.remove(cno);
	}

	@Override
	public int update(commentVO cvo) {
		return cdao.update(cvo);
	}

}
