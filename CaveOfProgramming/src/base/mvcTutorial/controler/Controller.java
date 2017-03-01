package base.mvcTutorial.controler;

import base.mvcTutorial.model.Database;
import base.mvcTutorial.model.Model;
import base.mvcTutorial.model.Person;
import base.mvcTutorial.view.AppListener;
import base.mvcTutorial.view.CreateUserEvent;
import base.mvcTutorial.view.CreateUserListener;
import base.mvcTutorial.view.SaveListener;
import base.mvcTutorial.view.View;

public class Controller implements CreateUserListener, SaveListener, AppListener
{
	private View view;
	private Model model;

	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}

	@Override
	public void onUserCreated(CreateUserEvent event)
	{
		model.addPerson(new Person(event.getName(), event.getPassword()));
	}

	@Override
	public void onSave()
	{
		try
		{
			model.save();
		} catch (Exception e)
		{
			view.showError("Error saving to database.");
		}
	}

	@Override
	public void onOpen()
	{
		try
		{
			Database.getInstance().connect();
		} catch (Exception e)
		{
			view.showError("Cannot connect to database.");
		}

		try
		{
			model.load();
		} catch (Exception e)
		{
			view.showError("Error loading data from database.");
		}
	}

	@Override
	public void onClose()
	{
		Database.getInstance().disconnect();
	}
}