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

            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h1 class="mb-0">Crear usuario</h6>
                    </div>
                    <div class="row g-4">
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4" >
                                <form>
                                    <div class="form-floating mb-3">
                                        <input type="nombre" class="form-control" id="floatingInput"
                                            placeholder="">
                                        <label for="floatingInput">Cedula</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="nombre" class="form-control" id="floatingInput"
                                            placeholder="">
                                        <label for="floatingInput">Nombre</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="nombre" class="form-control" id="floatingInput"
                                            placeholder="">
                                        <label for="floatingInput">Apellido</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="nombre" class="form-control" id="floatingInput"
                                            placeholder="">
                                        <label for="floatingInput">Telefono</label>
                                    </div>                                                                                                                                                
                                </form>
                            </div>                     
                        </div>
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4" >
                                <div class="form-floating mb-3">
                                    <input type="nombre" class="form-control" id="floatingInput"
                                        placeholder="">
                                    <label for="floatingInput">Correo</label>
                                </div> 
                                <div class="form-floating mb-3">
                                    <input type="nombre" class="form-control" id="floatingInput"
                                        placeholder="">
                                    <label for="floatingInput">Contraseña</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <select class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                        <option selected></option>
                                        <option value="1">AUTO</option>
                                        <option value="2">ADMIN</option>
                                        <option value="3">ASESOR</option>
                                    </select>
                                    <label for="floatingSelect">Tipo</label>
                                </div>
                                <div class="bg-light rounded h-100 p-4">
                                    <div class="m-n2">
                                        <a class="btn btn-lg btn-primary w-100" href="Usuarios.jsp">Crear</a>
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