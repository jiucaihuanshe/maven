 package practice.com.linkedhashmap;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		//LinkedHashMap��ʲô�ص㣿
		//����������ʵ�ֵ�һ��HashMap
		//1.�ܰ�put˳��洢����
		//2.�ܼ�¼������ٷ��ʵĶ���LRU�㷨��
		LinkedHashMap<String, Object> map = new LinkedHashMap<String,Object>(10,0.75f,true);
		map.put("A", 100);
		map.put("B", 200);
		map.put("C", 300);
		map.put("D", 400);
		System.out.println(map);
		map.get("B");
		map.get("D");
		map.get("B");
		System.out.println(map);//ACDB
	}
}
