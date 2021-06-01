<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	
	<jsp:attribute name="content">
		
		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
   				<c:if test="${not empty sucesso}">
   					<div class="alert alert-success">${sucesso}</div>
   				</c:if>
            </div>
            
            <div class="col-md-12">
   				<c:if test="${not empty removido}">
   					<div class="alert alert-success">${removido}</div>
   				</c:if>
            </div>
            
            <div class="table table-responsive table-striped table-hover">
                    <table class="table">
                      <thead class=" text-primary">
                      	  <th scope="col">Editar</th>
                      	  <th scope="col">Remover</th>
                       	  <th scope="col">ID</th>
					      <th scope="col">Usuario</th>
					      <th scope="col">Senha</th>
                      </thead>
                      <tbody>
                        <c:forEach var="usuario" items="${usuarios}">
                        	<tr>
                        	
                        		<td>
                        			<a class="btn btn-primary" 
                        				href="${pageContext.request.contextPath}/usuarioServlet?id=${usuario.id}&user=${usuario.username}&password=${usuario.password}&acao=editar">
                        				<c:out value="Editar"/>
                        			</a>
  
                        		</td>
                        		
                        		<td>
									<a class="btn btn-danger" 
                        				href="${pageContext.request.contextPath}/usuarioServlet?id=${usuario.id}&acao=remover">
                        				<c:out value="Remover"/>
                        			</a>
                        		</td>
                        	
                        		<td><c:out value="${usuario.id}"></c:out></td>
                        		<td><c:out value="${usuario.username}"></c:out></td>
                        		<td><c:out value="******"></c:out></td>
                        		                		
                        	</tr>
                  
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
            
          </div>
        		
	</jsp:attribute>
		
</mt:admin_template>