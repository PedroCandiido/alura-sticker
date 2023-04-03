import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        
        // fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        

        //exibir e manipular os dados
        ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
        List<conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 1; i < 3; i++) {
            
            conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
        
        
    }
}
