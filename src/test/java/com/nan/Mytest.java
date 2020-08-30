package com.nan;

import com.nan.domain.Department;
import com.nan.domain.Employee;
import com.nan.domain.User;
import com.nan.domain.UserCustom;
import com.nan.mapper.DepartmentMapper;
import com.nan.mapper.EmployeeMapper;
import com.nan.mapper.UserMapper;
import com.nan.pojo.QueryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Mytest {

    @Autowired
     DataSource dataSource;

    @Autowired
     DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void testCondtext() throws Exception{
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

    @Test
    public void testMapper(){

        QueryVo userQeuryvo = new QueryVo();
        UserCustom userCustom =new UserCustom();
        userCustom.setSex("1");
        userCustom.setUsername("张");
        userQeuryvo.setUserCustom(userCustom);
      // List<UserCustom> users= userMapper.findUserList(userQeuryvo);
      // int cout = userMapper.findUserListCount(userQeuryvo);
     //   System.out.println(cout);
        List<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(10);
        array.add(16);
        userQeuryvo.setIds(array);
        List<UserCustom> users = userMapper.getUserListWhere(userQeuryvo);
        for (UserCustom user:users
             ) {
            System.out.println(user);

        }
    }





}
