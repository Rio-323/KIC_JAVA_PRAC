<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
		<title>Insert title here</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
		<style type="text/css">
			body { font-size: 80%; }
			
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
		<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
		<script type="text/javascript">
			$( document ).ready( function() {
				$( '#write-form' ).dialog({
					autoOpen: false,
					modal: true,
					width: 350,
					height: 400,
					resizable: false,
					buttons: {
						'취소': function() {
							$( this ).dialog( 'close' );
						},
						'추가': function() {
							writeServer($( '#w_name' ).val(), 
										$( '#w_password' ).val(), 
										$( '#w_email' ).val(), 
										$( '#w_address' ).val());
							
						}
					}
				});
				
				$( '#delete-form' ).dialog({
					autoOpen: false,
					modal: true,
					width: 350,
					height: 400,
					resizable: false,
					buttons: {
						'취소': function() {
							$( this ).dialog( 'close' );
						},
						'삭제': function() {
							
						}
					}
				});
				
				$( '#modify-form' ).dialog({
					autoOpen: false,
					modal: true,
					width: 350,
					height: 400,
					resizable: false,
					buttons: {
						'취소': function() {
							$( this ).dialog( 'close' );
						},
						'수정': function() {
							
						}
					}
				});
				
				$( '#btn1' ).button().on( 'click', function() {
					$( '#write-form' ).dialog( 'open' ); 
				});
				
				//
				listServer();
			});
			
			const writeServer = function(name, password, email, address) {
				$.ajax({
					url:'./data/user_write.jsp',
					type: 'get',
					data: {
						name: name,
						password: password,
						email: email,
						address: address
					},
					dataType: 'xml',
					success: function(xml) {
						// console.log($(xml).find('flag').text());
						
						if($(xml).find('flag').text() == 0) {
							alert('입력 완료');
							
							listServer();
							
							$( '#w_name' ).val('');
							$( '#w_password' ).val(''); 
							$( '#w_email' ).val(''); 
							$( '#w_address' ).val('');
							
							
							$('#write-form').dialog('close');
						} else {
							alert("[Error] : " + $(xml).find('flag').text());
						}
					},
					error: function(e) {
						alert('[Error] : ' + e.status);
					}
				});
			};
			
			const listServer = function() {
				$.ajax({
					url: './data/user_list.jsp',
					type: 'get',
					dataType: 'xml',
					success: function(xml) {
						let result = '';
						//
						$( '#users tbody' ).empty();
						
						$(xml).find('user').each(function() {
							let seq = $(this).find('seq').text();
							let name = $(this).find('name').text();
							let email = $(this).find('email').text();
							let address = $(this).find('address').text();
							
							result += '<tr>';
							result += '<td>' + seq + '</td>';
							result += '<td>' + name + '</td>';
							result += '<td>' + email + '</td>';
							result += '<td>' + address + '</td>';
							result += '  <td>';
							result += '  <button onclick="modifyBtn('+ seq + ')">수정</button>';
							result += '	 <button onclick="deleteBtn('+ seq + ')">삭제</button>';
							result += '  </td>';
							result += '</tr>';
					    });

					  
					    $( '#users tbody' ).append( result );
					    
					    $('button').button();
					},
					error: function(e) {
						alert('[Error] : ' + e.status);s
					}
				});
			};
			
			const modifyBtn = function(seq) {
				// alert(seq);
				
				$('#m_seq').val(seq);
				
				// name / email / address
				// 1.서버
				// 2. html 파싱
				console.log($('tbody > tr > td:contains(1)').parent().children().eq(1).text());
				console.log($('tbody > tr > td:contains(1)').parent().children().eq(2).text());
				console.log($('tbody > tr > td:contains(1)').parent().children().eq(3).text());
				
				$('#modify-form').dialog('open');
			};
			
			const deleteBtn = function(seq) {
				// alert(seq);

				$('#d_seq').val(seq);
				$('#delete-form').dialog('open');
			};
		</script>
		</head>
	<body>
	
		<button id="btn1">사용자 추가</button>
		
		<br /><hr /><br />
		
		<div id="users-contain" class="ui-widget">
			<h1>Existing Users:</h1>
			<table id="users" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header ">
					<th>Seq</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			</table>
		</div>
		
		<div id="write-form" title="Insert new user">
			<p class="validateTips">All form fields are required.</p>
		 	<form>
				<fieldset>
					<label for="w_name">Name</label>
					<input type="text" id="w_name" value="" class="text ui-widget-content ui-corner-all" />
					<label for="w_password">Password</label>
					<input type="password" id="w_password" value="" class="text ui-widget-content ui-corner-all" />
					<label for="w_email">Email</label>
					<input type="text" id="w_email" value="" class="text ui-widget-content ui-corner-all" />
					<label for="w_address">Address</label>
					<input type="text" id="w_address" value="" class="text ui-widget-content ui-corner-all" />
					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px" />
				</fieldset>
			</form>
		</div>
		
		<div id="delete-form" title="Delete user">
		 	<form>
				<fieldset>
					<label for="d_seq">Seq</label>
					<input type="text" id="d_seq" class="text ui-widget-content ui-corner-all" readonly="readonly" />
					<label for="d_password">Password</label>
					<input type="password" id="d_password" class="text ui-widget-content ui-corner-all" />
					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px" />
				</fieldset>
			</form>
		</div>

		<div id="modify-form" title="Modify user">
		 	<form>
				<fieldset>
					<label for="m_seq">Seq</label>
					<input type="text" id="m_seq" class="text ui-widget-content ui-corner-all" readonly="readonly" />
					<label for="m_name">Name</label>
					<input type="text" id="m_name" class="text ui-widget-content ui-corner-all" readonly="readonly" />
					<label for="m_password">Password</label>
					<input type="password" id="m_password" class="text ui-widget-content ui-corner-all" />
					<label for="m_email">Email</label>
					<input type="text" id="m_email" class="text ui-widget-content ui-corner-all" />
					<label for="m_address">Address</label>
					<input type="text" id="m_address" class="text ui-widget-content ui-corner-all" />
					<input type="submit" tabindex="-1" style="position:absolute; top:-1000px" />
				</fieldset>
			</form>
		</div>
		
	
	</body>
</html>