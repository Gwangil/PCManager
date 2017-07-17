package work.model.dto;

import java.sql.Timestamp;

public class Member {
	
	private String memberId;			// 아이디
	private String memberPw; 	// 비밀번호
	private String memberName;		// 이름
	private String gender;		// 성별
	private String birthyy;		// 생일 - 년
	private String birthmm;		// 생일 - 월
	private String birthdd;		// 생일 - 일
	private String mail1;		// 이메일 - @ 앞부분
	private String mail2;		// 이메일 - @ 뒷부분
	private String phone;		// 전화
	private String address;		// 주소
	private Timestamp entryDate;		// 가입일
	private int	mileage;
	
	public String getId() {return memberId;}
	public void setId(String id) {this.memberId = id;}
	
	public String getPassword() {return memberPw;}
	public void setPassword(String password) {this.memberPw = password;}
	
	public String getName() {return memberName;}
	public void setName(String name) {this.memberName = name;}
	
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	
	public String getBirthyy() {return birthyy;}
	public void setBirthyy(String birthyy) {this.birthyy = birthyy;}
	public String getBirthmm() {return birthmm;}
	public void setBirthmm(String birthmm) {this.birthmm = birthmm;}
	public String getBirthdd() {return birthdd;}
	public void setBirthdd(String birthdd) {this.birthdd = birthdd;}
	
	public String getMail1() {return mail1;}
	public void setMail1(String mail1) {this.mail1 = mail1;}
	public String getMail2() {return mail2;}
	public void setMail2(String mail2) {this.mail2 = mail2;}
	
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	public Timestamp getReg() {return entryDate;}
	public void setReg(Timestamp entryDate) {this.entryDate = entryDate;}
	
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberId=");
		builder.append(memberId);
		builder.append(", memberPw=");
		builder.append(memberPw);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", birthyy=");
		builder.append(birthyy);
		builder.append(", birthmm=");
		builder.append(birthmm);
		builder.append(", birthdd=");
		builder.append(birthdd);
		builder.append(", mail1=");
		builder.append(mail1);
		builder.append(", mail2=");
		builder.append(mail2);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", address=");
		builder.append(address);
		builder.append(", entryDate=");
		builder.append(entryDate);
		builder.append(", mileage=");
		builder.append(mileage);
		builder.append("]");
		return builder.toString();
	}
	
	
}
