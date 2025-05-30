/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
/**
 *
 * @author OPR
 */
public class TableActionCellRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com= super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        PanelAction action=new PanelAction();
        if(isSelected==false&&row%2==0)
            action.setBackground(Color.WHITE);
        else
            action.setBackground(com.getBackground());
        action.setBackground(com.getBackground());
        return action;//To change body of generated methods, choose Tools | Templates.
    }
}

