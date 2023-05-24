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

            <!-- Blank Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row vh-100 bg-light rounded align-items-baseline justify-content-between mx-0">
                    <div class="col-md-12 mx-4 my-4">
                        <h2>Datos de pago</h2>
                        <div class="col-md-6 mx-4 my-4 p-2 bg-body">
                            <h6 class="fw-normal mb-0">Cliente:</h6>
                            <span>Juan Guevara</span>
                            <h6 class="fw-normal mb-0 mt-4">Evento:</h6>
                            <span>Congreso Salud Mental</span>
                            <h6 class="fw-normal mb-0 mt-4">Monto:</h6>
                            <span>$25.000</span>
                            <h6 class="fw-normal mb-0 mt-4">Fecha:</h6>
                            <span>18/5/2023</span>
                            <h6 class="fw-normal mb-0 mt-4">Hora:</h6>
                            <span>20:00</span>
                            <h6 class="fw-normal mb-0 mt-4">Estado:</h6>
                            <span>APROBADO</span>
                        </div>
                        <button type="button" class="btn btn-primary m-2"><i class="fa fa-home me-2"></i>Generar Escarapela</button>
                    </div>
                </div>
            </div>
            <!-- Blank End -->
            
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