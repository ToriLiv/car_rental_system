package org.example.ADAPTER;
import org.example.ENTITIES.CAR.Auto;
import org.example.INTERFACES.AutoInfoDisponible;
import java.util.List;
import java.util.stream.Collectors;

/*==============================ADAPTER======================================
* Nos permite implementar 2 interfaces que tal vez no son compatibles.
* Se esta implementando una clase que adapte la funcionalidad de una interfaz.
* Se adapta la funcionalidad de obtener autos disponibles.
* ===========================================================================
 */
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
