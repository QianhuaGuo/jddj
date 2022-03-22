package com.example.qianhua.proxy;

import com.example.qianhua.ChannelCodeEnum;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportDdcAdapterBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        for (ChannelCodeEnum channelCodeEnum : ChannelCodeEnum.values()){
            RootBeanDefinition genericBeanDefinition = new RootBeanDefinition(PlatformAdapterFactoryBean.class);
//            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            //设置注入类型：按类型注入
            genericBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
            //设置注入bean的属性
            genericBeanDefinition.getPropertyValues().add("channelCode",channelCodeEnum.getCode());
            //设置注入bean的名称
            String beanName = DdcAdapterServiceSupport.getDdcAdapterClientBeanName(channelCodeEnum.getCode());
            //注入
            beanDefinitionRegistry.registerBeanDefinition(beanName,genericBeanDefinition);
        }
    }
}
