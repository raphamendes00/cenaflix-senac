package data;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Statement;
public class FilmesDao {
    Connection conn;
    ResultSet rs;
    PreparedStatement ps;
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atividade_1","root", "metalend");
            System.out.println("conex "+conn);
            return true;
        }catch(SQLException | ClassNotFoundException a){
            System.out.println("Não foi possível conectar " + a.getMessage());
            return false;
        }    
    }
    
    public int Salvar(Filmes filme){
        int status;
        try{
            ps = conn.prepareStatement("INSERT INTO filmes (id,nome,datalancamento,categoria) VALUES(?,?,?,?)");
            ps.setInt(1, filme.getId());
            ps.setString(2, filme.getNome());
            ps.setDate(3, filme.getDataDeLanc());
            ps.setString(4, filme.getCategoria());
            status = ps.executeUpdate();
            System.out.println("status "+status);
            return status;
        }catch(SQLException b){
            System.out.println("Não foi possível salvar o título " + b.getMessage());
            return b.getErrorCode();
        }
    }
    
    public Filmes consultar(String nome){
        Filmes filme = null;
        try{
            filme = new Filmes();
            ps = conn.prepareStatement("SELECT * FROM Filmes WHERE nome = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();
            
            if(rs.next()){
                filme.setNome(rs.getString("nome"));
                filme.setDataDeLanc(rs.getDate("data_de_lancamento"));
                filme.setCategoria(rs.getString("categoria"));
                return filme;
            }else{
                return null;
            }
        }catch(SQLException c){
            System.out.println("Erro ao buscar título "+ c.getMessage());
            return null;
        }
    }
    
    public boolean excluir(int id){
        try{
            ps = conn.prepareStatement("DELETE FROM filmes WHERE id = ?");
            ps.setInt(1,id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }catch(SQLException ex){
            System.out.println("Não foi possível excluir "+ ex.getMessage());
            return false;
        }
    }
    
    public int atualizar(Filmes filme){
        int status;
        try{
            ps = conn.prepareStatement("UPDATE filmes SET nome = ?,datalancamento = ?,categoria = ? WHERE id = ?");
            ps.setString(1, filme.getNome());
            ps.setDate(2, filme.getDataDeLanc());
            ps.setString(3, filme.getCategoria());
            ps.setInt(4,filme.getId());
            status = ps.executeUpdate();
            System.out.println("status "+status);
            return status;
        }catch(SQLException ex){
            System.out.println("Erro ao tentar atualizar título "+ ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public List<Filmes> Listar(){
        List<Filmes> filmes = new ArrayList<>();
        String sql = "SELECT nome, dataLancamento, categoria FROM filmes";
        
        try{
            ps = conn.prepareStatement("SELECT nome, dataLancamento, categoria, id FROM filmes");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Filmes filme = new Filmes();
                filme.setNome(rs.getString("nome"));
                filme.setDataDeLanc(rs.getDate("dataLancamento"));
                filme.setCategoria(rs.getString("categoria"));
                filme.setId(rs.getInt("id"));
                filmes.add(filme);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return filmes;
    }
    
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException c){
        }
    }
}
