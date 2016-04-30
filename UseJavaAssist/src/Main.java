
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
    public static void main(String[] args) {
        changeMethode();
//        addInterface();
    }

    // 修改方法
    public static void changeMethode() {
        try {
            ///////////////////////////////////
            //  使用javaassist修改 class/jar 代码
            ///////////////////////////////////
            //  设置jar包路径
            ClassPool.getDefault().insertClassPath("../JarDemo/out/production/JarDemo/TestJar.jar");

            // 获取需要修改的类
            CtClass testJarClass = ClassPool.getDefault().getCtClass("TestJar");
            // 获取类中的printTest方法
            CtMethod printTestMethod = testJarClass.getDeclaredMethod("printTest");
            // 修改该方法的内容
            printTestMethod.setBody("System.out.println(\"hello obo\");");




            ///////////////////////////////////
            //  使用反射测试输出,查看修改结果
            ///////////////////////////////////
            Class newTestJarClass = testJarClass.toClass();
            // 使用修改过的类创建对象
            Object newTestJar = newTestJarClass.newInstance();
            Method newPrintTestMethod = newTestJarClass.getDeclaredMethod("printTest");
            newPrintTestMethod.invoke(newTestJar);

            // 解除代码锁定,恢复可编辑状态
            testJarClass.defrost();
            // 写出到外存中
            testJarClass.writeFile();
            // testJarClass.writeFile(other path);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void addInterface() {
//                try {
//            // 设置jar包路径
//            ClassPool.getDefault().insertClassPath("../JarDemo/out/production/JarDemo/TestJar.jar");
//            // 获取需要修改的类
//            CtClass ctClass = ClassPool.getDefault().getCtClass("TestJar");
//            // 获取类中的printTest方法
//            CtMethod ctMethod = ctClass.getDeclaredMethod("printTest");
//            // 修改该方法的内容
//            ctMethod.setBody("System.out.println(\"hello obo\");");
//            CtClass ccctClass = ClassPool.getDefault().getCtClass("Interff");
//            ctClass.addInterface(ccctClass);
//            ctClass.writeFile();
//            ctClass.defrost();
//
//            Class cl = ctClass.toClass();
//            Interff idd = (Interff) cl.newInstance();
//            idd.printTest();
//            Object obj = cl.newInstance();
//            Method m = cl.getDeclaredMethod("printTest");
//            m.invoke(obj);
//
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        } catch (CannotCompileException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//    }

}
