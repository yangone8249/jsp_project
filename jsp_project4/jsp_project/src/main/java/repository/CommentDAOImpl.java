package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	private final String NS = "CommentMapper.";
	private int isOk;
	
	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(CommentVO cvo) {
		log.info(">>>> comment post > DAO in");
		isOk = sql.insert(NS+"reg", cvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info(">>>> comment list > DAO in");
		return sql.selectList(NS+"list", bno);
	}

	@Override
	public int delete(int cno) {
		log.info(">>>> comment remove > DAO in");
		isOk = sql.delete(NS+"del", cno);
		if(isOk>0) sql.commit();
		return isOk;
	}

	@Override
	public int update(CommentVO cvo) {
		log.info(">>>> comment modify > DAO in");
		isOk = sql.delete(NS+"up", cvo);
		if(isOk>0) sql.commit();
		return isOk;
	}

}
