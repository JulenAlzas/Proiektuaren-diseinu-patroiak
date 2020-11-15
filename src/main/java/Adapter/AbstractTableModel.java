package Adapter;

abstract class AbstractTableModel {
	abstract int getColumnCount();
	abstract int getRowCount();
	abstract Object getValueAt(int row, int col);
}
