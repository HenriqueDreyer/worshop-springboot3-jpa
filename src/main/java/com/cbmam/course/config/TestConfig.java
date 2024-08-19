package com.cbmam.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cbmam.course.entities.Categoria;
import com.cbmam.course.entities.Pedido;
import com.cbmam.course.entities.Usuario;
import com.cbmam.course.entities.enums.StatusPedido;
import com.cbmam.course.repositories.CategoriaRepository;
import com.cbmam.course.repositories.PedidoRepository;
import com.cbmam.course.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.ESPERANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.PAGO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.ENTREGUE, u1);
		
		
		
		// Salvar no banco de dados
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
}
