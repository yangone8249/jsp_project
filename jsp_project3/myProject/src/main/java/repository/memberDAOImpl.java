package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.conf.ConnectionUrl.Type;

import domain.memberVO;
import orm.DatabaseBuilder;
import service.memberServiceImpl;

public class memberDAOImpl implements memberDAO{
	private static final Logger log = LoggerFactory.getLogger(memberServiceImpl.class);
	private SqlSession sql;
	private String NS = "memberMapper.";
	
	public memberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public void insert(memberVO mvo) {
		log.info("DAOImpl 진입! : insert");
		sql.insert(NS+"insert",mvo);
		sql.commit();
	}

	@Override
	public int search(memberVO mvo) {
		try {
			memberVO value = sql.selectOne(NS+"search", mvo);
			log.info("value : "+value);
			log.info("id : "+value.getId());
			log.info("password : "+value.getPassword());
			log.info("mvoId : "+mvo.getId());
			log.info("mvoPw : "+mvo.getPassword());
			System.out.println(value.getId().getClass().getName());
			System.out.println(mvo.getId().getClass().getName());

			if((value.getId().equals(mvo.getId())) && (value.getPassword().equals(mvo.getPassword()))) {
				log.info("리턴 1");
				sql.update(NS+"lastLogin", mvo);
				sql.commit();
				return 1;
			}
		} catch (Exception e) {
			log.info("리턴 0");
			e.printStackTrace();
	
		}
		
		return 0;
	}

	@Override
	public memberVO findMvo(memberVO mvo) {
		
		return sql.selectOne(NS+"findMvo",mvo );
	}

	@Override
	public List<memberVO> list() {
		return sql.selectList(NS+"list");
	}

	@Override
	public void remove(String parameter) {
		sql.delete(NS+"remove",parameter);
		sql.commit();
	}

}
