package part2.task3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BouquetSetD extends Bouquet {
    public List<Flower> getFlowerList() {
        List<Flower> flowers = new ArrayList();
        // 声明Connection对象
        Connection con;
        //驱动程序名
        String driver="com.mysql.jdbc.Driver";
        //Url指向要访问的数据库名mydata
        String url="jdbc:mysql://localhost:3306/flower";
        //Mysql配置时的用户名
        String username="root";
        //Mysql配置时的密码,这里的密码我设置的是空
        String password="";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //首先，getConnection（）方法，连接MySQL数据库
            con = DriverManager.getConnection(url,username,password);
            if(!con.isClosed())
                System.out.println("恭喜你成功连接数据库！");
            //然后创建statement类对象，用来执行SQL语句
            Statement statement=con.createStatement();
            //你要执行的Sql语句
            String sql="select name,color, price from flower";
            //最后设置Resultset类，用来存放获取的结果集
            ResultSet rs=statement.executeQuery(sql);

            System.out.println("执行结果如下：");
            System.out.println("Name"+"\t"+"Color"+"\t"+"Price");

            String name=null;
            String color=null;
            int price = 0;
            while(rs.next()) {

                //获取flower的name数据
                name=rs.getString("name");
                //获取flower的color数据
                color=rs.getString("color");
                //获取flower的price数据
                price=rs.getInt(price);

                if ("Rose".equalsIgnoreCase(name)) {
                    flowers.add(new Rose(color, price));
                } else if ("Lily".equalsIgnoreCase(name)) {
                    flowers.add(new Lily(color, price));
                }
            }

            //最后关闭
            rs.close();
            con.close();
        }catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        }catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("恭喜你，数据库数据获取成功!!!");
        }
     return flowers;
    }
}
