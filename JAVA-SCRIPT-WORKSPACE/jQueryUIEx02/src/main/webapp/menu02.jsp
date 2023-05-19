<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Menu - Icons</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
	  $( function() {
	    $( "#menu" ).menu();
	  } );
  </script>
  <style>
  	.ui-menu { width: 150px; }
  </style>
</head>
	<body>
	 
		<ul id="menu">
		  <li>
		    <div><span class="ui-icon ui-icon-disk"></span>Save</div>
		  </li>
		  <li>
		    <div><span class="ui-icon ui-icon-zoomin"></span>Zoom In</div>
		  </li>
		  <li>
		    <div><span class="ui-icon ui-icon-zoomout"></span>Zoom Out</div>
		  </li>
		  <li class="ui-state-disabled">
		    <div><span class="ui-icon ui-icon-print"></span>Print...</div>
		  </li>
		  <li>
		    <div>Playback</div>
		    <ul>
		      <li>
		        <div><span class="ui-icon ui-icon-seek-start"></span>Prev</div>
		      </li>
		      <li>
		        <div><span class="ui-icon ui-icon-stop"></span>Stop</div>
		      </li>
		      <li>
		        <div><span class="ui-icon ui-icon-play"></span>Play</div>
		      </li>
		      <li>
		        <div><span class="ui-icon ui-icon-seek-end"></span>Next</div>
		      </li>
		    </ul>
		  </li>
		  <li>
		    <div>Learn more about this menu</div>
		  </li>
		</ul>
	 
	 
	</body>
</html>