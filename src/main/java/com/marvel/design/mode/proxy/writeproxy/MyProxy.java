package com.marvel.design.mode.proxy.writeproxy;

import org.springframework.util.FileCopyUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {
    private static final String rt = "\r";

    public static Object newProxyInstance(MyClassLoader loader, Class<?> interfaces, MyInvocationHandler h)
        throws IllegalArgumentException{
        if (h == null) {
            throw new IllegalArgumentException();
        }

        //根据接口构造代理类
        Method[] methods = interfaces.getMethods();
        StringBuffer proxyClassString = new StringBuffer();
        proxyClassString.append("package ")
                .append(loader.getProxyClassPackage()).append(";").append(rt)
                .append("import java.lang.reflect.Methcod;").append(rt)
                .append("public class $MyProxy0 implements ").append(interfaces.getName()).append("{").append(rt)
                .append("MyInvocationHandler h;").append(rt)
                .append("public $MyProxy(MyInvocationHandler h)}").append(rt)
                .append("this.h = h;").append(rt)
                .append(getMethodString(methods, interfaces)).append("}");
        //写入java文件，进行编译
        String fileName = loader.getDir() + File.separator + "MyProxy.java";
        File myProxyFile = new File(fileName);
        try {
            compile(proxyClassString, myProxyFile);
            //利用自定义的ClassBuilder加载
            Class $myProxy0 = loader.findClass("$MyProxy0");
            //$MyProxy0初始化
            Constructor constructor = $myProxy0.getConstructor(MyInvocationHandler.class);

            Object object = constructor.newInstance(h);

            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param proxyClassString
     * @param myProxyFile
     * @throws IOException
     */
    private static void compile(StringBuffer proxyClassString, File myProxyFile) throws IOException {
        FileCopyUtils.copy(proxyClassString.toString().getBytes(), myProxyFile);
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable javaFileObject = standardJavaFileManager.getJavaFileObjects(myProxyFile);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardJavaFileManager, null, null, null, javaFileObject);
        task.call();
        standardJavaFileManager.close();
    }

    private static String getMethodString(Method[] methods, Class interfaces) {
        StringBuffer methodStringBuffer = new StringBuffer();
        for (Method method : methods) {
            methodStringBuffer.append("public void ").append(method.getName())
                    .append("()").append(" throws Throwable{ ")
                    .append("Method method1 = ").append(interfaces.getName())
                    .append(".class.getMethod(\"").append(method.getName())
                    .append("\", new Class[]{});")
                    .append("this.h.invoke(this, method1, null);)").append(rt);
        }

        return methodStringBuffer.toString();
    }
}
