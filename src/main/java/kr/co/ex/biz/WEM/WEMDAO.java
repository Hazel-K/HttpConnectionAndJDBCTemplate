package kr.co.ex.biz.WEM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.ex.biz.JDBCTemplate.JDBCSelectTemplate;
import kr.co.ex.biz.JDBCTemplate.JDBCTemplateImpl;
import kr.co.ex.biz.Util.DbUtils;

public class WEMDAO {
	public List<HashMap<String, Object>> selectTest() {
		final List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		Connection con = DbUtils.getCon("ORACLE", WEMConstant.REALCON, WEMConstant.REALID, WEMConstant.REALSECRET);
		
		JDBCTemplateImpl.executeQuery(con, WEMConstant.REALSQL, new JDBCSelectTemplate() {
			public void prepared(PreparedStatement ps) throws SQLException {}
			
			public void executeQuery(ResultSet rs) throws SQLException {
				ResultSetMetaData metaData = rs.getMetaData();
				int colSize = metaData.getColumnCount();
				while(rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					for(int i = 0; i < colSize; i++) {
						String column = metaData.getColumnName(i + 1);
						map.put(column, rs.getString(column));
						
					}
					result.add(map);
				}
			}
		});
		
		return result;
	}
}