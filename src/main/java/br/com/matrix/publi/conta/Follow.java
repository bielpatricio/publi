package br.com.matrix.publi.conta;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Follow {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User userSeguido;
	@ManyToOne
	private User userSeguindo;
	
	public Follow() {
		
	}
	
	public Follow(User userSeguindo, User userSeguido) {
		this.userSeguido = userSeguido;
		this.userSeguindo = userSeguindo;
	}
	
	
	public Long getId() {
		return id;
	}
	public User getUserSeguido() {
		return userSeguindo;
	}
	public User getUserSeguindo() {
		return userSeguido;
	}
}
