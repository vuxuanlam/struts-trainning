<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:html xhtml="true">

<head>
	<title><tiles:getAsString name="title"/></title>
	<html:base/>
	<link rel="stylesheet" href="css/struts-training.css" charset="ISO-8859-1" type="text/css"/>
</head>

<body background="images/blueAndWhiteBackground.gif">

<TABLE border="0" width="100%" cellspacing="5">
    <tr><td><tiles:insert attribute="header"/></td></tr>
    <tr><td><tiles:insert attribute="body"/></td></tr>
    <tr><td><hr></td></tr>
    <tr><td><tiles:insert attribute="footer"/></td></tr>
</TABLE>

</body>

</html:html>