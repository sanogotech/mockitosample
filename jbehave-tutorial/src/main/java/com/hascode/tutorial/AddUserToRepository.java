package com.hascode.tutorial;

import java.util.List;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

public class AddUserToRepository extends JUnitStory {
	private UserDao	userDao;

	@Given("a user repository")
	public void aUserRepository() {
		userDao = new UserDao();
	}

	@When("the user adds $amount users to the user repository")
	public void userAddsUsersToRepository(final int amount) {
		for (int i = 0; i < amount; i++) {
			final User user = new User();
			user.setName("user " + i);
			userDao.save(user);
		}
	}

	@Then("the user repository must contain $amount users")
	public void productMustBeListed(final int amount) {
		Assert.assertEquals(amount, userDao.findAll().size());
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}

	@Override
	@Test
	public void run() throws Throwable {
		super.run();
	}
}
