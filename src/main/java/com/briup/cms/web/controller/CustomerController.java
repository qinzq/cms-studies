package com.briup.cms.web.controller;


import com.briup.cms.bean.Customer;
import com.briup.cms.service.ICustomerService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@Api(description = "客户相关接口")
public class CustomerController  {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/findById")
    @ApiOperation("根据客户id查询")
    @ApiImplicitParam(name = "id",value = "客户id",paramType = "query",dataType = "int",required = true)
    public Customer findById(int id) {

        return  customerService.findById(id);
    }

    @GetMapping("/save")
    public String saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        System.out.println(customer);
        return "成功录入";
    }

    @GetMapping("/delete")
    public String deleteCustomer(int id) {
        customerService.deleteById(id);
        return "删除成功";
    }

    @PostMapping("/queryH")
    @ApiOperation("正在测试两个参数")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "客户id", paramType = "query", dataType = "int",required = true),
            @ApiImplicitParam(name = "name", value = "客户名字",paramType = "query",dataType = "string")
    })
    public String queryH(int id,String name) {
        return "c";
    }

    @GetMapping("/queryQ")
    @ApiOperation("正在测试一个参数")

    public Customer queryQ(Customer customer) {
        return customer;
    }

    @GetMapping("/queryL")
    @ApiOperation("测试响应结构")
    public Message<Customer> queryL(Customer customer) {
        return MessageUtil.success(customer);
    }


}
