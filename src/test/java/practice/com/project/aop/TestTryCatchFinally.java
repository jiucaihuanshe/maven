package practice.com.project.aop;

public class TestTryCatchFinally {
	static int doMethod1(){
		int a =10;
		try{
			a++;
		}finally{
			return a;
		}
	}
	static int doMethod2(){
		int a =10;
		try{
			//@AfterReturn
			return a;//两个步骤（步骤一获取a的值，存储a的值给临时变量temp，步骤二返回临时变量temp的值）
		}finally{//@After
			System.out.println("finally{}");
			a++;
		}
	}
	static int doMethod3(){
		int a =10;
		try{
			int b=a/0;
			return a;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			System.out.println("finally{}");
			a++;
		}
	}
	static int doMethod4(){
		try{
			return 10;
		}finally{
			return 20;
		}
	}
	public static void main(String[] args) {
		System.out.println(doMethod1());//11
		System.out.println(doMethod2());//10
		//System.out.println(doMethod3());
		System.out.println(doMethod4());//20
	}
}
