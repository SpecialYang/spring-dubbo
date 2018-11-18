package com.specialyang.springbootdubbo.controller;

import com.specialyang.dubbo.common.entity.RPCRequest;
import com.specialyang.dubbo.common.entity.RPCResponse;
import com.specialyang.dubbo.common.facade.order.IOrderService;
import com.specialyang.dubbo.common.facade.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fan Yang in 2018/11/18 下午7:43.
 */
@Controller
public class IndexController {

    @Autowired
    IOrderService iOrderService;

    @Autowired
    IUserService iUserService;

    @GetMapping(value = "/index")
    @ResponseBody
    public String index() {
        RPCRequest<String> rpcRequest = new RPCRequest<>();
        rpcRequest.setData("specialyang");
        RPCResponse rpcResponse = iOrderService.doOrder(rpcRequest);
        return rpcResponse.toString();
    }

}
