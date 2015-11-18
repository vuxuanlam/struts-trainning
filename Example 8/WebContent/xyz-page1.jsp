<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html xhtml="true">

<head>
	<title><bean:message key="page1.title"/></title>
	<html:base/>
	<link rel="stylesheet" href="css/struts-training.css" charset="ISO-8859-1" type="text/css"/>
</head>

<body background="images/blueAndWhiteBackground.gif">
	<br/><br/><br/><br/><br/>
    <div align="center">
    	<html:link page="/page2.do">Go to Page 2</html:link>
    	<br/><br/><br/><br/><br/>
    	<html:link forward="gotoDefaultModule">Go to Default Module</html:link>
    </div>
</body>

</html:html>