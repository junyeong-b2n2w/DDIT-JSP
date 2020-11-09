package com.jsp.mybatis;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class OracleMyBatisSqlSessionFactory implements SqlSessionFactory {

	private static SqlSessionFactory sqlSessionFactory;
	static {
		String config = "com/jsp/mybatis/sqlConfig/sqlConfig.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(config);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			/*reader.close();*/
			System.out.println("sqlSessionFactory 성공했습니다");
		}catch (Exception e) {
			System.out.println("sqlSessionFactory 실패했습니다");		
			e.printStackTrace();
		}
	}
	
	@Override
	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return sqlSessionFactory.getConfiguration();
	}

	@Override
	public SqlSession openSession() {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession();
	}

	@Override
	public SqlSession openSession(boolean autoCommit) {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession(autoCommit);
	}

	@Override
	public SqlSession openSession(Connection conn) {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession(conn);
	}

	@Override
	public SqlSession openSession(TransactionIsolationLevel transeLevel) {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession(transeLevel);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType) {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession(exeType);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType, boolean autoCommit) {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession(exeType,autoCommit);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType, TransactionIsolationLevel transeLevel) {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession(exeType,transeLevel);
	}

	@Override
	public SqlSession openSession(ExecutorType exeType, Connection conn) {
		// TODO Auto-generated method stub
		return sqlSessionFactory.openSession(exeType,conn);
	}

}
