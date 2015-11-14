<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>

<html-el:html xhtml="true">

<head>
	<title><bean:message key="successpage.title"/></title>
	<html-el:base/>
	<link rel="stylesheet" href="css/struts-training.css" charset="ISO-8859-1" type="text/css"/>
</head>

<body background="images/blueAndWhiteBackground.gif">

	<p/><p/><p/><p/><p/>
	
<div align="center">
    <h2><bean:message key="successpage.title" /> 
    	<c:out value='${CustomerForm.firstName}' />
	    <c:out value='${CustomerForm.lastName}' />
    </h2>
    <h3><bean:message key="successpage.message" /></h3>
    
    <%-- If Customer has opted to recieve mails, put a thank you --%>
    <c:if test='${CustomerForm.receiveEmail == true}' >
    	<bean:message key="successpage.thanks"/>
    	<br/>
    	<bean:message key="successpage.emaildest"/> <c:out value='${CustomerForm.emailAddress}' />
    </c:if>
    
    <p/><p/>
    
    <html-el:img srcKey="image.beerchug" altKey="image.beerchug.alttext" bundle="bundle.image"/>
    
    <p/><p/>
    
    <html-el:link page="/showCustomerForm.do">Go Back</html-el:link>
</body>

</html-el:html>