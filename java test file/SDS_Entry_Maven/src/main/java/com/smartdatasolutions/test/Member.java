package com.smartdatasolutions.test;

public class Member {

	private String	id;
	private String	address;
	private String	city;
	private String	firstName;
	private String	lastName;
	private String	state;
	private String	zip;

	public void setId( String id ) {
		this.id = id;
	}

	public String getId( ) {
		return id;
	}

	public String getAddress( ) {
		return address;
	}

	public String getCity( ) {
		return city;
	}

	public String getFirstName( ) {
		return firstName;
	}

	public String getLastName( ) {
		return lastName;
	}

	public String getState( ) {
		return state;
	}

	public String getZip( ) {
		return zip;
	}

	public void setAddress( String address ) {
		this.address = address;
	}

	public void setCity( String city ) {
		this.city = city;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public void setState( String state ) {
		this.state = state;
	}

	public void setZip( String zip ) {
		this.zip = zip;
	}

	public String toCSVString() {
        // Converting member details to CSV format
        return String.join(",", id, firstName, lastName, address, city, zip);
    }

    // Overriding equals and hashCode to identify duplicate members
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) &&
                Objects.equals(firstName, member.firstName) &&
                Objects.equals(lastName, member.lastName) &&
                Objects.equals(address, member.address) &&
                Objects.equals(city, member.city) &&
                Objects.equals(state, member.state) &&
                Objects.equals(zip, member.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, city, state, zip);
    }

}
