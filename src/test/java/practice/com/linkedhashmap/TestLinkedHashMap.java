 package practice.com.linkedhashmap;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		//LinkedHashMap有什么特点？
		//基于链表来实现的一个HashMap
		//1.能按put顺序存储对象
		//2.能记录最近最少访问的对象（LRU算法）
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
