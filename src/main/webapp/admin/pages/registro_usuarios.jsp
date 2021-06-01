<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	
	<jsp:attribute name="content">
		
		<div class="container-fluid">
          <div class="row">
             <div class="col-md-12">
   				<c:if test="${not empty errorRegister}">
   					<div class="alert alert-danger">${errorRegister}</div>
   				</c:if>
            </div>
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Cadastro de Usuario</h4>
                  <p class="card-category">Preencha os Campos</p>
                </div>
                <div class="card-body">
                  <form action="${pageContext.request.contextPath}/UserServlet?&action=register" method="POST">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">E-mail</label>
                          <input type="email" name="username" class="form-control" maxlength="60" required="required">
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Senha</label>
                          <input type="password" name="password" class="form-control" required="required">
                        </div>
                      </div>
                    </div>
                    <input type="submit" value="Cadastrar" class="btn btn-sm btn-primary"/>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
	</jsp:attribute>
		
</mt:admin_template>