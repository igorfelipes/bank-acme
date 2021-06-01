<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	
	<jsp:attribute name="content">
		
		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Edição de Usuario</h4>
                </div>
                <div class="card-body">
                  <form action="${pageContext.request.contextPath}/UserServlet?&action=edit" method="POST"
                  oninput='passwordRepeat.setCustomValidity(passwordRepeat.value != password.value ? "Password does not match" : "")'>
                    <div class="row">
                      <c:if test="${usuario != null}">
                      	<div class="form-group">
                      		<input type="hidden" name="id" value="${usuario.id}">
                      	</div>
                      	<div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">New username</label>
                          <input type="email" name="username" class="form-control" maxlength="60" required="required" value="${usuario.username}">
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">New password</label>
                          <input type="password" name="password" class="form-control" maxlength="20" required="required" value="${usuario.password}">
                        </div>
                      </div>
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating">Repeat new password</label>
                          <input type="password" name="passwordRepeat" class="form-control" maxlength="20" required="required" value="${usuario.password}">
                        </div>
                      </div>
                      </c:if>
                    </div>
                    <input type="submit" value="Editar" class="btn btn-sm btn-primary"/>
                  </form>
                </div>
              </div>
               <a class="btn btn-primary"
                 href="${pageContext.request.contextPath}/UserServlet?&action=list">Back</a>
            </div>
          </div>
        </div>
	</jsp:attribute>
		
</mt:admin_template>