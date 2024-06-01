package com.mycompany.dist_com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // Método para obtener la potencia media según el tipo de vehículo
    @Query("SELECT AVG(v.potencia) FROM Vehiculo v WHERE v.tipo = :tipo")
    Double obtenerPotenciaMediaSegunTipo(@Param("tipo") String tipo);

    // Método para obtener la potencia máxima según el tipo de vehículo
    @Query("SELECT MAX(v.potencia) FROM Vehiculo v WHERE v.tipo = :tipo")
    Integer obtenerPotenciaMaximaSegunTipo(@Param("tipo") String tipo);
}


