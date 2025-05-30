/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author OPR
 */
public class TableActionCellEditor extends javax.swing.DefaultCellEditor{
    public TableActionCellEditor(){
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action=new PanelAction();
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
}
