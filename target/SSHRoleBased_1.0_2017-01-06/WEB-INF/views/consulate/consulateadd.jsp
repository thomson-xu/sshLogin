<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<form:form method="POST" modelAttribute="user" class="form-horizontal">
    <form:input type="hidden" path="id" id="id"/>
        <div id="content" class="table-view">

                <table>
                <tbody>
                <tr>
                    <td><h:graphicImage value="/resources/images/#{consulate.entity.countryEntity.nationalFlag}"></h:graphicImage>
                    </td>
                    <td> <h:outputText value="#{consulate.entity.countryEntity.name}" id="countryName"/></td>
                </tr></tbody>
                </table>
                <h:form id="country" enctype="multipart/form-data">
                    <table>
                        <tbody>
                        <tr>
                            <td><h:outputText value="领事馆名:" id="lblName"/><span style="color: red;">*</span></td>
                            <td>
                                <h:inputText value="#{consulate.consulateEntity.consulateName}" id="consulateName" style="width: 160px" label="领事馆名">
                                    <f:validateLength maximum="15" minimum="2"/>

                                </h:inputText>
                            </td>
                            <td> <h:messages for="consulateName" style="color: red"/></td>
                        </tr>
                        <tr>
                            <td> <h:outputLabel value="领区:" id="continents"/><span style="color: red;">*</span></td>
                            <td> <h:inputTextarea value="#{consulate.consulateEntity.consulateArea}" id="consulateArea" style="width: 160px" label="领区">
                                <f:validateLength maximum="100" minimum="4"/>
                            </h:inputTextarea></td>
                            <td> <h:messages for="consulateArea" style="color: red"/></td>
                        </tr>
                        </tbody>
                    </table>
                    <h:commandButton actionListener="#{consulate.addConsulate}" id="addconsulate"
                                     value="添 加" style="center">
                        <!--<f:ajax execute="soNumber num" render="result"/>-->
                    </h:commandButton>

                    <p style="color: red; font-size: 18pt">
                        <h:outputText value="#{consulate.result}"
                                      id="status"/></p>




        </div>
</form:form>
</body>
</html>
