/*import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.JSpinner;
import javax.swing.plaf.UIResource;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
public class VolumeRenderer extends JSpinner implements TableCellRenderer,UIResource {
	public VolumeRenderer() {
		super();
    	setModel(new SpinnerVolumeModel());
    	setEditor(new Editor(this));
	}
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
        if (isSelected) {
	        setForeground(table.getSelectionForeground());
	        super.setBackground(table.getSelectionBackground());
	    }
	    else {
	        setForeground(table.getForeground());
	        setBackground(table.getBackground());
	    }
	    if (hasFocus) {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
        } else {
            setBorder(new EmptyBorder(1, 1, 1, 1));
        }
        return this;
    }
    class Editor extends JSpinner.DefaultEditor{
		Editor(JSpinner spinner) {
			super(spinner);
			JFormattedTextField ftf = getTextField();
	    	ftf.setEditable(true);
		}
	}
}*/