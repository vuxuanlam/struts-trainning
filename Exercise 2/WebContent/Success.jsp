<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html xhtml="true">

<head>
<title><bean:message key="exercise02.successpage.title" /></title>
<html:base />
</head>

<body>
	<div align="center">
		<h2>
			<bean:message key="exercise02.successpage.title" />
			<bean:write name="CustomerForm" property="firstName" />
			<bean:write name="CustomerForm" property="lastName" />
		</h2>
		<h3>
			<bean:message key="exercise02.successpage.message" />
		</h3>
		<p />
		<html:img srcKey="image.beerchug" altKey="image.beerchug.alttext"
			bundle="bundle.image" />
		<BR />
		<html:link page="/CustomerForm.jsp">Go Back</html:link>

		<p />




	</div>
</body>

</html:html>