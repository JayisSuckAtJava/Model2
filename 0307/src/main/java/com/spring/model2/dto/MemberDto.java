package com.spring.model2.dto;

public class MemberDto {
	//Field
	/*
	 * DB에 별도로 수정해서 넣는 필드 : email, address, hp_num, hobby 
	 * tel 필드는 member 테이블의 hp_comp 필드와 매핑
	 */
	int rno;
	String id, pass, name, gender, email1, email2, email, addr1, addr2, address, tel,hp_comp,
		hp1, hp2, hp3, hp_num, intro, hobby;
	String[] hobby_list;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getEmail() {
		if(email1 != null) {
			email = email1 +"@"+email2;
		}
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddress() {
		if(addr1==null) {
			return address;
		}
		return addr1 +"  " + addr2;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHp_comp() {
		if(hp_comp==null) {
			return tel;
		}
		return hp_comp;
	}
	public void setHp_comp(String hp_comp) {
		this.hp_comp = hp_comp;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getHp_num() {
		if(hp1 != null) {
			hp_num = hp1+"-" +hp2+"-"+hp3;
		}
		return hp_num;
	}
	public void setHp_num(String hp_num) {
		this.hp_num = hp_num;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getHobby() {
		if(hobby_list != null) {
			hobby = String.join(",", hobby_list);
		}		
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String[] getHobby_list() {
		return hobby_list;
	}
	public void setHobby_list(String[] hobby_list) {			
		this.hobby_list = hobby_list;
	}	
	
	
}
