package project;

import java.util.ArrayList;
import java.util.List;
//this class is to handle the list of valid users that can receive notifications and alerts from HSS
public class UserBean {
	List<User> entries;
	
	public UserBean() {
		entries = new ArrayList<User>();
	}
	
    public void setAddEntry( String dummy )
    {
        User entry = new User();
        entries.add( entry );
    }

    public User getLastEntry()
    {
        return entries.get( entries.size() - 1 );
    }

    public List<User> getEntries()
    {
        return entries;
    }

    public void setEntries( List<User> entries )
    {
        this.entries = entries;
    }
}
