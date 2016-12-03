<%-- 
    Document   : mhome
    Created on : Dec 3, 2016, 1:41:01 PM
    Author     : hanumantharaobandarupalli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Team Everest Home</title>
    </head>
    <body background="Images/Kid.jpg">
        <!DOCTYPE html>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 30%;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 10px 12px 10px;
    position: relative;
}

img.avatar {
    width: 10%;
    border-radius: 50%;
}

.container {
    padding: 20px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    font-family:calibri;
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 30%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<center><br><br><br><br><br><br><br><br>
    <img src="Images/Small - Team Everest Logo.png">
<h1 style="font-family:calibri;">Team Everest is on of the Biggest Youth Run NGO in India.</h1><br><br><br><br>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign Up</button>
</center>
<div id="id01" class="modal">
  
  <form class="modal-content animate" action="action_page.php">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Images/Small - Team Everest Logo.png" alt="Avatar" class="avatar">
    </div>
      <center>
    <div class="container">
      <label><b>Username :</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required><br>

      <label><b>Password :&nbsp;</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required><br>
        
      <button type="submit">Login</button><br><br>
      <input type="checkbox" checked="checked"> Remember me
    </div>
      </center>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>
<div id="id02" class="modal">
  
  <form class="modal-content animate" action="action_page.php">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Images/Small - Team Everest Logo.png" alt="Avatar" class="avatar">
    </div>
      <center>
    <div class="container">
      <label><b>Fisrt Name :</b></label>
      <input type="text" placeholder="Enter First Name" name="fname" required><br>

      <label><b>Last Name :&nbsp;</b></label>
      <input type="password" placeholder="Enter Last Name" name="lsw" required><br>
      
      <label><b>Email ID :&nbsp;</b></label>
      <input type="password" placeholder="Enter Last Name" name="email" required><br>
      
      <label><b>Mobile :&nbsp;</b></label>
      <input type="password" placeholder="Enter Last Name" name="mobile" required><br>
        
      <button type="submit">Login</button><br><br>
      <input type="checkbox" checked="checked"> Remember me
    </div>
      </center>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>
    </body>
</html>
