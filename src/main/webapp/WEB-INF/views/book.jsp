<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%><!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Users</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css'/>">
	</head>
	<body>
		<h1>Books</h1>
		<form:form action="" method="post" modelAttribute="bookCommand">
			<fieldset class="fieldcontainer">
				<legend>New Book</legend>

				<div class="block">
					<div class="field">
						<form:label for="name" path="name">Name:</form:label>
						<form:errors path="name" cssClass="errors" />
						<form:input path="name" />
					</div>
				</div>

				<div class="field vertical">
					<input type="submit" value="Create new book">
				</div>

			</fieldset>
		</form:form>
		<form:form action="" method="put" modelAttribute="books">
			<table>
				<thead><tr><th><input type="checkbox" class="toggleAll" /></th><th>Name</th></tr></thead>
				<tbody>
					<c:forEach var="bookEntry" items="${books.bookMap}" varStatus="row">
						<tr>
							<td>
								<form:input cssClass="disablable-hidden" disabled="${!bookEntry.value.selected}" path="bookMap[${bookEntry.key}].id" />
								<c:if test="${bookMap[bookEntry.key].selected}">
									<input type="checkbox" checked="checked" class="rowSelector" />
								</c:if>
								<c:if test="${!bookMap[bookEntry.key].selected}">
									<input type="checkbox" class="rowSelector" />
								</c:if>
							</td>
							<td>
								<form:errors path="bookMap[${bookEntry.key}].name" cssClass="errors" />
								<form:input disabled="${!bookEntry.value.selected}" path="bookMap[${bookEntry.key}].name" />
							</td>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>
				<input type="submit" value="Update Books">
			</p>
		</form:form>
		<script src="<c:url value='/scripts/lib/prototype.js'/>"></script>
		<script src="<c:url value='/scripts/lib/RowSelector.js'/>"></script>
		<script src="<c:url value='/scripts/user.js'/>"></script>
	</body>
</html>
