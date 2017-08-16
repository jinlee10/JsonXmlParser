package com.tacademy.json.vo;

import java.util.ArrayList;

public class Obj {
	private String state;
	private int size;
	private String imgbaseurl;
	private ArrayList<Board> boards;
	//
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getImgbaseurl() {
		return imgbaseurl;
	}
	public void setImgbaseurl(String imgbaseurl) {
		this.imgbaseurl = imgbaseurl;
	}
	public ArrayList<Board> getBoards() {
		return boards;
	}
	public void setBoards(ArrayList<Board> boards) {
		this.boards = boards;
	}
	//
	@Override
	public String toString() {
		return "Obj [state=" + state + ", size=" + size + ", imgbaseurl=" + imgbaseurl + ", boards=" + boards + "]";
	}
	
}
