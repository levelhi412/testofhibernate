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
