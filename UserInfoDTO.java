package com.internousdev.spring.dto;

public class UserInfoDTO {

	/***/
	private int Id;
	/** ユーザーID */
	private String userId;
	/** パスワード */
	private String password;
	/** 姓 */
	private String familyName;
	/** 名 */
	private String firstName;
	/** 姓かな */
	private String familyNameKana;
	/** 名かな */
	private String firstNameKana;
	/** 性別 */
	private int sex;
	/** メールアドレス */
	private String email;
	/** ログインフラグ */
	private int logined;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLogined() {
		return logined;
	}

	public void setLogined(int logined) {
		this.logined = logined;
	}
}
