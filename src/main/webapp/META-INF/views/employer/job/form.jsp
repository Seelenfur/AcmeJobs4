<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.job.form.label.reference" path="reference" />
	<acme:form-textbox code="employer.job.form.label.status" path="status" />
	<acme:form-textbox code="employer.job.form.label.title" path="title" />
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline" />
	<acme:form-money code="employer.job.form.label.salary" path="salary" />
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo" />
	<acme:form-textarea code="employer.job.form.label.descriptor.description" path="descriptor.description" />

	<c:forEach items="$requestScope{descriptor.duties}" var="duty" varStatus="varStatus">
		<acme:form-panel code="employer.job.form.label.descriptor.duty">
			<acme:form-textbox code="employer.job.form.label.descriptor.duty.title" path="descriptor.duties[${varStatus.index}].title" />
			<acme:form-textarea code="employer.job.form.label.descriptor.duty.description"
				path="descriptor.duties[${varStatus.index}].description" />
			<acme:form-double code="employer.job.form.label.descriptor.duty.weekPercentage"
				path="descriptor.duties[${varStatus.index}].weekPercentage" />
		</acme:form-panel>
	</c:forEach>

	<acme:form-return code="employer.job.form.button.return" />
</acme:form>
