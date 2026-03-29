package com.kush.pojo;

public class User {
	private int id;
	private String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
	  //return this.id;it will work if all user will have unique id.
		
	 /*This ensures that the hash code calculation takes into account both the id and name fields,
	  reducing the probability of collisions.*/
	  int result=17;
	  result = result * 31 + this.id;
	  result = result * 31 + (this.name !=null ? this.name.hashCode():0);
	  return result;
	}
	// return Objects.hash(id, name);

	
	/*
	 * Additionally, when using custom objects as keys in a HashMap, it's generally a good practice
	 *  to override the equals() method to provide a proper comparison between two objects. 
	 */
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    User user = (User) obj;
	    return id == user.id && (name != null ? name.equals(user.name) : user.name == null);
	}
	//      return id == user.id && Objects.equals(name, user.name);
	//	    return id == user.id && (name != null ? name.equals(user.name) : user.name == null);

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}
