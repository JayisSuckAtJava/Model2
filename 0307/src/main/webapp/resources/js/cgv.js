/***************************************
*	로그인 - 폼 체크	
***************************************/
function loginFormCheck(){
	let id, pass;
	id = document.getElementById("id");
	pass = document.getElementById("pass");
	
	if(id.value == ""){
		alert("아이디를 입력해주세요");
		id.focus();
		return false;
	}else if(pass.value == ""){
		alert("패스워드를 입력해주세요");
		pass.focus();
		return false;
	}else{
		loginForm.submit();
	}	
}

/***************************************
*	회원가입 - 폼 체크	
***************************************/
function joinFormCheck(){
	
	let id, pass, cpass, name, email1, email2, email3, addr1, addr2, hp1, hp2, hp3;
	id = document.getElementById("id");
	pass = document.getElementById("pass");
	cpass = document.getElementById("cpass");
	name = document.getElementById("name");
	email1 = document.getElementById("email1");
	email2 = document.getElementById("email2");
	email3 = document.getElementById("email3");
	addr1 = document.getElementById("addr1");
	addr2 = document.getElementById("addr2");
	hp1 = document.getElementById("hp1");
	hp2 = document.getElementById("hp2");
	hp3 = document.getElementById("hp3");
	
	if(id.value == ""){
		alert("아이디를 입력해주세요");
		id.focus();
		return false;
	}else if(pass.value == ""){
		alert("비밀번호를 입력해주세요");
		pass.focus();
		return false;
	}else if(cpass.value == ""){
		alert("비밀번호 확인을 입력해주세요");
		cpass.focus();
		return false;
	}else if(name.value == ""){
		alert("성명을 입력해주세요");
		name.focus();
		return false;
	}else if(checkCount("gender") == 0){
		alert("성별을 선택해주세요");
		return false;
	}else if(email1.value == ""){
		alert("이메일을 입력해주세요");
		email1.focus();
		return false;
	}else if(email2.value == ""){
		alert("이메일 주소를 선택해주세요");
		email3.focus();
		return false;
	}else if(addr1.value == ""){
		alert("주소를 입력해주세요");
		addr1.focus();
		return false;
	}else if(addr2.value == ""){
		alert("상세주소를 입력해주세요");
		addr2.focus();
		return false;
	}else if(checkCount("tel") == 0){
		alert("통신사를 선택해주세요");
		return false;
	}else if(hp1.value == "choice"){
		alert("핸드폰 번호를 선택해주세요");
		hp1.focus();
		return false;
	}else if(hp2.value == ""){
		alert("핸드폰 가운데 번호를 입력해주세요");
		hp2.focus();
		return false;
	}else if(hp3.value == ""){
		alert("핸드폰 마지막 번호를 입력해주세요");
		hp3.focus();
		return false;
	}else if(checkCount("hobby_list") == 0){
		alert("취미를 선택해주세요");
		return false;
	}else{
		joinForm.submit();
	}
	
	
}


/***************************************
*	회원가입 - 비밀번호, 비밀번호 확인 체크
***************************************/
function passCheck(){
	let pass, cpass, name, passmsg;
	pass = document.getElementById("pass");
	cpass = document.getElementById("cpass");
	name = document.getElementById("name");
	passmsg = document.getElementById("passmsg");
	
	if(pass.value != "" && cpass.value != ""){
		if(pass.value == cpass.value){
			//alert("비밀번호가 일치합니다.");
			passmsg.innerHTML = "*비밀번호가 동일합니다";
			passmsg.style.color = "blue";
			name.focus();
			return true;
		}else{
			//alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
			passmsg.innerHTML = "*비밀번호를 다시 입력해주세요";
			passmsg.style.color = "red";
			pass.value = "";
			cpass.value = "";
			pass.focus();
			return false;
		}		
	}
}

/***************************************
*	회원가입 - 성별, 통신사, 취미 체크 확인
***************************************/
function checkCount(pname){
	let list, count;
	list = document.getElementsByName(pname);
	count = 0;
	
	for(let i=0;i<list.length;i++){
		if(list[i].checked){
			count++;
		}
	}
	
	return count;
}


/***************************************
*	회원가입 - 이메일 주소 체크
***************************************/
function emailCheck(){
	let email2, email3;
	email2 = document.getElementById("email2");
	email3 = document.getElementById("email3");
	
	if(email3.value == "choice"){
		alert("다른 주소를 선택해주세요");
		email2.value = "";		
	}else if(email3.value == "self"){
		email2.value = "";
		email2.focus();
	}else{
		email2.value = email3.value;
	}
}



/***************************************
*	게시판 글쓰기 화면 - 폼체크
***************************************/
function boardFormCheck(){
	let btitle;
	btitle = document.getElementById("btitle");
	
	if(btitle.value == ""){
		alert("제목을 입력해주세요");
		btitle.focus();
		return false;
	}else{
		boardForm.submit();
	}
}

/***************************************
*	게시판 수정화면 - 폼체크
***************************************/
function boardUpdateFormCheck(){
	let btitle;
	btitle = document.getElementById("btitle");
	
	if(btitle.value == ""){
		alert("제목을 입력해주세요");
		btitle.focus();
		return false;
	}else{
		boardUpdateForm.submit();
	}
	
}

/***************************************
*	공지사항 글쓰기화면 - 폼체크
***************************************/
function noticeWriteFormCheck(){
	let ntitle;
	ntitle = document.getElementById("ntitle");
	
	if(ntitle.value == ""){
		alert("제목을 입력해주세요");
		ntitle.focus();
		return false;
	}else{
		noticeWriteForm.submit();
	}
}

/***************************************
*	공지사항 수정 화면 - 폼체크
***************************************/
function noticeUpdateFormCheck(){
	let ntitle;
	ntitle = document.getElementById("ntitle");
	
	if(ntitle.value == ""){
		alert("제목을 입력해주세요");
		ntitle.focus();
		return false;
	}else{
		noticeUpdateForm.submit();
	}
}


















