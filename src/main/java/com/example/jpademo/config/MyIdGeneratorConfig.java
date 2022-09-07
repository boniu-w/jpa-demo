package com.example.jpademo.config;

import com.example.jpademo.util.IpUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/************************************************************************
 * @author: wg
 * @description: jpa中 id 用雪花算法生成
 * @params:
 * @return:
 * @createTime: 11:11  2022/8/26
 * @updateTime: 11:11  2022/8/26
 ************************************************************************/
public class MyIdGeneratorConfig implements IdentifierGenerator {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 终端ID
     */
    public long WORKER_ID;

    /**
     * 数据中心id
     */
    public long DATACENTER_ID = 1;

    @PostConstruct
    public void init() throws Exception {
        String interIP1 = IpUtil.getInterIP1();
        WORKER_ID = IpUtil.ipToLong(interIP1);
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        IdWorker1 idWorker1 = new IdWorker1(WORKER_ID % 32, DATACENTER_ID, 1);
        return idWorker1.nextId();
    }

}
