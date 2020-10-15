package lee.garden.FinancialLedger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FinancialLedgerApplication {

	private static final String PROPERTIES =
			"spring.config.location="
					+"classpath:/application.yml"
					+",classpath:/application-db.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(FinancialLedgerApplication.class)
				.properties(PROPERTIES)
				.run(args);
	}

}
