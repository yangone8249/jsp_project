package repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	//NameSpace = SQL이 mapper를 구분하기 위한 이름
	//NameSpace.SQL구문이름
	private String NS = "MemberMapper.";
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(MemberVO mvo) {
		//sql.insert(MemberMapper.reg, 객체);
		//transaction 처리가 자동 이루어짐
		int isOk = sql.insert(NS+"reg", mvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo2) {
		log.info(">>> login DAO 진입");
		return sql.selectOne(NS+"login", mvo2);
	}

	@Override
	public int lastLogin(String id2) {
		log.info(">>> logout DAO 진입");
		int isOk = sql.update(NS+"logout", id2);
		if(isOk >0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int update(MemberVO mvo3) {
		log.info(">>> modify DAO 진입");
		int isOk = sql.update(NS+"mod", mvo3);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(String delid) {
		log.info(">>> delete DAO 진입");
		int isOk = sql.delete(NS+"del", delid);
		if(isOk >0 ) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<MemberVO> selectList() {
		log.info(">>>> list DAO 진입");
		return sql.selectList(NS+"list");
	}

}
