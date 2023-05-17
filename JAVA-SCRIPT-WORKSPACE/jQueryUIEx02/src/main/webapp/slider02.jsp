<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/cupertino/jquery-ui.css">
		<style type="text/css">
			
			#red, #green, #blue {
			    float: left;
			    clear: left;
			    width: 300px;
			    margin: 15px;
		   	}
		   	
			#swatch {
			   width: 120px;
			   height: 100px;
			   margin-top: 18px;
			   margin-left: 350px;
			   background-image: none;
			}
			
		    #red .ui-slider-range { background: #ef2929; }
		    #red .ui-slider-handle { border-color: #ef2929; }
		    #green .ui-slider-range { background: #8ae234; }
		    #green .ui-slider-handle { border-color: #8ae234; }
		    #blue .ui-slider-range { background: #729fcf; }
		    #blue .ui-slider-handle { border-color: #729fcf; }
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.js"></script>
		<script type="text/javascript">
			$( function() {
			    function hexFromRGB(r, g, b) {
			      var hex = [
			        r.toString( 16 ),
			        g.toString( 16 ),
			        b.toString( 16 )
			      ];
			      
			      $.each( hex, function( nr, val ) {
			        if ( val.length === 1 ) {
			          hex[ nr ] = "0" + val;
			        }
			      });
			      
			      return hex.join( "" ).toUpperCase();
			    }
			    
			    function refreshSwatch() {
			      var red = $( "#red" ).slider( "value" ),
			        green = $( "#green" ).slider( "value" ),
			        blue = $( "#blue" ).slider( "value" ),
			        hex = hexFromRGB( red, green, blue );
			      $( "#swatch" ).css( "background-color", "#" + hex );
			    }
			 
			    $( "#red, #green, #blue" ).slider({
			      orientation: "horizontal",
			      range: "min",
			      max: 255,
			      value: 127,
			      slide: refreshSwatch,
			      change: refreshSwatch
			    });
			    
			    $( "#red" ).slider( "value", 255 );
			    
			    $( "#green" ).slider( "value", 140 );
			    
			    $( "#blue" ).slider( "value", 60 );
			    
			  } );
		</script>
	</head>
	<body class="ui-widget-content" style="border:0;">
 
		<p class="ui-state-default ui-corner-all ui-helper-clearfix" style="padding:4px;">
  		<span class="ui-icon ui-icon-pencil" style="float:left; margin:-2px 5px 0 0;"></span>
  		Simple Colorpicker
		</p>
 
		<div id="red"></div>
		<div id="green"></div>
		<div id="blue"></div>
 
		<div id="swatch" class="ui-widget-content ui-corner-all"></div>
 
 
	</body>
</html>