package work.model.dto;

import java.util.Date;

/** 사용내역 클래스 */
public class UseList {
	
	/** 회원 아이디 */
	private String memberId;
	
	/** 좌석번호 */
	private int seatNo;
	
	/** 이용시간 */
	private int useTime;
	
	/** 이용요금 */
	private int cost;
	
	/** 적립예정 마일리지 */
	private int mileageAdd;
	
	/** 걸제시각 */
	private Date payTime;
	
	public UseList() {}

	public UseList(String memberId, int seatNo) {
		this.memberId = memberId;
		this.seatNo = seatNo;
	}

	public UseList(String memberId, int seatNo, int useTime, int cost, int mileageAdd, Date payTime) {
		this.memberId = memberId;
		this.seatNo = seatNo;
		this.useTime = useTime;
		this.cost = cost;
		this.mileageAdd = mileageAdd;
		this.payTime = payTime;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public int getUseTime() {
		return useTime;
	}

	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getMileageAdd() {
		return mileageAdd;
	}

	public void setMileageAdd(int mileageAdd) {
		this.mileageAdd = mileageAdd;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Override
	public String toString() {
		return memberId + ", " + seatNo + ", " + useTime + ", " + cost + ", " + mileageAdd + ", " + payTime;
	}
	
}
