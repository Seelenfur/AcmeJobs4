<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="auditor.auditorRecord.form.label.reference" path="reference" />
	<acme:form-select code="auditor.auditorRecord.form.label.status" path="status">
		<jstl:choose>
			<jstl:when test="${command == 'create'}">
				<acme:form-option code="auditor.auditorRecord.form.label.status.draft" value="DRAFT" selected="true" />
				<acme:form-option code="auditor.auditorRecord.form.label.status.published" value="PUBLISHED" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:forEach var="status" items="<%=acme.entities.jobs.JobStatus.values()%>">
					<acme:form-option code="auditor.auditorRecord.form.label.status.${status.name().toLowerCase()}" value="${status.name()}"
						selected="${(requestScope['status'] == status) ? 'true' : 'false'}" />
				</jstl:forEach>
			</jstl:otherwise>
		</jstl:choose>
	</acme:form-select>
	<acme:form-textbox code="auditor.auditorRecord.form.label.title" path="title" />
	<acme:form-moment code="auditor.auditorRecord.form.label.deadline" path="deadline" />
	<acme:form-money code="auditor.auditorRecord.form.label.salary" path="salary" />
	<acme:form-url code="auditor.auditorRecord.form.label.moreInfo" path="moreInfo" />
	<acme:form-textarea code="auditor.auditorRecord.form.label.descriptor.description" path="descriptor.description" />
	<acme:form-submit test="${command == 'show' && requestScope['status'] == 'DRAFT'}" code="auditor.auditorRecord.form.button.update"
		action="update" />
	<acme:form-submit test="${command == 'update'}" code="auditor.auditorRecord.form.button.update" action="update" />
	<acme:form-submit code="auditor.auditorRecord.form.button.list-duties"
		action="/auditor/duty/list?id=${id}" method="get" />
	<acme:form-return code="auditor.auditorRecord.form.button.return" />
</acme:form>
