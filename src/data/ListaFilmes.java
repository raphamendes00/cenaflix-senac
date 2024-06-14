package data;
import java.util.ArrayList;
import java.util.List;

public class ListaFilmes {
    private static final List<Filmes> lista = new ArrayList<>();
    
    public static List<Filmes> Listar(){
        List<Filmes> lista = new ArrayList<>();
        return lista;
    }
    
    public static void Adicionar(Filmes filme){
        lista.add(filme);
    }
}
