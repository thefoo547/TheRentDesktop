package therent.util;

import javafx.util.StringConverter;
import therent.model.beans.ModeloAuto;

public class ModelConverter extends StringConverter<ModeloAuto> {

    @Override
    public String toString(ModeloAuto obj) {
        return obj == null ? null : (obj.getMarca()+" "+obj.getModelo()+" | "+obj.getCategoria()+" | "+obj.getPrecio()+" $");
    }

    @Override
    public ModeloAuto fromString(String string) {
        return null;
    }
}
