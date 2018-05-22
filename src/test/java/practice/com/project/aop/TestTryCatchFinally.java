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
			return a;//�������裨����һ��ȡa��ֵ���洢a��ֵ����ʱ����temp�������������ʱ����temp��ֵ��
		}finally{
			System.out.println("finally{}");
			a++;
		}
	}
	public static void main(String[] args) {
		System.out.println(doMethod1());//11
		System.out.println(doMethod2());//10
	}
}
