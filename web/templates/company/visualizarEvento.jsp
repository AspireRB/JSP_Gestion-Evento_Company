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
                <div class="bg-light text-center rounded p-4" action="../../EventoController?accion=buscar&idEvento=${evento.id}">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h1 class="mb-0">Evento</h6>
                    </div>
                    <div class="row g-4">
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-line fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Ganacias</p>
                                    <h6 class="mb-0">$1234</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-bar fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Inscripciones</p>
                                    <h6 class="mb-0">666</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-area fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Conferencias</p>
                                    <h6 class="mb-0">30</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-pie fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Salones</p>
                                    <h6 class="mb-0">20</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4" >
                                <div type="text" class="alert alert-secondary" role="alert" name="nombre" value="${evento.nombre}">
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Fecha de inicio para el evento
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Hora de inicio para el evento
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Fecha de fin para el evento
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Hora de fin para el evento
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Ciudad donde ser realizara el evento
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Lugar del evento
                                </div>                                
                            </div>                     
                        </div>
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4" >
                                <div class="alert alert-secondary" role="alert">
                                    Descripción completa relacionada al evento
                                    para que se tenga la información exacta de
                                    los temas a tratar en las conferencias en
                                    general
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Costo de inscripción
                                </div>
                                <div class="alert alert-secondary" role="alert">
                                    Estado en que se encuentra el evento
                                </div> 
                                <div class="bg-light rounded p-3">
                                    <div class="m-n2">
                                        <a class="btn btn-primary w-100" href="modificarEvento.jsp">Modificar</a>
                                    </div>
                                </div>
                                <div class="bg-light rounded p-3">
                                    <div class="m-n2">
                                        <a class="btn btn-primary w-100" href="../../ConferenciaController">Conferencias</a>
                                    </div>
                                </div>
                                <div class="bg-light rounded p-3">
                                    <div class="m-n2">
                                        <a class="btn btn-primary w-100" href="../../SalonController">Salones</a>
                                    </div>
                                </div>
                                <div class="bg-light rounded p-3">
                                    <div class="m-n2">
                                        <a class="btn btn-primary w-100" href="../../ClienteController?idEvento=1">Clientes</a>
                                    </div>
                                </div>
                                <div class="bg-light rounded p-3">
                                    <div class="m-n2">
                                        <a class="btn btn-danger w-100" href="Eventos.jsp">Eliminar</a>
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