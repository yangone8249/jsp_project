package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.commentVO;
import orm.DatabaseBuilder;


public class commentDAOImpl implements commentDAO {
	private static Logger log = LoggerFactory.getLogger(commentDAOImpl.class);
	private SqlSession sql;
	private final String NS = "commentMapper.";
	private int isOk;
	
	public commentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int post(commentVO cvo) {
		log.info(">>> comment post > DAO in");
		isOk = sql.insert(NS+"post", cvo);
		if(isOk>0) {
			sql.commit();
		}
		return 0;
	}

	@Override
	public List<commentVO> getList(int bno) {
		log.info(">>> comment post > DAO in");		
		return sql.selectList(NS+"getList",bno);
	}

	@Override
	public int remove(int cno) {
		isOk = sql.delete(NS+"remove", cno);
		if(isOk > 0) {
			sql.commit();
			return isOk;
		}
		return 0;
	}

	@Override
	public int update(commentVO cvo) {
		isOk = sql.update(NS+"update", cvo);
		System.out.println(isOk);
		if(isOk>0) {
			sql.commit();
			return isOk;
		}
		
		return 0;
	}

}
