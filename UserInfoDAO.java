package com.internousdev.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.spring.dto.UserInfoDTO;
import com.internousdev.spring.util.DBConnector;

//** データベースにユーザーを登録 */
public class UserInfoDAO {

	public int createUser(String familyName, String firstName, String familyNamekana, String firstNamekana, String sex,
			String email, String userId, String password) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "INSERT INTO user_info(user_id,password,family_name,first_name,family_name_kana,first_name_kana,sex,email,status,logined,regist_date,update_date)VALUES(?,?,?,?,?,?,?,?,?,?,now(),now())";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNamekana);
			ps.setString(6, firstNamekana);
			ps.setString(7, sex);
			ps.setString(8, email);
			ps.setInt(9, 0);
			ps.setInt(10, 1);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return count;
	}

	// ** データベースに格納してあるユーザーと一致しているか参照 */
	public UserInfoDTO getLoginUserInfo(String userId, String password) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info where user_id =? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, userId);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));

				if (rs.getString("user_id").equals(null)) {
					userInfoDTO.setLogined(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return userInfoDTO;
	}

	// ** マイページに表示するユーザー情報をユーザーIDに紐づけて取得 */
	public UserInfoDTO getMypageUserInfo(String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info where user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return userInfoDTO;
	}

	// **パスワードの再設定:パスワード更新*/
	public int updatePasswordUserInfo(String userId, String password) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "UPDATE user_info SET password=? where user_id=?";

		int result = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, userId);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

	public boolean isExistsUserInfo(String userId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("count") > 0) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

	public boolean isExistsUserInfo(String userId, String password) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id=? and password=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("count") > 0) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
