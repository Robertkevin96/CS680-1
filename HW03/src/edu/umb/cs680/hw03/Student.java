package edu.umb.cs680.hw03;

public class Student {
	
	
	float tuition;
	public float getTuition() {
		return tuition;
	}


	public void setTuition(float tuition) {
		this.tuition = tuition;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getI20num() {
		return i20num;
	}


	public void setI20num(int i20num) {
		this.i20num = i20num;
	}


	public int getYrsInState() {
		return yrsInState;
	}


	public void setYrsInState(int yrsInState) {
		this.yrsInState = yrsInState;
	}


	public String getUsAddr() {
		return usAddr;
	}


	public void setUsAddr(String usAddr) {
		this.usAddr = usAddr;
	}


	public String getForeignAddr() {
		return foreignAddr;
	}


	public void setForeignAddr(String foreignAddr) {
		this.foreignAddr = foreignAddr;
	}


	public String getPriorStateAddr() {
		return priorStateAddr;
	}


	public void setPriorStateAddr(String priorStateAddr) {
		this.priorStateAddr = priorStateAddr;
	}


	public StudentStatus getStatus() {
		return status;
	}


	public void setStatus(StudentStatus status) {
		this.status = status;
	}


	String name;
	int i20num;
	int yrsInState;
	String usAddr;
	String foreignAddr;
	String priorStateAddr;
	private StudentStatus status = null;
	

	Student(String name, String usAddr, int yrsInState, int i20num,
			String foreignAddr, StudentStatus status)
	{
		this.name=name;
		this.usAddr=usAddr;
		this.yrsInState=yrsInState;
		this.i20num=i20num;
		this.foreignAddr=foreignAddr;
		this.status=status;
	}

}
