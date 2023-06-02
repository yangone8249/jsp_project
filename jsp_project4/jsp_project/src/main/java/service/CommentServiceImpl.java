package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImpl;

public class CommentServiceImpl implements CommentService {
	private static Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO cdao;
	
	public CommentServiceImpl() {
		cdao = new CommentDAOImpl();
	}
	
	@Override
	public int post(CommentVO cvo) {
		log.info(">>>> Comment post > service in");
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info(">>>> Comment list > service in");
		return cdao.getList(bno);
	}

	@Override
	public int remove(int cno) {
		log.info(">>>> Comment remove > service in");
		return cdao.delete(cno);
	}

	@Override
	public int modify(CommentVO cvo) {
		log.info(">>>> Comment modify > service in");
		return cdao.update(cvo);
	}

}
