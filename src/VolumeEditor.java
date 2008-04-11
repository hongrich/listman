/*import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JFormattedTextField;
public class VolumeEditor extends AbstractCellEditor implements TableCellEditor{
	JSpinner spinner = new JSpinner();
    public VolumeEditor() {
    	spinner.setModel(new SpinnerVolumeModel());
    	spinner.setEditor(new Editor(spinner));
    }

	public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
		spinner.setValue(value);
		return spinner;
	}
    
	public boolean isCellEditable(EventObject evt) {
		if (evt instanceof MouseEvent) {
			return ((MouseEvent)evt).getClickCount() >= 2;
		}
		return true;
	}
    
	public Object getCellEditorValue() {
		return spinner.getValue();
	}
	
	class Editor extends JSpinner.DefaultEditor{
		Editor(JSpinner spinner) {
			super(spinner);
			JFormattedTextField ftf = getTextField();
	    	ftf.setEditable(true);
		}
	}
}*/