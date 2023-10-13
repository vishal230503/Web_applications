

function  validate(frm){
	
	 //empty the old error messages
	document.getElementById("pnameErr").innerHTML="";
		document.getElementById("pageErr").innerHTML="";
	
	//chanage   hidden box valdation flag to yes indicating  that the client  side form validations are done
	  frm.vflag.value="yes"; 
	//read form data
	let  name=frm.pname.value;
	let  addrs=frm.paddrs.value;
	let  age=frm.page.value;
	//  perform  client side form validations
	let errorFlag=true;
	
	  if(name==""){  //required rule  on name
		document.getElementById("pnameErr").innerText=" <b>Person name is required</b>";
		errorFlag=false;
	}
	else if(name.length<3  || name.length>10){  //min length rule on name
		document.getElementById("pnameErr").innerHTML=" Person nname must have min of 3 chars and max of 10 chars";
			errorFlag=false;
	}
	
	  if(age==""){  //required rule  on age
		document.getElementById("pageErr").innerHTML=" Person age is required";
		errorFlag=false;
	}
	else if(isNaN(age)){  //numeric rule on age
		document.getElementById("pageErr").innerHTML=" Person age must be a numeric value";
		errorFlag=false;
	}
	else if(age<1 || age>100) {  // range rule on age
		document.getElementById("pageErr").innerHTML=" Person age must be in the range of 1 through  100";
		errorFlag=false;
	}
	
	  
	return errorFlag;
	 
	
}