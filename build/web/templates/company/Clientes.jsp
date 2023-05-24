<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <title>Logistics - Clientes</title>
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
                        <h1 class="mb-0">Clientes</h1>
                    </div>
                    <form class="d-flex align-items-center justify-content-between mb-4">
                        <input class="form-control border-0" type="search" placeholder="Buscar">
                    </form>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-dark">  
                                    <th scope="col">#</th>
                                    <th scope="col">Cedula</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>0000000000</td>
                                    <td>N/A</td>
                                    <td>N/A</td>
                                    <td>0000000000</td>
                                    <td>correo1@gmail.com</td>
                                    <td><a class="btn btn-primary rounded-pill m-2" href="confirmAsistencia.jsp">Confirmar Asistencia</a>
                                        <a class="btn btn-primary rounded-pill m-2" href="validarPago.jsp">Validar Pago</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>12093454</td>
                                    <td>Daniela</td>
                                    <td>Gonzales</td>
                                    <td>31294581</td>
                                    <td>correo2@gmail.com</td>
                                    <td><a class="btn btn-primary rounded-pill m-2" href="confirmAsistencia.jsp">Confirmar Asistencia</a>
                                        <a class="btn btn-primary rounded-pill m-2" href="validarPago.jsp">Validar Pago</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>12093456</td>
                                    <td>Federico</td>
                                    <td>Jimenez</td>
                                    <td>31294530</td>
                                    <td>correo3@gmail.com</td>
                                    <td><a class="btn btn-primary rounded-pill m-2" href="confirmAsistencia.jsp">Confirmar Asistencia</a>
                                        <a class="btn btn-primary rounded-pill m-2" href="validarPago.jsp">Validar Pago</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>12093452</td>
                                    <td>Jose</td>
                                    <td>Gualmir</td>
                                    <td>31294584</td>
                                    <td>correo4@gmail.com</td>
                                    <td><a class="btn btn-primary rounded-pill m-2" href="confirmAsistencia.jsp">Confirmar Asistencia</a>
                                        <a class="btn btn-primary rounded-pill m-2" href="validarPago.jsp">Validar Pago</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>12093453</td>
                                    <td>Juan</td>
                                    <td>Lopez</td>
                                    <td>31294583</td>
                                    <td>correo5@gmail.com</td>
                                    <td><a class="btn btn-primary rounded-pill m-2" href="confirmAsistencia.jsp">Confirmar Asistencia</a>
                                        <a class="btn btn-primary rounded-pill m-2" href="validarPago.jsp">Validar Pago</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
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