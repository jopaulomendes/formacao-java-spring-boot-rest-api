package com.jopaulo.lojavirtual.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1, initialValue = 1)
public class UsuarioEntity implements UserDetails{

	private static final long serialVersionUID = -303440457187894024L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	private Long id;
	
	private String login;
	
	private String senha;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtualSenha;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "TB_USUARIOS_ACESSO",
	    uniqueConstraints = @UniqueConstraint(
	        columnNames = {"usuario_id", "acesso_id"},
	        name = "unique_acesso_user"
	    ),
	    joinColumns = @JoinColumn(
	        name = "usuario_id",
	        referencedColumnName = "id",
	        table = "TB_USUARIO",
	        unique = false,
	        foreignKey = @ForeignKey(
	            name = "usuario_fk",
	            value = ConstraintMode.CONSTRAINT
	        )
	    ),
	    inverseJoinColumns = @JoinColumn(
	        name = "acesso_id",
	        unique = false,
	        referencedColumnName = "id",
	        table = "TB_ACESSO",
	        foreignKey = @ForeignKey(
	            name = "acesso_fk",
	            value = ConstraintMode.CONSTRAINT
	        )
	    )
	)
	private List<AcessoEntity> acesso;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.acesso;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

}
