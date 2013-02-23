package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Usuario{

	@Id
	public Long id;
	
	public Pessoa pessoa;
}
