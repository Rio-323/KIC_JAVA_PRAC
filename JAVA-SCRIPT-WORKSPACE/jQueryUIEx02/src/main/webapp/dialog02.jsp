<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/base/jquery-ui.css"/>
<style type="text/css">
   body { font-size:80%;}
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 700px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  
</style>
<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript" src="./js/datepicker-ko.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
      $('#dialog-form').dialog({
         autoOpen: false,
         modal: true,
         width: 350,
         height: 400,
         resizable: false,
         buttons: {
            '취소' : function() {
               $(this).dialog('close');
            },
            '추가' : function() {
               let html = '<tr>';
               html += '<td>' + 1 + '</td>';
               html += '<td>' + $('#name').val() + '</td>';
               html += '<td>' + $('#email').val() + '</td>';
               html += '<td>' + $('#password').val() + '</td>';
               html += '</tr>';
               
               $('#users tbody').append(html);
               
               $(this).dialog('close');
            }
         }
      });
      
      $('#btn1').button().on('click', function() {
         $('#dialog-form').dialog('open');
      });
   });
</script>
</head>
<body>

<button id="btn1">추가</button>

<br/><hr/><br/>

<div id="users-contain" class="ui-widget">
  <h1>Existing Users:</h1>
  <table id="users" class="ui-widget ui-widget-content">
    <thead>
      <tr class="ui-widget-header ">
        <th>Seq</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>John Doe</td>
        <td>john.doe@example.com</td>
        <td>johndoe1</td>
      </tr>
    </tbody>
  </table>
</div>

<div id="dialog-form" title="Create new user">
  <p class="validateTips">All form fields are required.</p>
 
  <form>
    <fieldset>
      <label for="name">Name</label>
      <input type="text" name="name" id="name" value="Jane Smith" class="text ui-widget-content ui-corner-all">
      <label for="email">Email</label>
      <input type="text" name="email" id="email" value="jane@smith.com" class="text ui-widget-content ui-corner-all">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" value="xxxxxxx" class="text ui-widget-content ui-corner-all">
 
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>
</body>
</html>