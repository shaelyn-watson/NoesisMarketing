<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.noesis.webinar.*" %>


<html>
<head>
    <title>Upcoming webinars</title>
    
    <link rel="stylesheet" type="text/css" href="webinar.css">
    <link rel="stylesheet" href="calendarview.css" type="text/css" />

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.min.js"></script>
    <script src="prototype.js" type="text/javascript"></script>
    <script src="calendarview.js" type="text/javascript"></script>

    <style>
      div.calendar {
        max-width: 600px;
        margin-left: auto;
        margin-right: auto;
      }
      div.calendar table {
        width: 100%;
      }
      div.dateField {
        width: 140px;
        padding: 6px;
        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
        color: #555;
        background-color: white;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
      }
      div#popupDateField:hover {
        background-color: #999;
        cursor: pointer;
      }
    </style>

</head>

<body style="padding:15px;">
	<header>

		<br>
        <div class="media">
			<span class="pull-left">

			<img class="img-circle" src="lacey-avatar-small.png" style="background:#E1E1E1;max-width: 5em;border: .35em solid #F1F1F1;"/>

			</span>
			<td style="margin: 0; padding: 0;"> 
			<div class="media-body" style="display: block; position: relative; padding: 8px;"> <table style="margin: 0; padding: 0;"><tr style="margin: 0; padding: 0;"><td style="margin: 0; padding: 0;"> 
			<p class="well ne-5-bg">

			<span class="handwritten text-primary lead">Upcoming Webinars</span><br><span style="position: absolute; top: 20%; left: 0px; margin: 0; padding: 0;"><img src="http://noesisimg.s3.amazonaws.com/Marketing/pages/triangle-sm-blu-left.png" style="max-width: 100%; margin: 0; padding: 0;"></span> </p>

			</td>
			</tr></table></div> 
			</td> 
		</div>

		<hr>
	</header>

<%
	WebinarConnector wc = new WebinarConnector();

	List<WebinarData> upcomingWebinars = wc.getUpcomingWebinars();
%>

	<nav>
		<ul>
<% if (upcomingWebinars != null)
	{
		for (WebinarData webinar : upcomingWebinars)
		{
		List<DateAndTime> times = webinar.getDatesAndTimes();	
		%>

		<p><%=webinar.getSubject()%></p>


		<ul style="list-style-position:inside;">
			<%for (DateAndTime when : times){
				String url = "webinarSignUp.jsp?webinarID="+when.getWebinarKey();%>
				<li><a href=<%=url%>><%=when.getDay()%> <%=when.getDate()%> <%=when.getStartTime()%> - <%=when.getEndTime()%> CDT</a>
			<%}%>
			</li>
		</ul>
<%
		}
	}
%>
		</ul>
	</nav>

<script type="text/javascript">
  window.onload = function() {
    Calendar.setup(
      {
        dateField      : 'embeddedDateField',
        parentElement  : 'embeddedCalendar'
      }
    )
  }
</script>
<div id="embeddedExample" style="">
            <div id="embeddedCalendar" style="margin-left: auto; margin-right: auto">
            </div>
            <br />
            <div id="embeddedDateField" class="dateField">
              Select Date
            </div>
            <br />
          </div>


</body>
</html>