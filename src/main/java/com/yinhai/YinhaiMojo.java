package com.yinhai;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.List;


/**
 * Created by 张汉江 on 2017/11/15
 */
@Mojo(name="yinhai",defaultPhase = LifecyclePhase.PACKAGE)
public class YinhaiMojo  extends AbstractMojo{
    private   int a=0;

    @Parameter
    private String msg;

    @Parameter
    private List<String>options;

    @Parameter(property ="args")
    private String args;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("in file "+args+" has "+getJavaFileCountInFolder(args)+" java file! ");
       // System.out.println("zhj first plugin!"+args);
    }

   //获取文件后缀
    public    String  getFileType(String fileName) {

        int dotindex= fileName.lastIndexOf(".");
        return fileName.substring(dotindex+1);
    }
    //递归计算java文件数目
    public   int  getJavaFileCountInFolder(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                return a ;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        getJavaFileCountInFolder(file2.getAbsolutePath());
                    } else {
                        if(getFileType(file2.getAbsolutePath()).equals("java")){
                            a++;
                        }
                    }
                }
            }
        } else {
            return 0;
        }
        return a;
    }
}
