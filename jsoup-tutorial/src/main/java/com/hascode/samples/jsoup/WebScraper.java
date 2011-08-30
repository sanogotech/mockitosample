package com.hascode.samples.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScraper {
	public static void main(final String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.hascode.com/")
				.userAgent("Mozilla").timeout(6000).get();
		String title = doc.title(); // parsing the page's title
		System.out.println("The title of www.hascode.com is: " + title);
		Elements heading = doc.select("h2 > a"); // parsing the latest article's
													// heading
		System.out.println("The latest article is: " + heading.text());
		System.out.println("The article's URL is: " + heading.attr("href"));
		Elements editorial = doc.select("div.BlockContent-body small");
		System.out.println("The was created: " + editorial.text());
	}

}
