import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo{
    public List<conteudo> extraiConteudos (String json){
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<conteudo> conteudos = new ArrayList<>();

        //popular a lista de Conteudos

        for(Map<String, String> atributos : listaDeAtributos){
            new conteudo(json, json);
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo =  new conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
