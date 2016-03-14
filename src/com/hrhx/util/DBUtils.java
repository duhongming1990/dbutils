package com.hrhx.util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
public class DBUtils {
	
	//数据源配置
	private static final String DATA_SOURCE="java:EFLOWSource"; 
	private DataSource dataSource=this.getDataSource();
	
	/**
	*ArrayHandler：把结果集中的第一行数据转成对象数组。
	*ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
	*BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
	*BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
	*ColumnListHandler：将结果集中某一列的数据存放到List中。
	*KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key。
	*MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
	*MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
	 */
	
	/**
	 * 得到第一行数据，类型List<Object>
	 */
	public List<Object> getOneByArray(String sql) throws SQLException{
		 QueryRunner qr = new QueryRunner(dataSource);
		 Object result[] = (Object[]) qr.query(sql, new ArrayHandler());
		 return Arrays.asList(result);
	}

	/**
	 * 得到每一行数据，类型List<Array>
	 */
	public List<Object[]> getAllByArray(String sql) throws SQLException{
         QueryRunner qr = new QueryRunner(dataSource);
         List<Object[]> list = (List<Object[]>) qr.query(sql, new ArrayListHandler());
         return list;
     }
	
	/**
	 * 得到第一行数据，类型Map<String,Object>
	 */
	public Map<String,Object> getOneByMapHandler(String sql) throws SQLException{
         QueryRunner qr = new QueryRunner(dataSource);
         Map<String,Object> map = (Map<String,Object>) qr.query(sql, new MapHandler());
         return map;
     }
	
	/**
	 * 得到每一行数据，类型List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getAllMapListHandler(String sql) throws SQLException{
         QueryRunner qr = new QueryRunner(dataSource);
         List<Map<String,Object>> list = (List<Map<String,Object>>) qr.query(sql, new MapListHandler());
         return list;

     }
		
	/**
	 * 得到第一行数据，类型Bean.class
	 */
	@SuppressWarnings("rawtypes")
	public <T> T find(String sql,final Class<T> type) throws SQLException {
        QueryRunner qr = new QueryRunner(dataSource);
        @SuppressWarnings("unchecked")
		T t = (T) qr.query(sql,new BeanHandler(type));
        return t;
     }
	 
	 /**
	  * 得到每一行数据，类型List<Bean.class>
	  */
	 @SuppressWarnings("rawtypes")
	 public <T>List<T> getAll(String sql,final Class<T> type) throws SQLException {
         QueryRunner qr = new QueryRunner(dataSource);
         @SuppressWarnings("unchecked")
         List<T> list = (List<T>) qr.query(sql, new BeanListHandler(type));
         return list;
     }
	
	/**
	 * 得到总条数
	 */
	@SuppressWarnings("rawtypes")
    public Integer getScalarHandler(String sql) throws SQLException{
        QueryRunner qr = new QueryRunner(dataSource);
        @SuppressWarnings("unchecked")
		Integer count = qr.query(sql, new ScalarHandler(1));
        return count;
    }
    
	
	//获取数据源
    public DataSource getDataSource(){
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
			return ds;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
    
    //获取连接
    public static Connection getConnection(){
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
			return ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
}
