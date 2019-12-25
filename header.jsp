<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<header>
<div class="header">
<div class="header-title">
	spring
</div>
<div class="header-menu">
<ul>
<s:form action="SearchItemAction" class="search-item-form">
	<s:if test='#session.mCategoryDTOList!=null && #session.mCategoryDTOList.size()>0'>
		<li><s:select name="categoryId" list="#session.mCategoryDTOList" listValue="categoryName" listKey="categoryId" class="cs-div" id="categoryId"/></li>
	</s:if>
	<li><s:textfield name="keywords" class="txt-keywords" placeholder="検索ワード"/></li>
	<li><s:submit value="商品検索" class="submit-btn"/></li>
</s:form>

<s:if test="#session.loginFlg==1">
<s:form action="LogoutAction">
	<li><s:submit value="ログアウト" class="submit-btn"/></li>
</s:form>
</s:if>

<s:else>
<s:form action="GoLoginAction">
	<li><s:submit value="ログイン" class="submit-btn"/></li>
</s:form>
</s:else>

<s:form action="CartAction">
	<li><s:submit value="カート" class="submit-btn"/></li>
</s:form>

<s:if test="#session.loginFlg==1">
<s:form action="MyPageAction">
	<li><s:submit value="マイページ" class="submit-btn"/></li>
</s:form>
</s:if>

</ul>
</div>
</div>
</header>
</html>