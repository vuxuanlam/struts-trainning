<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>

<html:html xhtml="true">

<head>
	<title><bean:message key="formpage.title"/></title>
	<html:base/>
	<link rel="stylesheet" href="css/struts-training.css" charset="ISO-8859-1" type="text/css"/>
</head>

<body background="images/blueAndWhiteBackground.gif">
	<div align="center">
		<br/><br/><br/>
		<h2><bean:message key="searchpage.title"/></h2>

		<html:errors/>

		<html:form action="/submitCustomerSearchForm" focus="lastName" method="GET">

		  	<table width="60%">
		  		<tr>
					<td align="right"><bean:message key="prompt.customer.lastname"/>:</td>
					<td align="left"><html:text property="lastName" size="16" maxlength="25"/></td>
					<td align="left"><html:image property="searchButton" srcKey="image.search" altKey="image.search.alttext" bundle="bundle.image"/></td>
				</tr>
			</table>
	  	</html:form>
	</div>

	<c:if test='${not empty CUSTOMER_SUMMARY_OBJECTS}'>
		<div align="center">
			<table class="list">
				<thead class="list">
					<tr class="list">
						<td class="list"><bean:message key="prompt.customer.firstname" /></td>
						<td class="list"><bean:message key="prompt.customer.lastname" /></td>
						<td class="list"><bean:message key="prompt.customer.email"/></td>
					</tr>
				</thead>

				<%
					int i = 1;
					String claz = null;
				%>

				<c:forEach var='customer' items='${CUSTOMER_SUMMARY_OBJECTS}'>
					<% claz = (i%2 != 0) ? "odd" : "even"; %>
					<tr class="<%= claz %>">
						<td><c:out value='${customer.firstName}' /> </td>
						<td><c:out value='${customer.lastName}' /> </td>
						<td><c:out value='${customer.emailAddress}' /> </td>
					</tr>
					<% i++; %>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<c:if test='${empty CUSTOMER_SUMMARY_OBJECTS}'>
		<div align="center"><bean:message key="prompt.noresults"/> "<c:out value='${CustomerSearchForm.lastName}'/>"</div>
	</c:if>

</body>

</html:html>