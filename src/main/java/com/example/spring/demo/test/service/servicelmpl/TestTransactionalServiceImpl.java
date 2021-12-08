package com.example.spring.demo.test.service.servicelmpl;

import com.example.spring.demo.entity.Login;
import com.example.spring.demo.entity.Message;
import com.example.spring.demo.enums.MsgCodeEnum;
import com.example.spring.demo.exception.BusinessException;
import com.example.spring.demo.service.Userservice;
import com.example.spring.demo.test.service.TestTransactionalService;
import com.example.spring.demo.util.JudgeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author han_lic
 * @date 2021/12/8 14:19
 * @Description
 */
@Service
public class TestTransactionalServiceImpl implements TestTransactionalService {

    @Resource
    Userservice userservice;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void testTransactional(List<Login> loginList) {
        loginList.forEach(s -> {
            userservice.insert(s);
        });
        Message message = new Message();
        updateMessage(message);


//        if (integer != 1) {
//            BusinessException.throwBusinessException(MsgCodeEnum.PRODUCT_FAILURE.getMsgCd());
//        }

//        if (JudgeUtils.equals(login.getUsername(),"liuyang")){
//            login.setMoney(new BigDecimal("0.03"));
//            userservice.update(login);
//            BusinessException.throwBusinessException(MsgCodeEnum.PRODUCT_FAILURE.getMsgCd());
//        }
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    void updateMessage(Message message) {
        Integer integer = userservice.updateMessage(message);
        if (integer != 1) {
            BusinessException.throwBusinessException(MsgCodeEnum.PRODUCT_FAILURE.getMsgCd());
        }
    }
}
