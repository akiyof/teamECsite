<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="./css/spring.css">
<link rel="stylesheet" href="./css/form.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/message.css">
<link rel="stylesheet" href="./css/page-title.css">
<link rel="stylesheet" href="./css/submit-btn.css">
<title>ユーザ情報入力</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>ユーザー情報入力画面</h1>

<!-- 姓の入力値がfalseのときに表示 -->
<s:if test="familyNameErrorMessageList!=null && familyNameErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
		<s:iterator value="familyNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<!-- 名の入力値がfalseのときに表示 -->
<s:if test="firstNameErrorMessageList!=null && firstNameErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
	<s:iterator value="firstNameErrorMessageList"><s:property /><br></s:iterator>
</div>
</div>
</s:if>

<!-- 姓かなの入力値がfalseのときに表示 -->
<s:if test="familyNameKanaErrorMessageList!=null && familyNameKanaErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
	<s:iterator value="familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<!-- 名かなの入力値がfalseのときに表示 -->
<s:if test="firstNameKanaErrorMessageList!=null && firstNameKanaErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
	<s:iterator value="firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<!-- メールアドレスの入力値がfalseのときに表示 -->
<s:if test="emailErrorMessageList!=null && emailErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
	<s:iterator value="emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<!-- ユーザーIDの入力値がfalseのときに表示 -->
<s:if test="userIdErrorMessageList!=null && userIdErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
	<s:iterator value="userIdErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<!-- パスワードの入力値がfalseのときに表示 -->
<s:if test="passwordErrorMessageList!=null && passwordErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
	<s:iterator value="passwordErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<!-- ユーザーがすでに存在しているときに表示 -->
<!-- 「使用できないユーザーIDです。」 -->
<s:if test="isExistsUserErrorMessage!=null && !isExistsUserErrorMessage.isEmpty()">
	<div class="error">
	<div class="error-message">
	<s:iterator value="isExistsUserErrorMessage"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>

<s:form action="CreateUserConfirmAction">

<table class="vertical-list-table">
<tr>
	<th scope="row">姓</th>
	<td><s:textfield name="familyName" value="%{#session.familyName}" placeholder="姓" class="txt" /></td>
</tr>
<tr>
	<th scope="row">名</th>
	<td><s:textfield name="firstName" value="%{#session.firstName}" placeholder="名" class="txt" /></td>
</tr>
<tr>
	<th scope="row">姓ふりがな</th>
	<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" placeholder="姓ふりがな" class="txt" /></td>
</tr>
<tr>
	<th scope="row">名ふりがな</th>
	<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" placeholder="名ふりがな" class="txt" /></td>
</tr>
<tr>
	<th scope="row">性別</th>
	<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" placeholder="性別"/></td>
</tr>
<tr>
	<th scope="row">メールアドレス</th>
	<td><s:textfield name="email" value="%{#session.email}" placeholder="メールアドレス" class="txt" /></td>
</tr>
<tr>
	<th scope="row">ユーザーID</th>
	<td><s:textfield name="userId" value="%{#session.userIdForCreateUser}" placeholder="ユーザーID" class="txt" /></td>
</tr>
<tr>
	<th scope="row">パスワード</th>
	<td><s:password name="password" value="" placeholder="パスワード" class="txt" /></td>
</tr>
</table>
<div class="submit-btn-box">
	<s:submit value="確認" class="submit-btn" />
</div>
</s:form>
</div>
</body>
</html>