package util;


import java.util.List;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

public class ComboConverter<V> implements Converter<Comboitem, V, Combobox> {

    @Override
    public Comboitem coerceToUi(V val, Combobox listbox, BindContext ctx) {
        List<Comboitem> listitems = listbox.getItems();
        for (Comboitem listItem : listitems) {
            if (listItem.getValue().equals(val)) {
                return listItem;
            }
        }
        return listitems.isEmpty() ? null : listitems.get(0);
        
    }

    @Override
    @SuppressWarnings("unchecked")
    public V coerceToBean(Comboitem listItem, Combobox listbox, BindContext ctx) {
        return listItem == null ? null : (V) listItem.getValue();
    }

}
