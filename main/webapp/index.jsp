<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#slideshow {
  overflow: hidden;
  height: 400px;
  width: 800px;
  margin: 0 auto;
}
 
/* Style each of the sides
with a fixed width and height */
.slide {
  float: left;
  height: 400px;
  width: 800px;
}
 
/* Add animation to the slides */
.slide-wrapper {
   
/* Calculate the total width on the
  basis of number of slides */
  width: calc(800px * 4);
 
/* Specify the animation with the
  duration and speed */
  animation: slide 10s ease infinite;
}
 

/* Define the animation
for the slideshow */
@keyframes slide {
   
/* Calculate the margin-left for
  each of the slides */
  20% {
    margin-left: 0px;
  }
 
  40% {
    margin-left: calc(-800px * 1);
  }
 
  60% {
    margin-left: calc(-800px * 2);
  }
 
  80% {
    margin-left: calc(-800px * 3);
  }
}

</style>
</head>
<body style="background-color:black; color:white">
<%@ include file="navbar.jsp" %>
<img src="images/splithomepage.png" width=100%>
<h3>We are available in cities like:-</h3>
<div id="slideshow">
        <div class="slide-wrapper">
             
        <!-- Define each of the slides
         and write the content -->
          
            <div class="slide">
            <h4>Kalyan</h4>
                <img src="images/new2.jpg" alt="logo image" /> 
            </div>
            <div class="slide">
            <h4>Thane</h4>
                 <img src="images/new1.jpg" alt="logo image" />  
            </div>
            <div class="slide">
            <h4>Mumbai</h4>
                <img src="images/new3.jpg" alt="logo image" />
            </div>
            <div class="slide">
            <h4>Dadar</h4>
                 <img src="images/4thjew.jpg" alt="logo image" />  
            </div>
        </div>
         
    </div>

</body>
</html>