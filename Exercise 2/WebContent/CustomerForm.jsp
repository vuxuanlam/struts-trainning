<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html xhtml="true">

<head>
<title><bean:message key="exercise02.formpage.title" /></title>
<html:base />
</head>

<body>
	<div align="center">
		<h2>
			<bean:message key="exercise02.formpage.title" />
		</h2>

		<html:errors />

		<html:form action="/submitCustomerForm" method="GET">

			<bean:message key="prompt.customer.firstname" />:
		<html:text property="firstName" size="16" maxlength="16" />
			<BR />

			<bean:message key="prompt.customer.lastname" />:
		<html:text property="lastName" size="16" maxlength="16" />
			<BR />
			<bean:message key="prompt.customer.city" />:
		<html:text property="address.city" size="16" />
			<BR />
			<bean:message key="prompt.customer.state" />:
		<html:text property="address.state" size="16" />
			<BR />
			<bean:message key="prompt.customer.zip" />:
		<html:text property="address.zip" size="16" />
			<BR />
			<BR />
			<BR />
			<html:checkbox property="receiveEmail">Receive Email</html:checkbox>
			<html:radio property="preferredCarrier" value="UPS">UPS</html:radio>
			<html:radio property="preferredCarrier" value="USP">USPS</html:radio>
			<html:radio property="preferredCarrier" value="FDX">FedEx</html:radio>
			<html:select property="address.state">
				<html:option value="NA">--Select One--</html:option>
				<html:options collection="STRUTS_EXAMPLE_STATES" property="value"
					labelProperty="label" />
			</html:select>
			<BR>
			<BR>
			<html:image property="save" srcKey="image.save"
				altKey="image.save.alttext" bundle="bundle.image" />

			<html:image property="cancel" srcKey="image.cancel"
				altKey="image.cancel.alttext" bundle="bundle.image" />
		</html:form>
	</div>
</body>

</html:html>