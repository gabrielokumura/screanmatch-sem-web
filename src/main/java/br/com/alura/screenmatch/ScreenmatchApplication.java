package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.services.ConsumoAPI;
import br.com.alura.screenmatch.services.ConverteDados;
import br.com.alura.screenmatch.services.IconverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		Scanner scanner = new Scanner(System.in);

		String apiKey = "ca0dac3b";

		System.out.println("Digite o nome do seu filme: ");
		var busca = scanner.nextLine();

		var endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + apiKey;
		var json = consumoAPI.obterDados(endereco);
		ConverteDados conversor = new ConverteDados();

		var dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println(dados);
	}
}
