<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/js/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<script>

	// problemas al ponerlo en un fichero externo
	var request;  
	function sendInfo()  
	{  
	var v=document.vinform.t1.value;  
	var url="ajax?val="+v;  
	  
	if(window.XMLHttpRequest){  
	request=new XMLHttpRequest();  
	}  
	else if(window.ActiveXObject){  
	request=new ActiveXObject("Microsoft.XMLHTTP");  
	}  
	  
	try{  
	request.onreadystatechange=getInfo;  
	request.open("GET",url,true);  
	request.send();  
	}catch(e){alert("Unable to connect to server");}  
	}  
	  
	function getInfo(){  
	if(request.readyState==4){  
	var val=request.responseText;  
	document.getElementById('amit').innerHTML=val;  
	}  
	}  

</script>
 
	<h1>Busqueda por nombre o por id</h1>
	<marquee>
		<h1>This is AWESOME PAPU</h1>
	</marquee>
	
	<form name="vinform" action="buscador"  method="GET">
		Buscador<input type="text" name="t1" onkeyup="sendInfo()">
	</form>

	<span id="amit"> </span>
	
</body>
</html>