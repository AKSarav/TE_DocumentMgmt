<%@page import="com.sarav.donormgmttool.GoogleAuthHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DonorMgmtTool-Login</title>
<style>
body {
	font-family: Sans-Serif;
	margin: 1em;
}
</style>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
  <script src="https://use.fontawesome.com/946a29a83c.js"></script>
</head>
<body>
	<div class="oauthDemo">
		<%
			/*
			 * The GoogleAuthHelper handles all the heavy lifting, and contains all "secrets"
			 * required for constructing a google login url.
			 */
			final GoogleAuthHelper helper = new GoogleAuthHelper();
			if (request.getParameter("code") == null
					|| request.getParameter("state") == null) {
				/*
				 * initial visit to the page
				 */ %>
<div class="container col-md-4 col-md-offset-4">
  <div class="jumbotron">

    <div class="text-center">

      <div class="row-fluid">
          <img src="http://www.teameverestindia.org/diwali2016/wp-content/uploads/2016/10/Team-Everest-Logo.png" alt="TeamEverest" height="70" width="70">
        <h2 class="rw-sentence" style="
    
  color: #36A8FF;
    
    font-size: 30px;
font-family:calibri">
          Welcome to <br>E-Receipt and Donation Management Tool!
        </h2> <br>
      </div>
    </div>
      <div class="col-md-offset-2">
      <button type="button" class="btn btn-primary">
       <i class="fa fa-google" style="color:orange;"></i>
       <a href="<%=helper.buildLoginUrl()%>"><span style="color:white; font-weight:bold">Signin with Google</span></a>
       </button>
      </div>
  </div>
  </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

			<%			
				/*
				 * set the secure state token in session to be able to track what we sent to google
				 */
				session.setAttribute("state", helper.getStateToken());
			} else if (request.getParameter("code") != null && request.getParameter("state") != null
					&& request.getParameter("state").equals(session.getAttribute("state"))) {
				session.removeAttribute("state");
				out.println("<pre>");
				/*
				 * Executes after google redirects to the callback url.
				 * Please note that the state request parameter is for convenience to differentiate
				 * between authentication methods (ex. facebook oauth, google oauth, twitter, in-house).
				 * 
				 * GoogleAuthHelper()#getUserInfoJson(String) method returns a String containing
				 * the json representation of the authenticated user's information. 
				 * At this point you should parse and persist the info.
				 */
// New location to be redirected
   String site = new String(request.getContextPath().toString()+"/action.do");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 				
			}

		%>
	</div>

</body>
</html>