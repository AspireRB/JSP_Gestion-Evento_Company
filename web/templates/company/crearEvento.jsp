<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if (session.getAttribute("usuario") != null){
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Logistics</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="../../static/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="../../static/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../../static/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="../../static/css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <jsp:include page="includes/spinner.jsp"></jsp:include>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <jsp:include page="includes/sidebar.jsp"></jsp:include>
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <jsp:include page="includes/navbar.jsp"></jsp:include>
            <!-- Navbar End -->

            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h1 class="mb-0">Crear evento</h6>
                    </div>
                    <div class="row g-4">
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4" >
                                <form action="../../EventoController?accion=insertar" method="POST" class="was-validated"  >
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="inputnombre" pattern="[A-Za-z\s]+" title="Ingrese solo letras" required>
                                        <label for="floatingInput">Nombre</label>
                                    </div>                             
                                    <div class="form-floating mb-3"> 
                                        <input type="date" name="fechaInicio" class="form-control" min="2023-03-25" max="2024-05-25" required/>
                                        <label for="floatingInput">Fecha incio</label>
                                    </div>
                                    <div class="form-floating mb-3"> 
                                        <input type="time" name="horaInicio" class="form-control" min="08:00" max="18:00" step="3600" required/>
                                        <label for="floatingInput">Hora incio</label>
                                    </div>
                                    <div class="form-floating mb-3"> 
                                        <input type="date" name="fechaFin" class="form-control" min="2023-03-25" max="2024-05-25" required/>
                                        <label for="floatingInput">Fecha fin</label>
                                    </div>
                                    <div class="form-floating mb-3"> 
                                        <input type="time" name="horaFin" class="form-control" min="08:00" max="18:00" step="3600" required/>
                                        <label for="floatingInput">Hora fin</label>
                                    </div>                                    
                                    <div class="form-floating mb-3">
                                        <select class="form-select" id="floatingSelect" name="lugar"
                                            aria-label="Floating label select example" requiered>
                                            <c:forEach items="${listaLugar}" var="lugar">
                                                <option value="${lugar.idLugar}">${lugar.nombre}</option>
                                            </c:forEach>                                            
                                        </select>
                                        <label for="floatingSelect">Selecciona Lugar</label>
                                    </div>                                    
                                </form>
                            </div>                     
                        </div>
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4" >                                                                   
                                <div class="form-floating mb-3">
                                    <textarea class="form-control" id="descripcion" name="descripcion" requiered style="height: 150px;"></textarea>
                                    <label for="floatingTextarea">Descripción</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="inputcosto" name="nombre" pattern="[0-9]{10}" inputmode="numeric" title="Ingrese dígitos numéricos" required>
                                    <label for="floatingInput">Costo</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <select class="form-select" id="floatingSelect" name="estado"
                                        aria-label="Floating label select example" requiered>
                                        <option selected></option>
                                        <option value="1">Por iniciar</option>
                                        <option value="2">En curso</option>
                                        <option value="3">Finalizado</option>
                                    </select>
                                    <label for="floatingSelect">Estado</label>
                                </div>
                                <div class="bg-light rounded h-100 p-4">
                                    <div class="m-n2">
                                        <a class="btn btn-lg btn-primary w-100" href="Eventos.jsp">Crear</a>
                                    </div>
                                </div>
                            </div>
                        </div>                        
                    </div>
                </div>
            </div>
            <!-- Recent Sales End -->
            
            <!-- Footer Start -->
            <jsp:include page="includes/footer.jsp"></jsp:include>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../../static/lib/chart/chart.min.js"></script>
    <script src="../../static/lib/easing/easing.min.js"></script>
    <script src="../../static/lib/waypoints/waypoints.min.js"></script>
    <script src="../../static/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="../../static/lib/tempusdominus/js/moment.min.js"></script>
    <script src="../../static/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="../../static/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="../../static/js/main.js"></script>
</body>

</html>
<%
}else{
    response.sendRedirect("ingresar.jsp");
}
%>