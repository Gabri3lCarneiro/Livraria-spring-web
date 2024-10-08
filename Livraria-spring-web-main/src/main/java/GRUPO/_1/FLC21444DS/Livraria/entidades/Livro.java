package GRUPO._1.FLC21444DS.Livraria.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import GRUPO._1.FLC21444DS.Livraria.entidades.enums.LivroEstatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;                                                                                                                                                                                                          
    private String isbn;                                       
    private String nome;                                        
    private String autor;  
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataDePubliicacao;                               
    private String genero;                                      
    private Integer estatus;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reservas_id")
    private Reservas reservas;
    
    public Livro() {
    	
    }
    
    
	public Livro(Long id, String iSBN, String nome, String autor, Date dataDePubliicacao, String genero,
			LivroEstatus estatus) {
		super();
		this.id = id;
		this.isbn = iSBN;
		this.nome = nome;
		this.autor = autor;
		this.dataDePubliicacao = dataDePubliicacao;
		this.genero = genero;
		setEstatus(estatus);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String iSBN) {
		this.isbn = iSBN;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataDePubliicacao() {
		return dataDePubliicacao;
	}

	public void setDataDePubliicacao(Date dataDePubliicacao) {
		this.dataDePubliicacao = dataDePubliicacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LivroEstatus getEstatus() {
		return LivroEstatus.valueOf(estatus);
	}

	public void setEstatus(LivroEstatus estatus) {
		if(estatus != null) {
		   this.estatus = estatus.getCodigo();
		}
	}


	@Override
	public int hashCode() {
		return Objects.hash(isbn, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(isbn, other.isbn) && Objects.equals(id, other.id);
	}
    
 
}
