package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbmam.course.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
}
