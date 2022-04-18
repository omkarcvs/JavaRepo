function help(entityName,elementId,elementText) {		
	var popup;
	var url="<%=request.getContextPath()%><%=IURLUtil.NEW_RECORD%>studentAdmissionHelp?pHelp="+entityName+"&elementId="+elementId+"&elementText="+elementText;;
	popup=window.open (url,"mywindow",  "width=700,height=600","status=1");
	popup.focus();
   return false
	//document.getElementById('studentAdmissionHelp').submit();
}

function helpByNameQuery(namedQuery,searchIdPk,elementId,elementText) {	
	// alert('namedQuery : '+namedQuery+'     searchIdPk : '+searchIdPk+'    elementId + :  '+elementId+'    elementText : '+elementText);
	 var entityName = namedQuery.substr(0, namedQuery.indexOf('.')); 
	// alert('entityName : '+entityName);
	// alert('searchIdPk : '+document.getElementById(searchIdPk).value);
	 var popup;
	var url="<%=request.getContextPath()%><%=IURLUtil.NEW_RECORD%>studentAdmissionHelpByNameQuery?pHelp="+entityName+"&elementId="+elementId+"&elementText="+elementText+"&namedQuery="+namedQuery+"&searchIdPk="+document.getElementById(searchIdPk).value;
	popup=window.open (url,"mywindow", "width=700,height=600", "status=1");
	popup.focus();
    return false
	//document.getElementById('studentAdmissionHelp').submit();
}
/*This is use to clear the textbox on the basis of passed id*/
function clearTextBox(arrIdStr)
{
	  var arrIds=arrIdStr.split(",");	  
	  for (i = 0; i < arrIds.length; i++) 
	  {		
		  document.getElementById(arrIds[i]).value='';
		  document.getElementById(arrIds[i]).focus();
	  } 
}

