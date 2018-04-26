package bupt.xyh.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonReader {

	public static void main(String[] args) {
		List<Comment> commentList = new ArrayList<Comment>();
		for (int ii = 20; ii <= 22; ii++) {
			String path = "D:/java/comment/" + ii + ".json";
			path = path.replace("/", "\\");
			String jsonStr=readFile(path);
			List<Comment> list=json2List(jsonStr);
			commentList.addAll(list);
		} 
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet("comment");
			HSSFRow row=sheet.createRow(0);
			HSSFCell cell = row.createCell((short) 0);  
	        cell.setCellValue("userName");    
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("createTime");    
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("content"); 
	        for(int i=0;i<commentList.size();i++){
	        	row=sheet.createRow(i+1);
	        	Comment comment=commentList.get(i);
	        	row.createCell(0).setCellValue(comment.getUserName());
	        	row.createCell(1).setCellValue(comment.getCreateTime());
	        	row.createCell(2).setCellValue(comment.getContent());
	        }
	        try {
	        	FileOutputStream fout = new FileOutputStream("D:/students_6.xls");
				wb.write(fout);
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
	}

	public static String readFile(String path) {
		BufferedReader reader = null;
		StringBuilder str = new StringBuilder();
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempStr = null;
			while ((tempStr = reader.readLine()) != null) {
				str.append(tempStr);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return str.toString();
	}

	public static List<Comment> json2List(String jsonStr){
		JSONObject jsonObject=new JSONObject(jsonStr);
		JSONArray dataArray=jsonObject.getJSONArray("data");
		int num=dataArray.length();
		List<Comment> commentList=new ArrayList<Comment>();
		for(int i=0;i<num;i++){
			JSONObject commentObject=dataArray.getJSONObject(i).getJSONObject("comment");
			Comment comment=new Comment();
			comment.setContent(commentObject.getString("text"));
			comment.setCreateTime(commentObject.getLong("create_time"));
			comment.setUserName(commentObject.getString("user_name"));
			commentList.add(comment);
		}
		return commentList;
	}

}
