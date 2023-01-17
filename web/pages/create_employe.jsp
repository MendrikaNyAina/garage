<%@page import="java.util.ArrayList , model.employe.* , model.*"%>

<%@include file="header.jsp" %>
<div class="row">
     <div class="col-md-6 grid-margin stretch-card">
          <div class="card">
               <div class="card-body">
                    <h4 class="card-title">Ajouter employe</h4>
                    <form class="forms-sample" action="create_employe" method="POST">
                         <div class="form-group">
                              <label for="exampleInputUsername1">Nom</label>
                              <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username"
                                   name="nom">
                         </div>
                         <div class="form-group">
                              <label for="exampleInputUsername1">Prenom</label>
                              <input type="text" class="form-control" id="exampleInputUsername1" placeholder="prenom"
                                   name="prenom">
                         </div>
                         <div class="form-group">
                              <label for="exampleInputUsername1">Date de Naissance</label>
                              <input type="date" class="form-control" id="exampleInputUsername1" name="date_naissance">
                         </div>
                         <div class="form-group">
                              <label for="exampleInputUsername1">Date d'embauche</label>
                              <input type="date" class="form-control" id="exampleInputUsername1" name="date_embauche">
                         </div>
                         <div class="form-group">
                              <label for="exampleInputUsername1">Salaire</label>
                              <input type="number" class="form-control" id="exampleInputUsername1" name="salaire" step="0.01">
                         </div>
                         <div class="form-group">
                              <label for="exampleSelectGender">Genre</label>
                              <select class="form-control" id="exampleSelectGender" name="genre">
                              <% if (request.getAttribute("listeGenre")!=null) { ArrayList<Genre> liste_genre = (ArrayList<Genre>) request.getAttribute("listeGenre"); %>
                              <% for (int i = 0 ; i < liste_genre.size() ;i++) { %>
                                   <option value="<%= liste_genre.get(i).getId()%>"><%= liste_genre.get(i).getNom()%></option>
                              <% }} %>
                              </select>
                         </div>
                         <div class="form-group">
                              <label for="exampleSelectGender">Specialite</label>
                              <% if (request.getAttribute("listeSpecialite")!=null) { ArrayList<Specialite> liste_specialite = (ArrayList<Specialite>) request.getAttribute("listeSpecialite"); %>
                              <% for (int j = 0 ; j < liste_specialite.size() ;j++){ %>
                                   <label><input type="checkbox" class="form-check-input" name="specialite" value="<%= liste_specialite.get(j).getId()%>"><%= liste_specialite.get(j).getNom()%></label>
                              <% }} %>
                         </div>
                         <div class="form-group">
                              <label for="exampleSelectGender">Niveau etude</label>
                              <select class="form-control" id="exampleSelectGender" name="niveau">
                                   <% if (request.getAttribute("listeNiveau")!=null) { ArrayList<NiveauEtude> liste_etude = (ArrayList<NiveauEtude>) request.getAttribute("listeNiveau"); %>
                                   <% for (int a = 0 ; a < liste_etude.size() ;a++){ %>
                                        <option value="<%= liste_etude.get(a).getId()%>"><%= liste_etude.get(a).getNom()%></option>
                                   <% }} %>
                              </select>
                         </div>
                         <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                    </form>
               </div>
          </div>
     </div>
</div>
<%@include file="footer.jsp" %>