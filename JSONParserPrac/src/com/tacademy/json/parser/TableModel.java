package com.tacademy.json.parser;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.tacademy.json.vo.Board;
import com.tacademy.json.vo.Obj;

public class TableModel extends AbstractTableModel{
	private static final long serialVersionUID = 6863789511067892800L;
	
	String[] colNames = {"num", "writer", "title", "content", "ip",
			"idate", "img"};
	
	Obj obj;
	ArrayList<Board> list;
	
	@Override
	public int getColumnCount() {
		
		
		return colNames.length;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Board brd = list.get(rowIndex);
		switch(columnIndex){
		case 0:
			return brd.getNum();
		case 1:
			return brd.getWriter();
		case 2:
			return brd.getTitle();
		case 3:
			return brd.getContent();
		case 4:
			return brd.getIp();
		case 5:
			return brd.getIdate();
		case 6:
			return brd.getImg();
		}
		
		return null;
	}

	// ─────────────────────────────
	//
	//
	public String[] getColNames() {
		return colNames;
	}

	public void setColNames(String[] colNames) {
		this.colNames = colNames;
	}

	public Obj getObj() {
		return obj;
	}

	public void setObj(Obj obj) {
		this.obj = obj;
	}

	public ArrayList<Board> getList() {
		return list;
	}

	public void setList(ArrayList<Board> list) {
		this.list = list;
	}

	
	
	// colname
	@Override
	public String getColumnName(int columnIndex) {
		return colNames[columnIndex];
	}

	
	
	
}
