<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet'>
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp2/css/bootstrap.min.css" rel="stylesheet">
   
  </head>
  <body>
    <div class="header">
      <div class="container">
        <div class="login" style="width:200px;">
			<form action='login' method="post" >
				<div >
					<input type="text" id="userId" name="userId" placeholder="Id-ul de client" class="form-control"/>
				</div>
				
				<div>
					<input type="password" id="password" name="password" placeholder="CNP-ul sau CUI-ul" class="form-control"/>
				</div>
				<button id="loginButton" class="form-control">Login</button>
			</form>
		</div>
		<a href="#" class="logo-icon">
          <img src="https://peli-pod.com/media/1027/courier-icon-green.png?width=150px&height=150px">
        </a>
        <ul class="menu">
          <li><a href="#">Descarca Aplicatia</a></li>
          <li><a href="#">Detalii de facturare</a></li>
          <li><a href="#">Lista sediilor</a></li>
          <li><a href="#">Call center</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle">Mai multe<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Ceva</a></li>
              <li><a href="#">Altceva</a></li>
              <li><a href="#">Evenimente</a></li>
              <li><a href="#">Despre Noi</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>

    <div class="slider">

      <div class="slide active-slide">
        <div class="container">
          <div class="row">
            <div class="slide-copy col-xs-5">
              <h1>Descarca aplicatia UcExpress</h1>
              <p>UcExpress este o aplicatie care urmeaza a fi dezvoltata de catre Marius Iliescu , atunci cand va avea timp si mai ales chef.</p>
              
              <ul class="get-app">
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/ios.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/android.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/windows.png"></a></li>
                <li><a href="#"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/blackberry.png"></a></li>
              </ul>
            </div>
            <div class="slide-img col-xs-7">
              <img src="https://7labs.heypub.com/wp-content/uploads/2015/03/Track-shipment-status-automatically-from-iPhone-Android.png" width="540px">
            </div>
          </div>
        </div>      
      </div>

      <div class="slide slide-feature">
        <div class="container">
          <div class="row">
            <div class="col-xs-12">
              <a href="#">Citeste Acum</a>
            </div>
            
          </div>
        </div>      
      </div> 

      <div class="slide">
        <div class="container">
          <div class="row">
            <div class="slide-copy col-xs-5">
              <h1>Preturi avantajoase</h1>
              <h2>-cele mai mici-</h2>
              <p>Daca gasiti in alta parte mai ieftin ducetiva acolo.</p>
              
            </div>
            <div class="slide-img col-xs-7">
              <img src="https://paceaustralia.files.wordpress.com/2012/07/price-cut.jpg">
            </div>
          </div>
        </div>      
      </div> 


      <div class="slide">
        <div class="container">
          <div class="row">
            <div class="slide-copy col-xs-5">
              <h1>Curierat simpu si rapid</h1>
              <p>Mi de oameni din toate colturile tarii au beneficiat de serviciile noastre.</p>
              
            </div>
            <div class="slide-img col-xs-7">
              <img src="http://blog.tjobs.ro/blog/wp-content/uploads/2014/03/c4736dc935c189544aebb6f51b9f219f-600x300.jpg" width="540px">
            </div>
          </div>
        </div>      
      </div> 

    </div>

    <div class="slider-nav">
      <a href="#" class="arrow-prev"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/arrow-prev.png"></a>
      <ul class="slider-dots">
        <li class="dot active-dot">&bull;</li>
        <li class="dot">&bull;</li>
        <li class="dot">&bull;</li>
        <li class="dot">&bull;</li>
      </ul>
      <a href="#" class="arrow-next"><img src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/arrow-next.png"></a>
    </div> 
    
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>    
    <script src="resources/js/app.js"></script>

	<script>
	    function slideSwitch() {
	        var $active = $('div#slider IMG.active');
	        var $next = $active.next();    
	
	        $next.addClass('active');
	
	        $active.removeClass('active');
	    }
	
	    $(function() {
	        setInterval( "slideSwitch()", 5000 );
	    });
	</script>
  </body>
</html>