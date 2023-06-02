<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

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
                                <h6 class="mb-0">Material Conferencia</h6>
                                <a class="btn btn-success m-2" href="../../MaterialController?accion=nuevo">NUEVO MATERIAL</a>
                            </div>
                            <div class="table-responsive">
                                <table class="table text-start align-middle table-bordered table-hover mb-0">
                                    <thead>
                                        <tr class="text-dark">                                    
                                            <th scope="col">Código</th>
                                            <th scope="col">Nombre</th>
                                            <th scope="col">Descripción</th>
                                            <th scope="col">Material</th>
                                            <th scope="col">Acción</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listaMaterial}" var="material">
                                        <tr>
                                            <td>${material.idMaterial}</td>
                                            <td>${material.nombre}</td>
                                            <td>${material.descripcion}</td>
                                            <td>${material.rutaArchivo}</td>
                                            
                                            <td>
                                                <a class="btn btn-primary rounded-pill m-2" name="editar" href="../../ConferencistaController?accion=editar&amp;idConferencista=${conferencista.id}">Modificar</a>
                                                <a class="btn btn-danger rounded-pill m-2" name="eliminar" href="../../ConferencistaController?accion=eliminar&amp;idConferencista=${conferencista.id}">Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
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