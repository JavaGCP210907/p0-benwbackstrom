package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.AccountType;
import com.revature.utils.ConnectionUtil;

public class AccountTypeDao implements AccountTypeDaoInterface {

	@Override
	public void updateInterestRate(String type, int r) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update accounttypes set interest_rate = ? where type_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, r);
			ps.setString(2, type);
			
			ps.executeUpdate();
			
			System.out.println("Interest rate changed to " + r +"%");
			
		}catch(SQLException e) {
			System.out.println("Could not update interest rate");
			e.printStackTrace();
		}//end try/catch

	}// end method

	@Override
	public List<AccountType> getAccountTypes() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from accounttypes";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<AccountType> aTypeList = new ArrayList<>();
			
			while(rs.next()) {
				AccountType at = new AccountType(
						rs.getInt("type_id"),
						rs.getString("type_name"),
						rs.getInt("interest_rate")
						);
				
				aTypeList.add(at);
				
			}//end while
			
			return aTypeList;
			
		}catch(SQLException e) {
			System.out.println("Something went wrong with your database!");
			e.printStackTrace();
		}//end try/catch
		
		return null;
	}//end method

}
