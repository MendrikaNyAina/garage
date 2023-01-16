<%@page import="java.util.ArrayList , model.employe.* , model.*"%>
<%
    try { 
            ArrayList<TypeService> liste_typeService = (ArrayList<TypeService>) request.getAttribute("listeService");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="row">
     <div class="col-md-6 grid-margin stretch-card">
          <div class="card">
               <div class="card-body">
               <%
                    if(request.getAttribute("message")!=null){
                    %>
                    <div class="alert alert-success" role="alert">
                         <%=request.getAttribute("message")%>
                    </div>
               <% }
               %>
                    <h4 class="card-title">demande service</h4>
                    <form class="forms-sample" action="/create_service" method="POST">
                         <div class="form-group">
                              <label for="exampleInputUsername1">Nom client</label>
                              <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username"
                                   name="nom">
                         </div>
                         <div class="form-group">
                              <label for="exampleInputUsername1">Date </label>
                              <input type="date" class="form-control" id="exampleInputUsername1" name="date">
                         </div>
                         <div class="form-group">
                              <label for="exampleSelectGender">Service</label>
                              <select class="form-control" id="exampleSelectGender" name="service">
                                   <%for (int i = 0 ; i < liste_typeService.size() ;i++) { %>
                                        <option value="<%= liste_typeService.get(i).getId()%>"><%= liste_typeService.get(i).getNom()%></option>
                                   <% } %>
                              </select>
                         </div>
                         <button type="submit" class="btn btn-gradient-primary me-2">Ajouter</button>
                    </form>
               </div>
          </div>
     </div>
</div>
<% } catch(Exception exe) {  %>
        <div class="alert alert-success" role="alert">
                         <%= exe.getMessage() %>
        </div>
<% } %>
<%@include file="footer.jsp" %>