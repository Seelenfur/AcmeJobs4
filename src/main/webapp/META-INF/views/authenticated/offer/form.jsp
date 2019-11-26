<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.offer.form.label.ticker" path="ticker" placeholder="OABCD-12345"/>
	<acme:form-textbox code="authenticated.offer.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.offer.form.label.moment" path="moment"/>
	<acme:form-moment code="authenticated.offer.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.offer.form.label.description" path="description"/>
	<acme:form-money code="authenticated.offer.form.label.minMoney" path="minMoney"/>
	<acme:form-money code="authenticated.offer.form.label.maxMoney" path="maxMoney"/>
	
	<acme:form-return code="authenticated.offer.form.button.return"/>
</acme:form>