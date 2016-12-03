package com.sarav.donormgmttool;

import java.util.Date;
import java.util.List;
import java.sql.*;
import java.util.*;


public class DBImpl {
	String result = "";
	int resultcode;
	Date dat = new Date();
	String retval = "<b style=\"font-family: calibri; font-variant: small-caps; color: white\">Consolidated Effort as on "+dat+"</b>";
	public Connection con = null;
	
	public DBImpl() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedm","root","secure");
	}
        
        /*Get titles*/
        public HashMap getid_titles(String CATE)
        {
            HashMap retval = new HashMap();

		try {

		PreparedStatement st = con.prepareStatement("select postid, title from blogpost_repo where category = ?");
		st.setString(1, CATE);
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    String ID = rs.getString("postid");
                    String title = rs.getString("title");
                    retval.put(title, ID);
                }
                }
                catch (SQLException e) {

		e.printStackTrace();
	}
            System.out.println("DEBUG ENTRY IS " +retval.get("1"));
            return retval;
        }
        
        
        public HashMap getid_titles_forcategory(String CATE)
        {
            HashMap retval = new HashMap();

		try {

                    
                
		PreparedStatement st = con.prepareStatement("select postid, title from blogpost_repo where category = ?");
		st.setString(1, CATE);
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    String ID = rs.getString("postid");
                    String title = rs.getString("title");
                    retval.put(ID,title);
                }
                }
                catch (SQLException e) {

		e.printStackTrace();
	}
            System.out.println("DEBUG ENTRY IS " +retval.get("1"));
            return retval;
        }

	public ArrayList<String> get_categories()
        {
           ArrayList<String> categories = new ArrayList();
           
           try {

		PreparedStatement st = con.prepareStatement("select category from categories_repo");
		
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    String category = rs.getString("category");
                    categories.add(category);
                    System.out.println("DEBUG"+category);
                }
                }
           catch (SQLException e) {

		e.printStackTrace();
	}
        return categories;
        
        
        }
        
        public ArrayList<donation> get_donations()
        {
           ArrayList<donation> donations = new ArrayList();
           
           try {

		PreparedStatement st = con.prepareStatement("select donorname,donationid,donoremail,amount,donationdate,mode,chequeno,transid from donation_repo");
		
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    donation d = new donation(
                            rs.getString("donorname"),rs.getInt("donationid"),rs.getString("donoremail"),rs.getFloat("amount"),rs.getDate("donationdate"),rs.getString("mode"),rs.getString("chequeno"),rs.getString("transid"));
                    donations.add(d);
                    
                    /*
                    String DID = rs.getString("donationid");
                    String EMAIL = rs.getString("donoremail");
                    String AMT = rs.getString("amount");
                    String DDT = rs.getString("donationdate");
                    String MOD = rs.getString("mode");
                    String CN = rs.getString("chequeno");
                    String TID = rs.getString("transid");
                    */
                    
                    System.out.println("DEBUG "+d.getChequeno());
                }
                }
           catch (SQLException e) {

		e.printStackTrace();
	}
           return donations;
        }
    
    public ArrayList<donation> get_donations_by_id(int did)
        {
           ArrayList<donation> donations = new ArrayList();
           
           try {

		PreparedStatement st = con.prepareStatement("select donorname,donationid,donoremail,amount,donationdate,mode,chequeno,transid from donation_repo where donationid=?");
                st.setInt(1, did);
		
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    donation d = new donation(
                            rs.getString("donorname"),rs.getInt("donationid"),rs.getString("donoremail"),rs.getFloat("amount"),rs.getDate("donationdate"),rs.getString("mode"),rs.getString("chequeno"),rs.getString("transid"));
                    donations.add(d);
                    
                    /*
                    String DID = rs.getString("donationid");
                    String EMAIL = rs.getString("donoremail");
                    String AMT = rs.getString("amount");
                    String DDT = rs.getString("donationdate");
                    String MOD = rs.getString("mode");
                    String CN = rs.getString("chequeno");
                    String TID = rs.getString("transid");
                    */
                    
                    System.out.println("DEBUG "+d.getChequeno());
                }
                }
           catch (SQLException e) {

		e.printStackTrace();
	}
           
        return donations;
        
        
        }
        
        
        
        public ArrayList<String> get_posts(String category)
        {
           ArrayList<String> posts = new ArrayList();
           
           try {

		PreparedStatement st = con.prepareStatement("select title from blogpost_repo where category=?");
		st.setString(1, category);
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    String title = rs.getString("title");
                    posts.add(title);
                    //System.out.println("DEBUG"+title);
                }
                }
           catch (SQLException e) {

		e.printStackTrace();
	}
        return posts;
        
        
        }
        
    
        
        public HashMap getcategory_id_titles()
        {
            HashMap<String, HashMap<String,String>> retval = new HashMap<String, HashMap<String,String>>();
            HashMap<String,String>  id_title=new HashMap();

		try {

		PreparedStatement st = con.prepareStatement("select category, postid, title from blogpost_repo");
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    String category = rs.getString("category");
                    String ID = rs.getString("postid");
                    String title = rs.getString("title");
                    
                    id_title.put(ID, title);
                    
                    retval.put(category ,id_title);
                }
                }
                catch (SQLException e) {

		e.printStackTrace();
	}
            //System.out.println("DEBUG ENTRY IS " +retval.get("1"));
            return retval;
        }
        
        public String getPostContent(String postid)
        {
            String content = "";
            try {

		PreparedStatement st = con.prepareStatement("select content from blogpost_repo where postid = ? ");
		
                st.setString(1, postid);
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    content = rs.getString("content");
                }
                }
                catch (SQLException e) {

		e.printStackTrace();
	}
            //System.out.println("DEBUG ENTRY IS " +retval.get("1"));
            return content;
        }
        
         public String gettitle(String postid)
        {
            String title = "";
            try {

		PreparedStatement st = con.prepareStatement("select title from blogpost_repo where postid = ? ");
		
                st.setString(1, postid);
                
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    title = rs.getString("title");
                }
                }
                catch (SQLException e) {

		e.printStackTrace();
	}
            //System.out.println("DEBUG ENTRY IS " +retval.get("1"));
            return title;
        }
        
         public HashMap getComments(String postid) 
         {
             HashMap<String,String>  auth_comment=new HashMap();
             
             try {

		PreparedStatement st = con.prepareStatement("select Author, Comment from comments_repo where postid=?");
		
                st.setString(1, postid);
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
                    String Author = rs.getString("Author");
                    String Comment = rs.getString("Comment");
                    
                    auth_comment.put(Author, Comment);
                    
                    
                }
                }
                catch (SQLException e) {

		e.printStackTrace();
	}
             
             return auth_comment;
         }
         
         public void insertcomment(String postid,String Author,String Comment) 
         {
             
             try {

		PreparedStatement st = con.prepareStatement("insert into comments_repo (postid,Author,Comment) values (?,?,?) ");
		
                st.setString(1, postid);
                st.setString(2, Author);
                st.setString(3, Comment);
		int row = st.executeUpdate();
                
                if (row > 0) {
                System.out.println("COMMENT HAS BEEN SUCCCESSFULLY INSERTED INTO DB RET CODE"+row);
                }
		
                }
                catch (SQLException e) {

		e.printStackTrace();
	}
             
             
         }
             
}
