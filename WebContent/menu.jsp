<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="p" uri="http://pedrosu/bread"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Server Faces</title>
	</head>
<body>
	<div>
		<f:subview id="view">
			<h:form id="tbPrincipal">
				<rich:toolBar>
					<rich:dropDownMenu value="Consulta">
						<rich:menuItem id="menu1" value="Cursos"
							action="#{cursoBacking.consultarCurso}">
						</rich:menuItem>
					</rich:dropDownMenu>
				</rich:toolBar>
				<p:breadcrumb item="Menu"></p:breadcrumb>
			</h:form>
		</f:subview>
	</div>
</body>
</html>