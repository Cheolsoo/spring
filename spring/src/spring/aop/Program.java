// Git local 저장소 생성하고 최초 커밋이 된건가????
// 20231113-1842
//
// .gitignore 파일을 Package Explorer 에서 찾을수는 없나?

// 오호 Unstaged Changes 에서 더블클릭하니 바로 diff 화면이네
// 
// remote 저장소와 연결 된건가?

// 2023.11.14 17:44
// 이제 신규 저장소와 연결되는가?
// 되는거야 안되는거야

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
		
		System.out.printf("total is %d\n", exam.total());
		System.out.printf("total is %f\n", exam.avg());
		
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
