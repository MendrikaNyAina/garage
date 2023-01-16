<%@page import="java.util.ArrayList , model.employe.* , model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="row">
     <div class="col-lg-6 grid-margin stretch-card">
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
                    <h4 class="card-title">Liste service</h4>
                    </p>
                    <table class="table">
                         <thead>
                              <tr>
                                   <th>Type service</th>
                                   <th>Description</th>
                                   <th>Valeur salarial</th>
                              </tr>
                         </thead>
                         <tbody>
                              
                              <%
                                   if(request.getAttribute("listeService") != null)
                                   {
                                        ArrayList<TypeServiceSalariale> listeService = (ArrayList<TypeServiceSalariale>) request.getAttribute("listeService");
                                        for(TypeServiceSalariale service : listeService)
                                        {
                              %>
                              <tr>
                                   <td><%= service.getNom() %> </td>
                                   <td><%= service.getDescription() %></td>
                                   <td><%= service.getMontant() %>7</td>
                              </tr> 
                              <%
                                        }
                                   }
                                   %>
                         </tbody>
                    </table>
               </div>
          </div>
     </div>
</div>
<%@include file="footer.jsp" %>