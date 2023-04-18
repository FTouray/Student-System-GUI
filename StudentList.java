package addStudentGUI;


/** Superclass that contains the student info. */

class StudentList {

	//Defining Student
	private String name;
	private String address;
	
	//Blank Constructor
	public StudentList()
	{
		this.name = "";
		this.address = "";
	}
	
	//Constructor to store details
	public StudentList(String name, String address)
	{
		this.name = name;
		this.address = address;
	}
	
	//Getters
	public String getName()
    {
        return this.name;
    }
	
	public String getAddress()
    {
        return this.address;
    }
	
	//Setters
	public void setName(String name)
    {
        this.name = name;
    }
	
	public void setAddress(String address)
    {
        this.address = address;
    }
	
	//ToString - print out student info
	public String toString()
	{
		String result;
		
		result = "•" + this.name + ", " + this.address + "\n";
		
		return result;
	}
}
