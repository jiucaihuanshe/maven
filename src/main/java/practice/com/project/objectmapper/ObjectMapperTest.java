package practice.com.project.objectmapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperTest {
	static ObjectMapper omapper = new ObjectMapper();
	public static void main(String[] args){
		//对象转换成json数据
		//user1();
		//list1();
		//configure1();
		//jsongenerator1();
		//------------------------
		//json数据转换为对象
		//jsonfile1();
		jsontest1();
	}
	public static void user1(){
		User user = new User();
		user.setAge(24);
		user.setUsername("caocao");
		try {
			omapper.writeValue(new File("D:/Program Files/aa.txt"), user);
			omapper.writeValue(System.out, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void list1(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		try {
			String result = omapper.writeValueAsString(list);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	public static void configure1(){
		omapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);//<1>
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//<2>
		omapper.setDateFormat(df);
		User uu = new User();
		uu.setAge(24);
		uu.setDatetime(new Date());
		String[] sts = {"a1","a2","a3"};
		uu.setList(sts);
		uu.setUsername("json");
		String r1;
		try {
			r1 = omapper.writeValueAsString(uu);
			System.out.println(r1);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	public static void jsongenerator1(){
		try {
			omapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);//<1>
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//<2>
			omapper.setDateFormat(df);
			JsonGenerator jg = omapper.getFactory().createGenerator(System.out,JsonEncoding.UTF8);
			User uu = new User();
			uu.setAge(24);
			uu.setDatetime(new Date());
			String[] sts = {"a1","a2","a3"};
			uu.setList(sts);
			uu.setUsername("json");
			jg.writeObject(uu);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void jsonfile1(){
		File ff = new File("D:/Program Files/aa.txt");
		try {
			String str = FileUtils.readFileToString(ff);
			User user = omapper.readValue(str, User.class);
			System.out.println(user.getAge()+"--"+user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void jsontest1(){
		//双引号要加转义字符，为了方便可以放到文件中读取
		try {
			String test = FileUtils.readFileToString(new File("D:/Program Files/bb.txt"));
			JsonNode jnode=omapper.readTree(test);
			JsonNode node = jnode.get("results");
			for(int i=0;i<node.size();i++){
				System.out.println(node.get(i).get("objectID"));
				JsonNode no = node.get(i).get("geoPoints");
				for(int j=0;j<no.size();j++){
					double n1 = no.get(j).get("x").doubleValue();
					double n2 = no.get(j).get("y").doubleValue();
					System.out.println(n1+"--"+n2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
