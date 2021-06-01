<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	
	<jsp:attribute name="content">
		
		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
   				<c:if test="${not empty success}">
   					<div class="alert alert-success">${success}</div>
   				</c:if>
            </div>
            
            <div class="col-md-12">
   				<c:if test="${not empty removed}">
   					<div class="alert alert-success">${removed}</div>
   				</c:if>
            </div>
            
            <div class="table table-responsive table-striped table-hover">
                    <table class="table">
                      <thead class=" text-primary">
                       	  <th scope="col">ID</th>
					      <th scope="col">User</th>
                          <th scope="col">Edit</th>
                      	  <th scope="col">Delete</th>
                      </thead>
                      <tbody>
                        <c:forEach var="user" items="${users}">
                        	<tr>
                        		<td><c:out value="${user.id}"></c:out></td>
                        		<td><c:out value="${user.username}"></c:out></td>
                    		    <td>
                        			<a class="btn btn-primary" 
                        				href="${pageContext.request.contextPath}/UserServlet?id=${user.id}&user=${user.username}&password=${user.password}&action=edit">
                        				<c:out value="Edit"/>
                        			</a>
  
                        		</td>
                        		
                        		<td>
									<a class="btn btn-danger" 
                        				href="${pageContext.request.contextPath}/UserServlet?id=${user.id}&action=delete">
                        				<c:out value="Delete"/>
                        			</a>
                        		</td>
                        	
                        		                		
                        	</tr>
                  
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
            
          </div>
        		
	</jsp:attribute>
		
</mt:admin_template>