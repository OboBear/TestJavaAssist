
import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by obo on 16/4/29.
 * Email:obo1993@gmail.com
 * Git:https://github.com/OboBear
 * Blog:http://blog.csdn.net/leilba
 */
public class Main {
    public static void main(String [] args) {
        try {

            ClassPool.getDefault().insertClassPath("/Users/obo/Desktop/Workspace/Java/IntelliJ");
            CtClass ctClass = ClassPool.getDefault().getCtClass("TestJar");
            CtMethod ctMethod = ctClass.getDeclaredMethod("printTest");
            ctMethod.setBody("System.out.println(\"4444\");");
            CtClass ccctClass = ClassPool.getDefault().getCtClass("Interff");
            ctClass.addInterface(ccctClass);
            ctClass.writeFile();

//            Class cl = ctClass.toClass();
//            Interff idd = (Interff) cl.newInstance();
//            idd.printTest();
//            Object obj = cl.newInstance();
//            Method m = cl.getDeclaredMethod("printTest");
//            m.invoke(obj);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
