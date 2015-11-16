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
<script>
function showalert()
{
	alert("Are you sure you dont want to receive email alerts");
}
</script>
<body background="images/blueAndWhiteBackground.gif">
<div align="center">
	<br/><br/><br/>
	<h2><bean:message key="formpage.title"/></h2>

	<html:errors/>

	<html:form action="/submitCustomerForm" focus="firstName" method="GET">

  	<table width="60%">
  		<tr>
			<td align="right"><bean:message key="prompt.customer.firstname" />:</td>
			<td align="left"><html:text property="firstName" size="16" maxlength="25"
											tabindex="1"/>
			</td>
		</tr>

  		<tr>
			<td align="right"><bean:message key="prompt.customer.lastname"/>:</td>
			<td align="left"><html:text property="lastName" size="16" maxlength="25"/></td>
		</tr>

  		<tr>
			<td align="right"><bean:message key="prompt.customer.email"/>:</td>
			<td align="left"><html:text styleClass="mytxtbox" property="emailAddress" size="16" maxlength="30"/></td>
		</tr>

  		<tr>
			<td align="right"><bean:message key="prompt.customer.preferredCarrier"/>:</td>
			<td align="left">
				<c:forEach var='carrier' items='${STRUTS_EXAMPLE_CARRIERS}'>
					<html-el:radio property="preferredCarrier" value="${carrier.value}"/>
					<c:out value='${carrier.label}' /> &nbsp;
				</c:forEach>
			</td>
		</tr>

		<tr>
			<td align="right"><bean:message key="prompt.customer.address.city"/>:</td>
			<td align="left"><html:text property="address.city" size="16" maxlength="16" tabindex="3"/></td>
		</tr>

		<tr>
			<td align="right"><bean:message key="prompt.customer.address.state"/>:</td>
			<td align="left">
				<html:select property="address.state">
					<html:options collection="STRUTS_EXAMPLE_STATES"
									property="value"
									labelProperty="label" />
				</html:select>
			</td>
		</tr>

  		<tr>
			<td align="right"><bean:message key="prompt.customer.address.zip" />:</td>
			<td align="left"><html:text property="address.zip" size="16" maxlength="16" tabindex="2"/></td>
		</tr>

		<tr>
			<td align="right"><html:checkbox property="receiveEmail" onclick="showalert()"/></td>
			<td align="left"><bean:message key="prompt.customer.receiveEmail"/>:</td>
		</tr>

		<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
		<tr>
			<td align="center"><html:image property="save" srcKey="image.save" altKey="image.save.alttext" bundle="bundle.image"/></td>
			<td align="center"><html:image property="cancel" srcKey="image.cancel" altKey="image.cancel.alttext" bundle="bundle.image"/></td>
		</tr>
	</table>
  	</html:form>
</div>
</body>

</html:html>