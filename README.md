# testofhibernate
我的hibernate练习
---
当前进度更新：
1. 2017-12-6 11:11:15 ： 环境搭建完成，实现单个对象添加进数据库成功。---下一步各种关系映射？
2. 测试修改GitHub上的代码，idea如何同步更新？只要再客户端同步一下就好，idea开着也会自动更新的，那么这个同步更新这个问题就解决了。
3. 现在确定idea上的代码，只要项目的根目录文件夹当初建的就是仓库，那么只要有所改动，那么GitHub客户端就自动检查到change，然后只要再提交，然后同步就可以了。

---
更新：
2017-12-11 10:50:18
1. IO流部分还要加强。
2. 对象类型  
存取对象类型，比如图片用Blob类型，hibernate如何实现。
3. 组件属性  
 * 实体类中的某个属性属于用户自定义的类的对象.
 * 在属性的实体类上面加入@Embeddle
 * 在对象中的属性上添加 @EmbeddedId和 @AttributeOverrides({
                                      @AttributeOverride(name="postcode", column=@Column(name="postcade")),
                                      @AttributeOverride(name="phone", column=@Column(name="phone", length=20)),
                                      @AttributeOverride(name="address", column=@Column(name="address", length=20))
     })  
---
更新：
2017-12-11 14:03:34
1. 单表CRUD操作实例
  * save
  * update
  * delete
  * get/load(查询单个记录)  
2. 尽量用logger，这里先不用了，还有构建这个项目用的还是
maven，以后有时间再用gradle重新做一个。
3. get与load的区别
 * 在不考虑缓存的情况下，get方法会在调用之后立即向数据库发出SQL
 语句，返回持久化对象。  
 load方法会在调用后返回一个代理对象。  
 该代理对象只保存了实体对象的id，直到使用对象的非主键属性时
 才会发出SQL语句。  
 * 查询数据库中不存在的数据时，get方法返回null，load方法
 跑出异常。 
4. hibernate开发的基本步骤
    * 编写配置文档hibernate.cfg.xml
    * 编写实体类
    * 生成对应实体类的映射文件并添加到配置文件中
    * 调用hibernate API进行测试
5. 什么是session？
6. openSession与getCurrentSession的区别？
7. 单表操作常用方法有哪些？

---
至此慕课网关于hibernate的第一套视频《hibernate初探之
单表映射》学习完了  
接下来学习第二套《hibernate初探之一对多映射》
---
1. 常见的4种，最常用的有两种，分别是一对多和多对一。
2. 在数据库中，可以通过添加主外键的关联，表现出一对多的关系。
3. 通过在一方持有多方的集合实现，即在“一”的一端使用<set>元素
表示持有“多”的一端的对象。
4. 这套首先老师先创建了一个hibernateUtil，这样也很好，方便
以后使用。我这里就不那么做了，直接写测试类里面了。
5. 建立一对多映射需要的两个表，grade和student.