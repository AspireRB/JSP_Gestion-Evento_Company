<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Logistics - Pasarela de Pagos</title>
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
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Cargando...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Payment Start -->
        <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="http://localhost:8080/Gestion_Eventos/templates/clients/mostrarEventos.jsp" class="">
                                <h3 class="text-primary"><i class="fa me-2"></i>Logistic</h3>
                            </a>
                            <h3>Pagar</h3>
                        </div>
                        <div class="form-floating mb-3">
                            <select class="form-select" id="paymentMethod" onchange="showPaymentFields()">
                                <option value="" selected disabled>Selecciona el Método de Pago</option>
                                <option value="creditCard">Tarjeta de Crédito</option>                                
                                <option value="pse">PSE</option>                                
                            </select>
                            <label for="paymentMethod">Método de Pago</label>
                        </div>

                        <!-- Credit Card Fields -->
                        <div id="creditCardFields" style="display: none;">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="cardNumber" placeholder="1234 5678 9012 3456">
                                <label for="cardNumber">Número de Tarjeta</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="cardHolderName" placeholder="Juan Pérez">
                                <label for="cardHolderName">Nombre del Titular</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="cardExpiration" placeholder="MM/AA">
                                <label for="cardExpiration">Fecha de Vencimiento</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="cardCVV" placeholder="123">
                                <label for="cardCVV">CVV</label>
                            </div>
                        </div>
                                               
                        
                        <!-- PSE Fields -->
                        <div id="pseFields" style="display: none;">
                            <div class="form-floating mb-3">
                                <select class="form-select" id="psePersonType">
                                    <option value="" selected disabled>Selecciona el Tipo de Persona</option>
                                    <option value="natural">Persona Natural</option>
                                    <option value="juridica">Persona Jurídica</option>
                                </select>
                                <label for="psePersonType">Tipo de Persona</label>
                            </div>
                            <div class="form-floating mb-3">
                                <select class="form-select" id="bankSelect">
                                    <option value="" selected disabled>Selecciona un Banco</option>
                                    <option value="bancoAgrario">Banco Agrario</option>
                                    <option value="bancoAVVillas">Banco AV Villas</option>
                                    <option value="bancoCajaSocial">Banco Caja Social</option>
                                    <option value="bancoColpatria">Banco Colpatria</option>
                                    <option value="bancoDavivienda">Banco Davivienda</option>
                                    <option value="bancoBogota">Banco de Bogotá</option>
                                    <option value="bancoOccidente">Banco de Occidente</option>
                                    <option value="bancoGNBSudameris">Banco GNB Sudameris</option>
                                    <option value="bancoPichincha">Banco Pichincha S.A.</option>
                                    <option value="bancoPopular">Banco Popular</option>
                                    <option value="bancoProcredit">Banco Procredit</option>
                                    <option value="bancolombia">Bancolombia</option>
                                    <option value="bancoomeva">Bancoomeva S.A.</option>
                                    <option value="bbvaColombia">BBVA Colombia S.A.</option>
                                    <option value="citibank">Citibank</option>
                                    <option value="itau">Itaú</option>
                                    <option value="bancoFalabella">Banco Falabella</option>
                                    <option value="nequi">Nequi</option>
                                    <option value="daviplata">Daviplata</option>
                                    <option value="movii">Movii</option>
                                </select>
                                <label for="bankSelect">Banco</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" id="pseEmail" placeholder="nombre@ejemplo.com">
                                <label for="pseEmail">Correo Electrónico</label>
                            </div>
                        </div>  
                        
                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Realizar Pago</button>
                        <p class="text-center mb-0">¿Necesitas ayuda? <a href="">Contáctanos</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Payment End -->
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

    <script>
        function showPaymentFields() {
            var paymentMethod = document.getElementById("paymentMethod").value;
            var creditCardFields = document.getElementById("creditCardFields");            
            var pseFields = document.getElementById("pseFields");            

            creditCardFields.style.display = "none";            
            pseFields.style.display = "none";
            

            if (paymentMethod === "creditCard") {
                creditCardFields.style.display = "block";
            } else if (paymentMethod === "pse") {
                pseFields.style.display = "block";
            }
        }
    </script>
</body>

</html>
