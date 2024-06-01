package com.mycompany.dist_com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Endpoint para obtener todos los vehículos
    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    // Endpoint para obtener un vehículo por ID
    @GetMapping("/{id}")
    public Vehiculo getVehiculoById(@PathVariable Integer id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

// Endpoint para insertar un nuevo vehículo
@PostMapping
public ResponseEntity<Vehiculo> insertVehiculo(@RequestBody Vehiculo vehiculo) {
    try {
        Vehiculo nuevoVehiculo = vehiculoRepository.save(vehiculo);
        return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    // Endpoint para eliminar un vehículo por ID
    @DeleteMapping("/{id}")
    public void deleteVehiculo(@PathVariable Integer id) {
        vehiculoRepository.deleteById(id);
    }



// Endpoint para actualizar los datos de un vehículo
@PutMapping("/{id}")
public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Integer id, @RequestBody Vehiculo updatedVehiculo) {
    return vehiculoRepository.findById(id)
            .map(existingVehiculo -> {
                existingVehiculo.setTipo(updatedVehiculo.getTipo());
                existingVehiculo.setMarca(updatedVehiculo.getMarca());
                existingVehiculo.setPotencia(updatedVehiculo.getPotencia());
                existingVehiculo.setFechaDeCompra(updatedVehiculo.getFechaDeCompra());
                Vehiculo updated = vehiculoRepository.save(existingVehiculo);
                return ResponseEntity.ok(updated);
            })
            .orElse(ResponseEntity.notFound().build());
}

    // Endpoint para obtener la potencia media según el tipo de vehículo
    @GetMapping("/potenciaMedia/{tipo}")
    public Double obtenerPotenciaMediaSegunTipo(@PathVariable String tipo) {
        return vehiculoRepository.obtenerPotenciaMediaSegunTipo(tipo);
    }

    // Endpoint para obtener la potencia máxima según el tipo de vehículo
    @GetMapping("/potenciaMaxima/{tipo}")
    public Integer obtenerPotenciaMaximaSegunTipo(@PathVariable String tipo) {
        return vehiculoRepository.obtenerPotenciaMaximaSegunTipo(tipo);
    }
}
