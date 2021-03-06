package yunprac.com.example.springPrac.MainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import yunprac.com.example.springPrac.Services.NoteService;
import yunprac.com.example.springPrac.Services.NoteServiceAnnotation;
import yunprac.com.example.springPrac.Services.NoteServiceImpl;
import yunprac.com.example.springPrac.Services.PropertiesServiceImpl;

/**
 * Created by yunzhao on 17/11/18.
 */
@SpringBootApplication
@ComponentScan("yunprac.com.example.springPrac.Services")
@PropertySource("classpath:service.properties")
public class SpringPackageScanApplication {

    public static void main(String[] args) {

        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(SpringPackageScanConfig.class);

        NoteServiceAnnotation noteServiceAnnotation = annotationContext.getBean(NoteServiceAnnotation.class);

        noteServiceAnnotation.getNote();





        ApplicationContext applicationContext = SpringApplication.run(SpringPackageScanApplication.class, args);

        NoteService noteService = applicationContext.getBean(NoteServiceImpl.class);

        noteService.getNote();

        PropertiesServiceImpl propertiesServiceImpl = applicationContext.getBean(PropertiesServiceImpl.class);

        System.out.println(propertiesServiceImpl.getServiceURL());
    }
}
