package model;

import javax.swing.JTable;

public interface TableActionEvent {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onSetActive(int row);
}
