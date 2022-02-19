
/*
 * -----------------------------------------------------------------------------------------------------------------------
 * 版权信息
 * Copyright (c) 2022.
 * Worker:JiahanYu./于家汉
 * Date:2022/2/19 下午3:50
 * 侵权必究
 * -----------------------------------------------------------------------------------------------------------------------
 *
 */

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static final Operation op = new Operation();


    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("请选择你要进行的操作:");

            System.out.println("============菜单============");
            System.out.println("0.退出程序\n1.增加数据\t2.删除数据\n3.修改已有数据\t4.查询数据");
            int choose = input.nextInt();

            System.out.println();
            if (choose>=0 && choose<=4){
                switch (choose){
                    //添加数据
                    case 1 : {
                        System.out.println("请分别输入工号、姓名、职位、电话(中间空格分割):");
                        String no = input.next();
                        String name = input.next();
                        String dept = input.next();
                        String photo = input.next();
                        op.add(no, name, dept, photo);
                        break;
                    }
                    //删除数据
                    case 2 :{
                        System.out.println("请输入删除信息id,纯数字且回车结束:");
                        int id = input.nextInt();
                        op.delete(id);
                        break;
                    }
                    //修改数据
                    case 3 :{
                        System.out.println("请依次输入id,no,name,dept,photo(空格分隔)");
                        int id;
                        String no,name,dept,photo;
                        id = input.nextInt();
                        no = input.next();
                        name = input.next();
                        dept = input.next();
                        photo = input.next();

                        op.amend(id,no,name,dept,photo);
                        break;
                    }
                    //查询数据
                    case 4 :{
                        Object[][] a = op.inquireAll();
                        for (int i = 0; i < a.length; i++) {
                            int j = 0;
                            System.out.println(a[i][j] + " " + a[i][j+1]+ " " +
                                    a[i][j+2]+ " " + a[i][j+3] + " " + a[i][j+4]);
                        }
                        break;
                    }
                    //退出程序
                    case 0: {
                        System.exit(0);
                        break;
                    }

                }

            }else System.out.println("请输入0~4以内数字");

            System.out.println("\n");
        }

    }
}
