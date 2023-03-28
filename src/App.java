import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Realizar a conexão HTTP e buscar o top 250 filmes

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // exibindo o conteudo do body
        //System.out.println(body);
        
        // Filtrar somente os dados que interessam (Titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        //mostra o tamanho da lista
        //System.out.println(listaDeFilmes.size());
        
        //mostra algum item especifico da lista que eu selecionar
        //System.out.println(listaDeFilmes.get(0));
        
        // Exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[37m \u001b[44m Titulo: \u001b[m: "+filme.get("title"));
            System.out.println("\u001b[37m \u001b[44m Imagem: \u001b[m: " + filme.get("image"));
            System.out.println("\u001b[37m \u001b[44m Avaliação: \u001b[m:"+filme.get("imDbRating"));
            String imDbRating = filme.get("imDbRating");
            for(int i = 0; i < Double.parseDouble(imDbRating); i++){
                System.out.print("⭐ ");
            }
            System.out.println();
        }
    }
}
