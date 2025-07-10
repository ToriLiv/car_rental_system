package org.example.ADAPTER;

import org.example.ENTITIES.CAR.Auto;
import org.example.INTERFACES.AutoInfoDisponible;

import java.util.List;
import java.util.stream.Collectors;

public class AutoDisponibleAdapter implements AutoInfoDisponible {
    private List<Auto> autos;

    public AutoDisponibleAdapter(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public List<Auto> obtenerAutosDisponibles() {
        return autos.stream()
                .filter(auto -> auto.isDisponible())
                .collect(Collectors.toList());
    }
}
