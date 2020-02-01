package org.wsk.EssayBuilder;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
@author(value = "wsk") //���ߣ�wsk
@Retention(RUNTIME) //����ʱ�ɼ�
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER,
		TYPE_USE }) //��������������
public @interface Complain {
	String details();
	//��Թ����
	String title();
	//��Թ�ı���
	String author(); 
	// ��Թ��
	Complain.grade gread(); 
	@Complain(author = "wsk", details = "ΪɶҪд��ô��ע��", gread = Complain.grade.LITTELANGRY, title = "������ע��")
	enum grade { //״̬
		HAPPY,
		//����
		NORMAL,
		//һ��
		LITTELANGRY,
		//��һ������
		ANGRY,
		//����
		VERYANGRY,
		//�ǳ�����,
		LITTELSAD,
		//��һ������
		SAD,
		//����
		VREYSAD,
		//������,
		LITTELHAPPY,
		//��һ�����
		VERYHAPPY,
		//�ܸ���
		CANNOTDESCRIBE
		//�޷�����
	}

}
