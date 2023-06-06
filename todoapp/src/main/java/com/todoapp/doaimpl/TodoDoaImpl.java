package com.todoapp.doaimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todoapp.connection.DBConnection;
import com.todoapp.dao.TodoDoa;
import com.todoapp.pojo.TodoData;

public class TodoDoaImpl implements TodoDoa
{

	@Override
	public boolean createTodo(TodoData todo) 
	{
		try(Connection con = DBConnection.getDatabaseConnection())
		{
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement("insert into todo (description,targetdate)"
					+ " values (?,?)");
			
			pst.setString(1, todo.getDescription());
			pst.setString(2, todo.getDate());
			
			int cnt = pst.executeUpdate();
			con.commit();
			
			if(cnt>0)
			{
				return true;
			}
			else
			{
				return false;
			}			
		}
		catch(NullPointerException e)
		{
			System.out.println("Connection to database failed");
			return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		//return false;
	}

	@Override
	public boolean updateTodo(TodoData todo) 
	{
		try(Connection con = DBConnection.getDatabaseConnection())
		{
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement("update todo set description = ? , targetdate = ?"
					+ " where todoid = ?");
			
			pst.setString(1, todo.getDescription());
			pst.setString(2, todo.getDate());
			pst.setInt(3, todo.getTodoid());
			
			int cnt = pst.executeUpdate();
			con.commit();
			
			if(cnt>0)
			{
				return true;
			}
			else
			{
				return false;
			}			
		}
		catch(NullPointerException e)
		{
			System.out.println("Connection to database failed");
			return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delTodo(int id) 
	{
		try(Connection con = DBConnection.getDatabaseConnection())
		{
			con.setAutoCommit(false);
			
			PreparedStatement pst = con.prepareStatement("delete from todo where "
					+ "todoid = ?");
			pst.setInt(1, id);
			
			int cnt = pst.executeUpdate();
			
			con.commit();
			
			if(cnt>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Connection to database failed");
			return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<TodoData> viewTodo() 
	{
		List<TodoData> lst = new ArrayList();
		
		try(Connection con = DBConnection.getDatabaseConnection())
		{
			PreparedStatement pst = con.prepareStatement("Select * from todo");
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					TodoData todo = new TodoData();
					todo.setTodoid(rs.getInt("todoid"));
					todo.setDescription(rs.getString("description"));
					todo.setDate(rs.getString("targetdate"));
					lst.add(todo);
				}
				return lst;
			}
			else
			{
				return lst;
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Connection to database failed");
			return lst;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return lst;
		}
	}
}
