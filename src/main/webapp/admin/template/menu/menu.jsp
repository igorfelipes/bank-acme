<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="sidebar" data-color="purple" data-background-color="white" 
          data-image="${pageContext.request.contextPath}/assets/img/sidebar-1.jpg">
      <div class="logo"><a href="#" class="simple-text logo-normal">
          Acme Bank
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item active  ">
            <a class="nav-link" href="${pageContext.request.contextPath}/admin/home">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=register">
              <i class="material-icons">add_circle</i>
              <p>Cadastrar Usuarios</p>
            </a>
          </li>
           <li class="nav-item ">
            <a class="nav-link" href="${pageContext.request.contextPath}/UserServlet?action=list">
              <i class="material-icons">view_list</i>
              <p>Listar Usuarios</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    