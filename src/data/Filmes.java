package data;

import java.sql.Date;

public class Filmes {
    private int id;
    private String nome;
    private Date dataDeLanc;
    private String categoria;
    
    public Filmes(){
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id  = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeLanc() {
        return dataDeLanc;
    }

    public void setDataDeLanc(Date dataDeLanc) {
        this.dataDeLanc = dataDeLanc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
