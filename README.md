# super-shop
GitHup 主要配置参考以下链接：
http://www.cnblogs.com/bluestorm/p/3634348.html

本项目使用java编写

前台模板 使用 metronic_v2.0.2 (bootstrap + jquery + 各种插件) 
<br/>
后台基于 Servlet + JavaBean + Common DBUtils
<br/>
数据库使用 Mysql 

项目启动步骤如下：


1. 在mysql下依次运行脚本，db.sql ==> data.sql ==> procedure.sql
2. 安装maven，并配置maven
3. 本项目使用idea开发调试，下载代码并导入idea后，直接运行maven install命令
4. 启动本项目，配置maven启动


课件演示,学习知识点如下:

1. Servlet 的熟练使用,包括配置web.xml.
2. jquery中的选择器使用, 包括AJAX调用方法以及作用
3. 文件上传
4. 数据库库设计,以及表设计与业务关系梳理.
5. 业务流程的分析,代码控制及规范.
6. 操作数据库,程序分层的思想.
7. 工具的熟练使用(maven,GIT)


# mybatis 该项目 作为mybatis 演示

在intellij 中对分支打tag操作。

1. 为什么要打tag？

    tag中文的意思是标签的意思，生活中的标签有很多，比如产品的合格标签，赠品标签。
    而在开发过程中，可能会有这样的问题出现，1  一个版本开发结束后，进行分支合并，在master上进行测试 上线，上线后发现有问题需要急需退回到上一个版本，这就要求我们自己手动在服务器上备份很多的war或者备份很多的文件夹。2  如果一般的修改在没有拉取新分支，而是在master上直接修改的话，修改后上线有问题，可以及时的拉取退回。3  如果在发版的时候忘记了备份war或者备份文件夹，及时代码进行回滚，代码回滚会造成一部分提交无效。所以，打tag很必要。

2. git tag和git branches区别？

    tag就像里程碑标志的一个点，branch是一个新的征程的一条线；tag 是静态的，而branch要往前走；稳定版本备份用tag，新功能开发多人用branch，开发完之后再merge到master上。
    tag是一个只读的branch。

mybatis 测试示例代码   自己学习使用

1. tag1 ： 项目初始  tag-name = v1.0

2. tag2 ： 搭建环境并测试 ,单表的CRUD操作，使用xml配置方式 tag-name = v1.1

3. tag3 ： 使用Mapper接口方式，完成单表CRUD操作 tag-name = v1.2