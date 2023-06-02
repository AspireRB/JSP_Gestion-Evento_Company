<!-- Sidebar Start -->
<div class="sidebar pe-4 pb-3">
    <nav class="navbar bg-light navbar-light">
        <a href="Eventos.jsp" class="navbar-brand mx-4 mb-3">
            <h3 class="text-primary"><i class="fa me-2"></i>Logistics</h3>
        </a>
        <div class="d-flex align-items-center ms-4 mb-4">
            <div class="position-relative">
                <img class="rounded-circle" src="../../static/img/user.jpg" alt="" style="width: 40px; height: 40px;">
                <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
            </div>
            <div class="ms-3">
                <h6 class="mb-0">${usuario.nombre} ${usuario.apellido}</h6>
                <span>Admin</span>
            </div>
        </div>
        <div class="navbar-nav w-100">
            <a href="Usuarios.jsp" class="nav-item nav-link"><i class="fas fa-users-cog me-2"></i>Usuarios</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-table me-2"></i>Eventos</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="crearEvento.jsp" class="dropdown-item">Crear</a>
                    <a href="Eventos.jsp" class="dropdown-item">Consultar</a>
                </div>
            </div>
             <a href="../../ConferencistaController" class="nav-item nav-link"><i class="fas fa-user-plus me-2"></i>Conferencistas</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="bi bi-kanban-fill"></i>Gestion</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="Ciudades.jsp" class="dropdown-item">Ciudad</a>
                    <a href="Lugares.jsp" class="dropdown-item">Lugar</a>
                </div>
            </div>
            <a href="Certificados.html" class="nav-item nav-link"><i class="far fa-file-alt me-2"></i>Certificados</a>
            <!--<a href="chart.html" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>Charts</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Pages</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="signin.html" class="dropdown-item">Sign In</a>
                    <a href="signup.html" class="dropdown-item">Sign Up</a>
                    <a href="404.html" class="dropdown-item">404 Error</a>
                    <a href="blank.html" class="dropdown-item">Blank Page</a>
                </div>
            </div>-->
        </div>
    </nav>
</div>
<!-- Sidebar End -->