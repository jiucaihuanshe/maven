package practice.com.project.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ע�⣺
 * 1����java�е�һ��Ԫ���ݣ���������java����
 * 2��������Ҳ��һ����
 * @Retention ��ʾ�Լ������ע���ʱ��Ч
 * @Target ��ʾ�Լ������ע��Ӧ��������
 */
@Retention(RetentionPolicy.RUNTIME)//��ʾ�Լ������ע��������ʱ��Ч
@Target(ElementType.METHOD)//��ʾ�Լ������ע��Ӧ���ڷ�������
public @interface Permission {
	
}
