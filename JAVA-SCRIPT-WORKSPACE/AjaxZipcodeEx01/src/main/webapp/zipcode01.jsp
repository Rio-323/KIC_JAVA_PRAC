<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			window.onload = function() {
				  document.getElementById('btn').onclick = function() {
				    const strDong = document.getElementById('dong').value.trim();
				    if(strDong.length < 2) {
				      alert("동 이름을 2자 이상 입력해주세요.");
				    } else {
				      const request = new XMLHttpRequest();
				      
				      request.onreadystatechange = function() {
				    	  
				    	  if(request.readyState == 4) {
								if(request.status == 200) {
									const result = showData(request.responseXML);
									//console.log(result);
									
									document.getElementById('result').innerHTML = result;
								} else {
									alert('페이지 처리 에러');
								}
							}
				    	  
				      };
				      
				      request.open("get", "./data/data_xml.jsp?strDong=" + strDong, true);
				      request.send();
				      
				    }
				  };
				  
				  const showData = function(xmlData) {
					  const zipcodes = xmlData.getElementsByTagName("zipcode");
					  const sidos = xmlData.getElementsByTagName("sido");
					  const guguns = xmlData.getElementsByTagName("gugun");
					  const dongs = xmlData.getElementsByTagName("dong");
					  const ris = xmlData.getElementsByTagName("ri");
					  const bunjis = xmlData.getElementsByTagName("bunji");
					  
					  let result = '<table width="800" border="1">';
					  for(let i = 0; i < zipcodes.length; i++) {
						  result += "<tr>";
						  result += "<td>" + zipcodes[i].innerHTML + "</td>";
						  result += "<td>" + sidos[i].innerHTML + "</td>";
						  result += "<td>" + guguns[i].innerHTML + "</td>";
						  result += "<td>" + dongs[i].innerHTML + "</td>";
						  result += "<td>" + ris[i].innerHTML + "</td>";
						  result += "<td>" + bunjis[i].innerHTML + "</td>";
						  result += "</tr>";
					  }
					  
					  result += '</table>';
					  
					  return result;
				  }
				};
		</script>
	</head>
	<body>
		<input type="text" id="dong"><button id="btn">동이름 검색</button>
		<br><hr><br>
		<div id="result"></div>
	</body>
</html>