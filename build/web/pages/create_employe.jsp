<%@page import="java.util.ArrayList , model.employe.* , model.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../asset/css/InsertEmployer.css" rel="stylesheet">
        <link href="../asset/css/header.css" rel="stylesheet">
        <link href="../asset/fontawesome-5/css/all.css" rel="stylesheet">

    <title>Insert employer</title>
</head>
<body>
    <%@include file="header.jsp" %>

    <form action="EmployeCreateController" method="POST">
        <div class="Boit">
            <div class="sous">
                <h2>Nom</h2>
                <input name="nom" type="text" placeholder="nom">
            </div>
            <div class="sous">
                <h2>Prenom</h2>
                <input name="prenom" type="text" placeholder="prenom">
            </div>
        </div>
        <div class="Boit">
            <h2>Date de Naissance</h2>
            <input name="date_naissance" placeholder="08/13/2018" type="date">
        </div>
        <div class="Boit">
            <div class="sous">
                <h2>Date embauche</h2>
                <input name="datedembauche" placeholder="08/13/2018" type="date">
            </div>
            <div class="sous">
                <h2>Salaire</h2>
                <input name="salaire" placeholder="salaire" type="number">
            </div>
        </div>
        <div class="Boit">
            <h2>Genre</h2>
            <% if (request.getAttribute("listeGenre")!=null) { ArrayList<Genre> liste_genre = (ArrayList<Genre>) request.getAttribute("listeGenre"); %>
            <% for (int i = 0 ; i < liste_genre.size() ;i++) { %>
                 <p> <input type="radio" name="Genre" value="<%= liste_genre.get(i).getId()%>"> <%= liste_genre.get(i).getNom()%></p> 
            <% }} %>
        </div>
        <div class="Boit">
            <h2>Specialite</h2>
            <div class="Spsous">
                <% if (request.getAttribute("listeSpecialite")!=null) { ArrayList<Specialite> liste_specialite = (ArrayList<Specialite>) request.getAttribute("listeSpecialite"); %>
                <% for (int j = 0 ; j < liste_specialite.size() ;j++){ %>
                <p> <input type="checkbox" name="specialite" value="<%= liste_specialite.get(j).getId()%>"><%= liste_specialite.get(j).getNom()%></p>  
                <% }} %>
            </div>
        </div>
         <div class="Boit">
            <h2>Niveau d'etude</h2>
            <div class="Spsous">
                <% if (request.getAttribute("listeNiveau")!=null) { ArrayList<NiveauEtude> liste_etude = (ArrayList<NiveauEtude>) request.getAttribute("listeNiveau"); %>
                <% for (int a = 0 ; a < liste_etude.size() ;a++){ %>
                <p> <input type="checkbox" name="specialite" value="<%= liste_etude.get(a).getId()%>"><%= liste_etude.get(a).getNom()%></p>  
                <% }} %>
            </div>
        </div>
        <input type="submit" value="Ajouter" id="ajouter">
     </form>
     <%@include file="footer.jsp" %>
</body>
</html>