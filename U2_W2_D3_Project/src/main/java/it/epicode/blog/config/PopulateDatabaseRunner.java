package it.epicode.blog.config;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import it.epicode.blog.entities.Article;
import it.epicode.blog.entities.Author;
import it.epicode.blog.entities.Category;
import it.epicode.blog.services.ArticleService;
import it.epicode.blog.services.AuthorService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PopulateDatabaseRunner implements CommandLineRunner {

	@Autowired
	ArticleService articles;
	@Autowired
	AuthorService authors;

	private static final Faker faker = Faker.instance();

	@Override
	public void run(String... args) throws Exception {
		log.info("Populating database...");
		IntStream.range(0, 10) //
				.mapToObj(n -> Author.builder() //
						.withAvatar(faker.avatar().image())//
						.withBirthday(
								LocalDate.ofInstant(faker.date().birthday(16, 60).toInstant(), ZoneId.systemDefault())) //
						.withEmail(faker.internet().emailAddress()) //
						.withName(faker.name().firstName()) //
						.withSurname(faker.name().lastName()) //
						.build())
				.forEach(authors::save);
		var a = authors.getAuthors();
		IntStream.range(0, 100) //
				.mapToObj(n -> Article.builder() //
						.withAuthor(a.get(faker.random().nextInt(a.size()))) //
						.withCategory( //
								Category.builder().withName(faker.numerify("Category #")).build()//
						) //
						.withContent(faker.lorem().paragraph(faker.random().nextInt(20))) //
						.withCover(faker.avatar().image()) //
						.withReadingTime(faker.random().nextInt(30)) //
						.withTitle(faker.lorem().sentence()) //
						.build())
				.forEach(articles::save);
		log.info("Database populated");
	}

}
