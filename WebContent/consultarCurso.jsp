<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="p" uri="http://pedrosu/bread"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Cursos</title>
</head>
<body>
	<div align="center">
		<f:view>
		<%--	<jsp:include page="/menu.jsp"></jsp:include> --%>
			<h:form>
				<h:panelGrid columns="1">
					<h:messages />
				</h:panelGrid>

				<h:panelGrid columns="1">
					<h1>Consulta de Cursos</h1>
				</h:panelGrid>
				<h:panelGrid columns="1" width="700">
					<rich:dataTable id="listaCurso" value="#{cursoBacking.listaCurso}"
						var="curso" width="100%">
						<f:facet name="caption">
							<h:outputText value="" />
						</f:facet>
						<f:facet name="header">
							<rich:columnGroup>
								<rich:column width="10%">
									<h:outputText value="Código" />
								</rich:column>
								<rich:column>
									<h:outputText value="Horas" />
								</rich:column>
								<rich:column>
									<h:outputText value="Nome" />
								</rich:column>
							</rich:columnGroup>
						</f:facet>
						<rich:column>
							<h:outputText value="#{curso.codigo}" />
						</rich:column>
						<rich:column>
							<h:outputText value="#{curso.horas}" />
						</rich:column>
						<rich:column>
							<h:outputText value="#{curso.nome}" />
						</rich:column>
					</rich:dataTable>
				</h:panelGrid>
				<h:panelGrid columns="3">
					<h:commandButton value="Retornar" action="#{cursoBacking.voltar}"/>
					<h:commandButton value="Cancelar" action="#{cursoBacking.cancelar}"/>
        			<h:commandButton value="Avançar" action="#{cursoBacking.avancar}"/>	                 				 
				</h:panelGrid>
				<p:breadcrumb item="Consulta Curso"></p:breadcrumb>
			</h:form>
		</f:view>
	</div>
</body>
</html>