package pers.johns.springboot.aop.service.impl;

import org.springframework.stereotype.Service;
import pers.johns.springboot.aop.service.inter.SomeService;

/**
 * ClassName    : SomeServiceImpl
 * Description  :
 * CreateTime   : 2024/6/1 22:47
 *
 * @author : JohnS
 * @version : 1.0
 */

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void query(Integer id) {
        System.out.println("SomeService#query 执行 ...");
    }

    @Override
    public void save(String name, Integer age) {
        System.out.println("SomeService#save 执行 ...");
    }
}
