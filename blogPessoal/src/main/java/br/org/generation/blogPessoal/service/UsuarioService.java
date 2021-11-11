package br.org.generation.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.generation.blogPessoal.model.UserLogin;
import br.org.generation.blogPessoal.model.Usuario;
import br.org.generation.blogPessoal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositoryUsuario;
	/*
	//Usar um optinal para ele conseguir retornar um nulo quando o usuário ficar repetido
	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
		
	}
	*/
	public List<Usuario> listarUsuarios(){
		return repositoryUsuario.findAll();
	}
	
	public Optional<Usuario> CadastrarUsuario(Usuario usuario){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(repositoryUsuario.findByUsuario(usuario.getUsuario()).isPresent()) return Optional.empty();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		
		usuario.setSenha(senhaEncoder);
		
		return Optional.of(repositoryUsuario.save(usuario));
		
	}
	
	public Optional<UserLogin> Logar(Optional<UserLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
		Optional<Usuario> usuario = repositoryUsuario.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
			 
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				
				return user;
			}
		}
		
		return Optional.empty();
	}
	
}
