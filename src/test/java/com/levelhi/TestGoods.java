package com.levelhi;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;


/**
 * @Author:jiexuan
 * @Description:
 * @Date: Created in 15:13 2017/12/5
 * @Modified By:
 *
 * 新学的快捷键：自动补全变量名称 : Ctrl + Alt + v
                自动补全属性名称 : Ctrl + Alt + f
 *
 * 参考文档：http://blog.csdn.net/xubaifu1997/article/details/66476446
 */
public class TestGoods {

    private Configuration configuration;
    private SessionFactory sessionFactory;
    private Session currentSession;
    private Transaction transaction;
    private StandardServiceRegistry serviceRegistry;

    /**
     * 这个是老版本的写法，虽然还可以使用，但是好像已经很少用了，
     * 其他版本有的根本就用不了了，所以还是使用最新的版本比较好。
     *
     */
   /* @Before
    public void init(){
        configuration = new Configuration().configure();            //创建配置对象
        sessionFactory = configuration.buildSessionFactory();       //创建会话工厂
        currentSession = sessionFactory.getCurrentSession();        //开启会话
        transaction = currentSession.beginTransaction();            //开启事务
    }*/

   @Before
   public void init(){
       serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
       sessionFactory = new MetadataSources(serviceRegistry)
               .buildMetadata().buildSessionFactory();
       currentSession = sessionFactory.getCurrentSession();
       transaction = currentSession.beginTransaction();

   }


    /**
     *  这里注意因为我用的是getCurrentSession，所以自动关闭session，
     *  这里如果用这个注意还要在hibernate.cfg.xml里面进行
     *  相应配置，而如果用openSession就要主动手动关闭session了。
     *   多对多
     */
    @After
    public void destroy(){
        transaction.commit();       //提交事务
        sessionFactory.close();     //关闭会话工厂
    }


    @Test
    public void testSaveGoods() throws IOException {
        //生成地址
        Address address = new Address("888888","123456","长春");
        //先获得照片文件
        File file = new File("d:" + File.separator + "happy.jpg");
        //获得照片文件的输入流
        InputStream inputStream = new FileInputStream(file);
        Blob image = Hibernate.getLobCreator(currentSession).createBlob(inputStream,inputStream.available());
        //生成对象
        Goods goods = new Goods(4,"女朋友",27.7,new Date(),image);
        goods.setAddress(address);
        //保存对象进数据库
        currentSession.save(goods);

    }


    @Test
    public void testWriteBlob() throws IOException {
        //先获得照片文件
        File file = new File("d:" + File.separator + "happy.jpg");
        //获得照片文件的输入流
        InputStream inputStream = new FileInputStream(file);
        Blob image = Hibernate.getLobCreator(currentSession).createBlob(inputStream,inputStream.available());
        //生成对象
        Goods goods = new Goods(4,"女朋友",27.7,new Date(),image);
        //保存对象进数据库
        currentSession.save(goods);

    }

    @Test
    public void testReadBlob() throws Exception {
        Goods goods = (Goods)currentSession.get(Goods.class,17);
        Blob image = goods.getPicture();
        //获得照片的输入流
        InputStream inputStream = image.getBinaryStream();
        //创建输出流
        File file = new File("d:" + File.separator + "test.jpg");
        //获得输出流
        OutputStream outputStream = new FileOutputStream(file);
        //创建缓冲区
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        outputStream.write(bytes);
        inputStream.close();
        outputStream.close();
    }

    @Test
    public void testGetGoods(){
        Goods goods = currentSession.get(Goods.class,20);
        System.out.println(goods);
    }

    @Test
    public void testLoadGoods(){
        Goods goods = currentSession.load(Goods.class,20);
        System.out.println(goods);
    }

    @Test
    public void testUpdateGoods(){
        Goods goods = currentSession.get(Goods.class,20);
        goods.setName("update");
        currentSession.update(goods);
    }

    @Test
    public void testDeleteGoods(){
        Goods goods = currentSession.get(Goods.class,11);
        currentSession.delete(goods);
    }

}
