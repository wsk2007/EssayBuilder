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
@author(value = "wsk") //作者：wsk
@Retention(RUNTIME) //运行时可见
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER,
		TYPE_USE }) //可用于任意类型
public @interface Complain {
	String details();
	//抱怨内容
	String title();
	//抱怨的标题
	String author(); 
	// 抱怨者
	Complain.grade gread(); 
	@Complain(author = "wsk", details = "为啥要写这么多注释", gread = Complain.grade.LITTELANGRY, title = "该死的注释")
	enum grade { //状态
		HAPPY,
		//高兴
		NORMAL,
		//一般
		LITTELANGRY,
		//有一点生气
		ANGRY,
		//生气
		VERYANGRY,
		//非常生气,
		LITTELSAD,
		//有一点伤心
		SAD,
		//伤心
		VREYSAD,
		//很伤心,
		LITTELHAPPY,
		//有一点高兴
		VERYHAPPY,
		//很高兴
		CANNOTDESCRIBE
		//无法形容
	}

}
