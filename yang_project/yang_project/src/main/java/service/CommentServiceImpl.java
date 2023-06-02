package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

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
		log.info(">>> comment post > service in");
		return cdao.post(cvo);
	}

	@Override
	public List<CommentVO> List(int bno) {
		return cdao.List(bno);
	}

	@Override
	public int remove(int cno) {
		return cdao.remove(cno);
	}

	@Override
	public int update(CommentVO cvo) {
		return cdao.update(cvo);
	}

}
