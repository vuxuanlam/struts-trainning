<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<html-el:html xhtml="true">

<head>
<title><bean:message key="exercise02.successpage.title" /></title>
<html:base />
</head>

<body>
	<div align="center">
		<h2>
			<bean:message key="exercise02.successpage.title" />
			<c:out value='${CustomerForm.firstName}' />
			<c:out value='${CustomerForm.lastName}' />
		</h2>
		<h3>
			<bean:message key="exercise02.successpage.message" />
		</h3>
		<p>
		<c:if test='${CustomerForm.receiveEmail == true}'>
			<bean:message key="successpage.thanks" />
			<br />
			<bean:message key="successpage.emaildest" />
			<c:out value='${CustomerForm.emailAddress}' />
		</c:if>

		<html-el:img srcKey="image.beerchug" altKey="image.beerchug.alttext"
			bundle="bundle.image" />
		<BR />
		<html-el:link page="/CustomerForm.jsp">Go Back</html-el:link>

		</p>




	</div>
</body>

</html-el:html>