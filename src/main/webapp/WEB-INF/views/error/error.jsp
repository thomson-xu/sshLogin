
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"
	  xmlns:f="http://java.sun.com/jsf/core"
	  xmlns:ui="http://java.sun.com/jsf/facelets"
	  xmlns:c="http://java.sun.com/jsp/jstl/core" >
<h:head>
	<meta Charset="utf-8"  content="text/html"/>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="X-UA-Conpatible" content="IE=edge" />
	<title>Demo Web</title>
</h:head>
<h:body>
	<div class="container">
		<div class="navbar navbar-inverse">
			<div class="navbar-brand">
				DEMO WEB
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h:form styleClass="form-horizontal">
					<div class="form-group">
						<h:outputLabel value="First Name" styleClass="control-label col-sm-2"/>
						<div class="col-sm-10">
							<h:inputText value="#{studentMB.firstName}" styleClass="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<h:outputLabel value="Last Name" styleClass="control-label col-sm-2"/>
						<div class="col-sm-10">
							<h:inputText value="#{studentMB.lastName}" styleClass="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<h:outputLabel value="Standerd" styleClass="control-label col-sm-2"/>
						<div class="col-sm-10">
							<h:inputText value="#{studentMB.standerd}" styleClass="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:choose>
								<c:when test="#{studentMB.id > 0 }">
									<h:inputHidden value="#{studentMB.id}" />
									<h:commandButton action="#{studentMB.updateStudent()}" value="Update" styleClass="btn btn-default"/>
								</c:when>
								<c:otherwise>
									<h:commandButton action="#{studentMB.createStudent()}" value="Create" styleClass="btn btn-default"/>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</h:form>
				<table class="table table-bordered table-striped">
					<thead>
					<tr>
						<th>Name</th>
						<th>Standerd</th>
						<th></th>
						<th></th>
					</tr>
					</thead>
					<tbody>
					<ui:repeat var="stud" value="#{studentMB.getAllStudents()}">
						<tr>
							<td>#{stud.firstName} #{stud.lastName}</td>
							<td>#{stud.standerd}</td>
							<td>
								<h:form>
									<h:commandLink action="#{studentMB.getStudent(stud.id)}" >
										<i class="glyphicon glyphicon-edit"></i>
									</h:commandLink>
								</h:form>
							</td>
							<td>
								<h:form>
									<h:commandLink action="#{studentMB.deleteStudent(stud.id)}">
										<i class="glyphicon glyphicon-trash"></i>
									</h:commandLink>
								</h:form>
							</td>
						</tr>
					</ui:repeat>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</h:body>
</html>