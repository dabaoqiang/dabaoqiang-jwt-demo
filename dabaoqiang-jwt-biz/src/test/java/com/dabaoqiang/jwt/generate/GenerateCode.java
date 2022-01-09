package com.dabaoqiang.jwt.generate;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xq
 */
public class GenerateCode {

    // 指定路径
    static Map<OutputFile, String> pathInfo = new HashMap<OutputFile, String>() {{
        // 设置mapperXml生成路径
        put(OutputFile.mapperXml, "D:\\workSpace\\demoWork\\dabaoqiang-jwt-demo\\dabaoqiang-jwt-biz\\src\\main\\resources\\mapper");
        // 设置entity
        put(OutputFile.entity, "D:\\workSpace\\demoWork\\dabaoqiang-jwt-demo\\dabaoqiang-jwt-domain\\src\\main\\java\\com\\dabaoqiang\\jwt\\mybatis\\domain");
        // 设置controller
        put(OutputFile.controller, "D:\\workSpace\\demoWork\\dabaoqiang-jwt-demo\\dabaoqiang-jwt-rest\\src\\main\\java\\com\\dabaoqiang\\jwt\\demo\\rest\\controllers");
    }};

    /**
     * @param args
     */
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://124.223.41.193:3306/dabaoqiang?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root", "123456")
                .globalConfig(builder -> {
                    builder.author("xq") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\workSpace\\demoWork\\dabaoqiang-jwt-demo\\dabaoqiang-jwt-biz\\src\\main\\java"); // 指定输出目录
                })

                .packageConfig(builder -> {
                    builder.parent("com.dabaoqiang.jwt") // 设置父包名
                            .pathInfo(pathInfo); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
