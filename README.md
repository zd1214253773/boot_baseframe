# PAHM-SpringBootBase
1.数据库名小写，单词间下划线隔开，如empi_patient_info
2.字段是驼峰形式，首字母小写，如personName
3.主键使用雪花算法，框架利用AOP DataCommonFillAop在新增时自动填充
4.使用自己的代码生成器，可以生成各个层面的代码，包括controller,service,dao,
    entity,VO,queryVO.
    (1)dao命名规范,新增以insert开头（如批量建议insertBatch），更新和删除分别以update
        、delete开头，这样命名规约方便aop拦截，之后分别做对应的通用操作。
    (2)各个层面已经生成了分页查询方法，不过需要改装一下，参考EmpiPatientInfoServiceImpl#listByPage
    (3)用户信息在拦截器做统一处理和填充
    (4)自定义的注解ApiPropIgnore可屏蔽某些不需要在swagger展示的属性(包括嵌套的属性)。
5.mybatis代码生成器的使用
 1）首先 根据 https://blog.csdn.net/qq_35529931/article/details/82108308 学习下代码生成器的使用和配置。
 2）将修改后的生成mybatis-generator-core-1.3.6.jar包，放入本地maven路径中 \org\mybatis\generator\mybatis-generator-core\1.3.6
 覆盖mybatis-generator-core-1.3.6.jar。插件使用的就是maven该路径中的jar包。
 
 
1楼机房的redis-dev：192.168.152.210:6379      db1      密码：sungrow123

IP&Port：116.62.184.16:30336
数据库名：isolartool_w_dev
用户名：   iSolarTool-W_dev
密码：Sungrow123