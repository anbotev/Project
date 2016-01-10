
public class FirstStudent {
	String name;
	String secoundName;
	int num;
	int group;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecoundName() {
		return secoundName;
	}

	public void setSecoundName(String secoundName) {
		this.secoundName = secoundName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public FirstStudent(String name, String secoundName, int num, int group) {
		super();
		this.name = name;
		this.secoundName = secoundName;
		this.num = num;
		this.group = group;
	}
	
	

	@Override
	public String toString() {
		return name + " " + secoundName + " " + num + " " + group;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + ((secoundName == null) ? 0 : secoundName.hashCode());
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
		FirstStudent other = (FirstStudent) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (secoundName == null) {
			if (other.secoundName != null)
				return false;
		} else if (!secoundName.equals(other.secoundName))
			return false;
		return true;
	}
	

}
