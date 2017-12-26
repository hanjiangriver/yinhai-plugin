# yinhai-plugin
## 自定义插件
              继承了AbstractMojo类<br>
              实现了统计项目里面java文件的数目


## 用法
### 1.在`maven`项目的`pom`的文件里添加如下配置
<build>
       <plugins>
           <plugin>
               <groupId>com.zhj</groupId>
               <artifactId>yinhai-plugin</artifactId>
               <version>1.0-SNAPSHOT</version>
               <configuration>
                   <msg>river</msg>
                   <options>
                       <option>one</option>
                       <option>two</option>
                   </options>
                   <args>${project.basedir}</args>
               </configuration>
               <executions>
                   <execution>
                       <phase>compile</phase>  
                       <goals>
                           <goal>yinhai</goal>
                       </goals>
                   </execution>
               </executions>
           </plugin>
       </plugins>
    </build>


## ps:注意几点 
#### >> 1.插件要挂到项目的某个阶段（phase）中 本事例是compile阶段
#### >> 2.goal的名字 就是插件中的 name
