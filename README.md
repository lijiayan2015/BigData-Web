# bigdata-web
大数据库学习

webroot 当被作为服务器的应用之后,根应用就是webroot
### 注意 :服务器能识别的都是webroot里面的东西

	注意:src 中的.java文件编译后的.class文件在发布app的时候,都会被放到webroot下面
  
发布应用:
手动发布:
	方式1:
		1.在tomcat 的webapps下面新建一个文件夹(代表着即将发布的应用)
		2.将webroot下的所有文件拷贝到1中新建的文件夹下
	方式2:
		1.将webroot文件夹打一个war包
		2.cmd 进入到webroot文件夹下
		3.执行命令:jar -cvf MyApp.war .
		                                             自定义名称
		4.将MyApp.war拷贝到tomcat的webapps下面,拷贝后会看到一个MyApp(服务器自己解压的)的文件夹
		5.完成以上步骤,启动服务器即可访问------发布完成
自动发布:
	方式一:使用myeclipse自带的tomcat
	方式二:使用自己的tomcat
