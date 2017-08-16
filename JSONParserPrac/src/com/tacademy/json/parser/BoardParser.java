package com.tacademy.json.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tacademy.json.vo.Board;
import com.tacademy.json.vo.Obj;

public class BoardParser {
	public Obj parseJsonString(String jsonStr){
		//필요한 변수들이 오겠지?
		//이따가!
		Obj boardObj = new Obj();
		ArrayList<Board> list = null;
		
		//JSONObject를 쓰기 위해서 Maven설정하고 나서 pom설정해줘야한다
		JSONObject jobj = null;
		JSONArray listArr = null;
		JSONObject tempObj = null;
		
		
		//try catch로 파싱을 한다
		try{
			jobj = new JSONObject(jsonStr); //string받은 jobj를 대입
			System.out.println("jobj: " + jobj);
			boardObj.setState(jobj.getString("state"));
			boardObj.setSize(jobj.getInt("size"));
			boardObj.setImgbaseurl(jobj.getString("imgbaseurl"));
			//
			listArr = jobj.getJSONArray("boards");
			list = new ArrayList<Board>();
			Board brd = null;
			
			/// temp variables here
			
			for(int i = 0; i < listArr.length(); i++){
				tempObj = listArr.getJSONObject(i); //i번째 jsonobj담기
				//board에 담는다
				brd = new Board();
				brd.setNum(tempObj.getInt("num"));
				brd.setWriter(tempObj.getString("writer"));
				brd.setTitle(tempObj.getString("title"));
				brd.setContent(tempObj.getString("content"));
				brd.setIp(tempObj.getString("ip"));
				brd.setIdate(tempObj.getString("idate"));
				brd.setImg(tempObj.getString("img"));
				
				list.add(brd);
			}
			
			boardObj.setBoards(list);
			
			System.out.println("board의 list size: " + boardObj.getSize());
			
			
		}catch(JSONException  e){
			System.out.println("제이슨 parse failed : " + e);
		}
		
		
		return boardObj;
	}
}
