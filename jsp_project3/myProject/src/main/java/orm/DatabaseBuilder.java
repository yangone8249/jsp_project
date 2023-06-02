package orm;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class DatabaseBuilder {
	private static Logger log = LoggerFactory.getLogger(DatabaseBuilder.class);
	private static SqlSessionFactory factory;
	private static final String config = "orm/MybatisConfig.xml";
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(config));
		} catch (IOException e) {
			log.info("Mybatis 설정오류");
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
