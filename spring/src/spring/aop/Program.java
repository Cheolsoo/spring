package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context =
				//new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");		
		
		Exam exam = (Exam) context.getBean("exam");
		
		// f101 브랜치와 dev 브랜치 Pull Request 할 때 충돌을 일으키기 위해 아래와 같이
		// total --> total2 로 수정함
		System.out.printf("total2 is %d\n", exam.total());
		System.out.printf("total2 is %f\n", exam.avg());
		
		// SR번호 101 에 맞게 f101 이라는 로컬 브랜치 생성하고 commit & push 진행해봅니다. 
		
		
		/*
		Exam exam = new NewlecExam(1,1,1,1);
		 		
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
				new Class[] {Exam.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						long start = System.currentTimeMillis();
						
						Object result = method.invoke(exam, args);
												
						long end = System.currentTimeMillis();
						
						String message = (end - start) + "ms 시간이 걸렸습니다.";
						System.out.println(message);

						
						return result;
					}
				}
			);
		*/
	}
}
