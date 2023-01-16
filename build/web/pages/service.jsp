<%@page import="java.util.ArrayList , model.service.TypeService"%>
<%
    try { 
            ArrayList<TypeService> liste_typeService = (ArrayList<TypeService>) request.getAttribute("listeService");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../assets/css/InsertEmployer.css" rel="stylesheet">
        <link href="../assets/css/header.css" rel="stylesheet">
        <link href="../assets/fontawesome-5/css/all.css" rel="stylesheet">

    <title>Insert employer</title>
</head>
<body>
    <%@include file="header.jsp" %>
    <form action="employe_create" method="POST">
        <div class="Boit">
            <div class="sous">
                <h2>Nom Client</h2>
                <input name="nom" type="text" placeholder="nom">
            </div>
            <div class="sous">
                <h2>Date </h2>
                <input name="prenom" type="date" placeholder="prenom">
            </div>
            <div class="sous">
                <h2>Service</h2>
                <select name="service">
                    <%for (int i = 0 ; i < liste_typeService.size() ;i++) { %>
                        <option value="<%= liste_typeService.get(i).getId()%>"><%= liste_typeService.get(i).getNom()%></option>
                    <% } %>
                </select>
            </div>
        </div>
        <input type="submit" value="Ajouter" id="ajouter">
     </form>
    <% } catch(Exception exe) {  %>
        <%= exe.getMessage()%>
    <% } %>
     <%@include file="footer.jsp" %>
</body>
</html>
