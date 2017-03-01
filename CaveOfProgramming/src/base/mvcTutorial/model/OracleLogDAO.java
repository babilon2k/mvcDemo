package base.mvcTutorial.model;

import java.util.List;

public class OracleLogDAO implements LogDAO
{
	@Override
	public void addEntry(String message)
	{
		// Not implemented.
		// Get current time and add log message to database.
	}

	@Override
	public List<Log> getEntries(int number)
	{
		// Not implemented. Get latest "number" log messages.
		return null;
	}
}
