<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                    <!-- Sale & Revenue Start -->
                    <div class="container-fluid pt-4 px-4">
                        <div class="bg-light text-center rounded p-4" style="max-height: 400px; overflow-y: scroll;">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">Conferencistas</h6>
                                <a class="btn btn-success m-2" href="CrearConferencista.jsp">NUEVO EXPOSITOR</a>
                            </div>
                            <div class="table-responsive">
                                <table class="table text-start align-middle table-bordered table-hover mb-0">
                                    <thead>
                                        <tr class="text-dark">                                    
                                            <th scope="col">Nombre</th>
                                            <th scope="col">Apellido</th>
                                            <th scope="col">Correo</th>
                                            <th scope="col">Identificación</th> 
                                            <th scope="col">Acción</th>                                                                     

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Juan</td>
                                            <td>Lopez</td>
                                            <td>Jlopez@gmail.com</td>
                                            <td>1005715101</td>                                    
                                             <td><a class="btn btn-primary rounded-pill m-2" href="modificarConferencista.jsp">Modificar</a>
                                                <a class="btn btn-danger rounded-pill m-2" href="">Eliminar</a>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td>Paula</td>
                                            <td>Arango</td>
                                            <td>Parango@gmail.com</td>
                                            <td>1014567892</td>                                    
                                            <td><a class="btn btn-primary rounded-pill m-2" href="">Modificar</a>
                                                <a class="btn btn-danger rounded-pill m-2" href="">Eliminar</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Andres</td>
                                            <td>Castro</td>
                                            <td>Candres@gmail.com</td>
                                            <td>1023654897</td>                                    
                                          <td><a class="btn btn-primary rounded-pill m-2" href="">Modificar</a>
                                                <a class="btn btn-danger rounded-pill m-2" href="">Eliminar</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Luis</td>
                                            <td>Hernandez</td>
                                            <td>Hluis@gmail.com</td>
                                            <td>1478529636</td>                                    
                                            <td><a class="btn btn-primary rounded-pill m-2" href="">Modificar</a>
                                                <a class="btn btn-danger rounded-pill m-2" href="">Eliminar</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Laura</td>
                                            <td>Devia</td>
                                            <td>Ldevia@gmail.com</td>
                                            <td>1963258741</td>                                    
                                          <td><a class="btn btn-primary rounded-pill m-2" href="">Modificar</a>
                                                <a class="btn btn-danger rounded-pill m-2" href="">Eliminar</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Martin</td>
                                            <td>Ramirez</td>
                                            <td>Mramirez@gmail.com</td>
                                            <td>1025874693</td>                                    
                                            <td><a class="btn btn-primary rounded-pill m-2" href="">Modificar</a>
                                                <a class="btn btn-danger rounded-pill m-2" href="">Eliminar</a>
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

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