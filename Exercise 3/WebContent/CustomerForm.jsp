<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el"%>
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

		<html:form action="/submitCustomerForm" focus="firstName" method="GET">

			<bean:message key="prompt.customer.firstname" />:
		<html:text property="firstName" size="16" maxlength="16" />
			<BR />
			<bean:message key="prompt.customer.address1" />:
		<html:text property="address.address1" size="16" tabindex="4" />
			<BR />
			<bean:message key="prompt.customer.address2" />:
		<html:text property="address.address2" size="16" tabindex="5" />
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
			<bean:message key="prompt.customer.email" />:
		<html:text property="emailAddress" size="16" tabindex="1"
				styleClass="mytxtbox" />
			<BR />
			<BR />
			<BR />
			<html:checkbox property="receiveEmail"  onclick="showalert()">Receive Email </html:checkbox>
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
<script>
	function showalert() {
		alert("Are you sure you dont want to receive email alerts");
	}
</script>