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
	private User user_seguido;
	@ManyToOne
	private User user_seguindo;
	
	public Follow() {
		
	}
	
	public Follow(User user_seguindo, User user_seguido) {
		this.user_seguido = user_seguido;
		this.user_seguindo = user_seguindo;
	}
	
	
	public Long getId() {
		return id;
	}
	public User getUser_seguido() {
		return user_seguindo;
	}
	public User getUser_seguindo() {
		return user_seguido;
	}
}
