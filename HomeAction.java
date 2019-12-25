package com.internousdev.spring.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.spring.dao.McategoryDAO;
import com.internousdev.spring.dto.McategoryDTO;
import com.internousdev.spring.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() throws SQLException {

		// ↓ログインフラグの保持状況を確認
		// ログインフラグのセッションが存在しなければ、
		// loginFlgセッションに0を代入＝未ログインとしてログインフラグ保持
		if (!session.containsKey("loginFlg")) {
			session.put("loginFlg", 0);
		}

		// セッションからログインフラグをインスタンス化
		// 未ログイン状態(loginFlg != 1)かつ、
		// 仮ユーザーID未保持＝tempUserIdセッションが存在しないなら、
		// tempUserIdセッションに16桁のランダムな数字を代入
		int loginFlg = Integer.parseInt(String.valueOf(session.get("loginFlg")));
		if (loginFlg == 0) {
			if (!session.containsKey("tempUserId")) {
				CommonUtility commonUtility = new CommonUtility();
				session.put("tempUserId", commonUtility.getRamdomValue());
			}
		}

		// マスターカテゴリーテーブルのセッションを保持していなければ、
		// McategoryDAOインスタンスのgetMcategoryInfoメソッドによって
		// テーブル情報をリスト化し、mcategoryListとしてセッションに保存
		if (!session.containsKey("mCategoryList")) {
			McategoryDAO mCategoryDAO = new McategoryDAO();
			List<McategoryDTO> mcategoryDTOList = new ArrayList<McategoryDTO>();
			mcategoryDTOList = mCategoryDAO.getMcategoryInfo();
			session.put("mCategoryDTOList", mcategoryDTOList);
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
