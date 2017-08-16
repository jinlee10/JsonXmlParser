package com.tacademy.json.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tacademy.json.parser.BoardParser;
import com.tacademy.json.parser.TableModel;
import com.tacademy.json.vo.Obj;

public class BoardTest {
	
	JFrame f;
	JTable tb;
	TableModel model;
	
	Obj obj;	//gui부분에서 접근해야되기떄문에dd
	
	public BoardTest(){
		//네트워크변수
		String listURL = "http://192.168.205.191/board/list";
		
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		
		//받아올놈
		obj = null;
		
		
		//try catch로 json string받아오기
		try{
			url = new URL(listURL);	//listURL넣는다
			conn = (HttpURLConnection)url.openConnection(); //접속
			
			//string builder에서 읽어서 스트링에 넣기
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String readData = "";
			
			StringBuilder sb = new StringBuilder();
			
			//sb에서 읽어서 스트링에 넣기
			while((readData = reader.readLine()) != null){
				sb.append(readData);
			}
			
			String jsonStr = sb.toString();
			
			//Parser 생성 후 읽어서 스트링에 넣기
			BoardParser parser = new BoardParser();
			obj = parser.parseJsonString(jsonStr);

			//스트링 출력
			System.out.println("jsonstr: " + jsonStr);
			System.out.println("board object: " + obj.toString());
			
			
		}catch(IOException e){
			System.out.println("네트워크오류: " + e);
		}
		
		setGUI();
		
	}
	
	void setGUI(){
		//Jtable로 가져오는부분
		f = new JFrame("JSON Prac 0810!");
		f.setBounds(0,0,600,600);
		tb = new JTable();
		
		model = new TableModel();
		model.setList(obj.getBoards());
		
		tb.setModel(model);
		
		f.add(new JScrollPane(tb));
		
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new BoardTest();
	}
}
