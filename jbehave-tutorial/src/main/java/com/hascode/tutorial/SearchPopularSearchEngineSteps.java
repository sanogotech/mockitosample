package com.hascode.tutorial;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.SeleniumSteps;

import com.thoughtworks.selenium.Selenium;

public class SearchPopularSearchEngineSteps extends SeleniumSteps {

	private final String	pageLoadTimeout	= "6000";

	public SearchPopularSearchEngineSteps(final Selenium selenium) {
		super(selenium);
	}

	@Given("The Google homepage")
	public void theGoogleHomepage() {
		selenium.open("/");
	}

	@When("I search for \"$term\"")
	public void searchForTerm(final String term) throws InterruptedException {
		selenium.type("q", term);
		selenium.click("btnG");
		Thread.sleep(4000l); // ugly
	}
	@Then("the text \"$textFragment\" is present")
	public void shouldSee(final String textFragment) {
		assertThat(selenium.getBodyText(), containsString(textFragment));
	}

	@When("I click the link \"$linkText\"")
	public void followLinkWithText(final String linkText) {
		selenium.click("link=" + linkText);
		selenium.waitForPageToLoad(pageLoadTimeout);
	}

	@Then("the page's URL should be \"$url\"")
	public void pageURLShouldBe(final String url) {
		assertThat(selenium.getLocation(), is(url));
	}
}
