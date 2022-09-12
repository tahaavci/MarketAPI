package com.market.api;

import com.market.api.Model.Comment;
import com.market.api.Model.Customer;
import com.market.api.Model.Product;
import com.market.api.Repository.CommentRepository;
import com.market.api.Repository.CustomerRepository;
import com.market.api.Repository.ProductRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MarketApiApplication implements CommandLineRunner {

	private final ProductRepository productRepository;
	private final CustomerRepository customerRepository;
	private final CommentRepository commentRepository;

	public MarketApiApplication(ProductRepository productRepository, CustomerRepository customerRepository, CommentRepository commentRepository) {
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
		this.commentRepository = commentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MarketApiApplication.class, args);

	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String desc,@Value("${application-version}") String version){

			return new OpenAPI().info(new Info()
												.title("Market API")
												.version(version)
												.description(desc)
												.license(new License().name("MIT License")));



	}


	@Override
	public void run(String... args) {


		ArrayList<Product> products = new ArrayList<>();
		ArrayList<Comment> comments = new ArrayList<>();
		ArrayList<Customer> customers = new ArrayList<>();

		products.add(new Product("Tornavida", 49.9, null));
		products.add(new Product("Pense", 39.9, null));
		products.add(new Product("Matkap", 240.5, null));
		products.add(new Product("Mouse", 350.0, null));
		products.add(new Product("Klavye", 449.9, null));
		products.add(new Product("Çikolata", 29.9, LocalDateTime.parse("2023-01-05T00:00:00")));
		products.add(new Product("Dondurma", 29.9, LocalDateTime.parse("2022-10-05T00:00:00")));
		products.add(new Product("Yumurta", 29.9, LocalDateTime.parse("2022-10-05T00:00:00")));
		products.add(new Product("Peynir", 129.9, LocalDateTime.parse("2022-09-28T00:00:00")));
		products.add(new Product("Süt", 29.9, LocalDateTime.parse("2022-05-05T00:00:00")));
		products.add(new Product("Yoğurt", 59.9, LocalDateTime.parse("2022-08-28T00:00:00")));

		customers.add(new Customer("Taha", "Avcı", "info@taha.com", "905351234451"));
		customers.add(new Customer("Ali", "Ali", "info@ali.com", "905351234452"));
		customers.add(new Customer("Veli", "Veli", "info@veli.com", "905351234453"));
		customers.add(new Customer("Ahmet", "Ahmet", "info@ahmet.com", "905351234454"));
		customers.add(new Customer("Mehmet", "Mehmet", "info@mehmet.com", "905351234455"));
		customers.add(new Customer("Necdet", "Necdet", "info@necdet.com", "905351234456"));
		customers.add(new Customer("Ayşe", "Ayşe", "info@ayse.com", "905351234457"));
		customers.add(new Customer("Fatma", "Turgut", "info@fatma.com", "905351234458"));
		customers.add(new Customer("Kamil", "Kamil", "info@kamil.com", "905351234459"));
		customers.add(new Customer("Enes", "Enes", "info@enes.com", "905351234410"));
		customers.add(new Customer("Murat", "Kara", "info@murat.com", "905351234411"));

		productRepository.saveAll(products);
		customerRepository.saveAll(customers);

		List<Product> productList = productRepository.findAll();
		List<Customer> customerList = customerRepository.findAll();

		for (int i = 0; i < products.size(); i++) {

			Comment comment1 = new Comment("Nice product", LocalDateTime.now(), productList.get(i),
					customerList.get(i));
			comments.add(comment1);
			Comment comment2 = new Comment("Bad product", LocalDateTime.now(), productList.get(i), customerList.get(i));
			comments.add(comment2);
		}
		Comment comment1 = new Comment("Güzel ürün", LocalDateTime.parse("2022-04-04T00:00:00"), productList.get(1),
				customerList.get(1));
		comments.add(comment1);
		Comment comment2 = new Comment("Kötü ürün", LocalDateTime.parse("2022-04-04T00:00:00"), productList.get(1),
				customerList.get(1));
		comments.add(comment2);


		commentRepository.saveAll(comments);


	}
}
