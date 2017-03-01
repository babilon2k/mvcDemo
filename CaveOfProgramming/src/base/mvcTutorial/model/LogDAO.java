package base.mvcTutorial.model;

import java.util.List;

public interface LogDAO
{
	public void addEntry(String message);

	public List<Log> getEntries(int number);
}
