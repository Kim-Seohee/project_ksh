package studentmanagement;

public class Student {
	private String name;
	private String gender;
	private String birth;
	private String className;
	private String phone;
	private String address;
	private String regDay;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegDay() {
		return regDay;
	}
	public void setRegDay(String regDay) {
		this.regDay = regDay;
	}
	public Student(String name, String gender, String birth, String className, String phone, String address,
			String regDay) {
		super();
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.className = className;
		this.phone = phone;
		this.address = address;
		this.regDay = regDay;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((regDay == null) ? 0 : regDay.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (regDay == null) {
			if (other.regDay != null)
				return false;
		} else if (!regDay.equals(other.regDay))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", birth=" + birth + ", className=" + className
				+ ", phone=" + phone + ", adress=" + address + ", regDay=" + regDay + "]";
	}
	public void update(String name, String gender, String birth, String className, String phone, String address,
			String regDay) {
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.className = className;
		this.phone = phone;
		this.address = address;
		this.regDay = regDay;
	}
}
