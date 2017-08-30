package myPackage;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Menu {
	private static Menu instance = new Menu();

	public static Menu getInstance() {
		return instance;
	}

	public Menu() {

	}

	private String jdbcUrl = "jdbc:mysql://localhost:3306/tastyorder?useUnicode=true&characterEncoding=utf8"; // MySQL 계정 "jdbc:mysql://localhost:3306/DB이름"
	private String dbId = "root"; // MySQL 계정 "로컬일 경우 root"
	private String dbPw = "1111"; // 비밀번호 "mysql 설치 시 설정한 비밀번호"
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt2 = null;
	private ResultSet rs = null;
	private String sql = "";
	private String sql2 = "";
	String returns = "";
	String returns2 = "";
	
	// 데이터베이스와 통신하기 위한 코드가 들어있는 메서드
	public String getTopcategory(String businessnumber) {
		  try {
			//System.out.println("연결시작");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select * from menu_topcategory where businessnumber="+businessnumber+";";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder        = factory.newDocumentBuilder();
			Document doc                   = builder.newDocument();
			Element results = doc.createElement("Results");
			doc.appendChild(results);
			 
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount           = rsmd.getColumnCount();
			 
			while (rs.next())
			{
				Element row = doc.createElement("Row");
			    results.appendChild(row);
			 
			    for (int i = 1; i <= colCount; i++)
			    {
			    	String columnName = rsmd.getColumnName(i);
			        Object value      = rs.getObject(i);
			        
			        Element node      = doc.createElement(columnName);
			        node.appendChild(doc.createTextNode(value.toString()));
			        row.appendChild(node);
			        //System.out.println(columnName);
			        //System.out.println(value);
			     }			
			  }
			
		    DOMSource domSource = new DOMSource(doc);
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    StringWriter sw = new StringWriter();
		    StreamResult sr = new StreamResult(sw);
		    transformer.transform(domSource, sr);
		    
		    conn.close();
			//System.out.println(sw.toString());
			//System.out.println("연결완료");
			returns= sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
			if (pstmt2 != null)try {pstmt2.close();} catch (SQLException ex) {}
			if (rs != null)try {rs.close();} catch (SQLException ex) {}
		}
		
		return returns;
	}
	
	public String getCategory(String businessnumber, String topcategoryname) {
		  try {
			//System.out.println("연결시작");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select * from menu_category"
					+ " where businessnumber='"+businessnumber+"' && topcategoryname='"+topcategoryname+"';";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder        = factory.newDocumentBuilder();
			Document doc                   = builder.newDocument();
			Element results = doc.createElement("Results");
			doc.appendChild(results);
			 
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount           = rsmd.getColumnCount();
			 
			while (rs.next())
			{
				Element row = doc.createElement("Row");
			    results.appendChild(row);
			 
			    for (int i = 1; i <= colCount; i++)
			    {
			    	String columnName = rsmd.getColumnName(i);
			        Object value      = rs.getObject(i);
			        
			        Element node      = doc.createElement(columnName);
			        node.appendChild(doc.createTextNode(value.toString()));
			        row.appendChild(node);
			        //System.out.println(columnName);
			        //System.out.println(value);
			     }			
			  }
			
		    DOMSource domSource = new DOMSource(doc);
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    StringWriter sw = new StringWriter();
		    StreamResult sr = new StreamResult(sw);
		    transformer.transform(domSource, sr);
		    
		    conn.close();
		    
			//System.out.println(sw.toString());
			//System.out.println("연결완료");
			
			returns= sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
			if (pstmt2 != null)try {pstmt2.close();} catch (SQLException ex) {}
			if (rs != null)try {rs.close();} catch (SQLException ex) {}
		}
		
		return returns;
	}
	
	public String getItem(String businessnumber, String topcategoryname, String categoryname) {
		  try {
			//System.out.println("연결시작");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select * from menu_item"
					+ " where businessnumber='"+businessnumber+"' && topcategoryname='"+topcategoryname+"'"
							+ " && categoryname='"+categoryname+"';";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder        = factory.newDocumentBuilder();
			Document doc                   = builder.newDocument();
			Element results = doc.createElement("Results");
			doc.appendChild(results);
			 
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount           = rsmd.getColumnCount();
			 
			while (rs.next())
			{
				Element row = doc.createElement("Row");
			    results.appendChild(row);
			 
			    for (int i = 1; i <= colCount; i++)
			    {
			    	String columnName = rsmd.getColumnName(i);
			        Object value      = rs.getObject(i);
			        
			        Element node      = doc.createElement(columnName);
			        if(value!=null){
			        	node.appendChild(doc.createTextNode(value.toString()));
			        }
			        row.appendChild(node);
			        //System.out.println(columnName);
			        //System.out.println(value);
			     }			
			  }
			
		    DOMSource domSource = new DOMSource(doc);
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    StringWriter sw = new StringWriter();
		    StreamResult sr = new StreamResult(sw);
		    transformer.transform(domSource, sr);
		    
		    conn.close();
		    
			//System.out.println(sw.toString());
			//System.out.println("연결완료");
			
			returns= sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
			if (pstmt2 != null)try {pstmt2.close();} catch (SQLException ex) {}
			if (rs != null)try {rs.close();} catch (SQLException ex) {}
		}
		
		return returns;
	}
}
