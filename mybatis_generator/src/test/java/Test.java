import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
//一般配合spring使用
public class Test {
    public static void main(String[] args) throws InvalidConfigurationException, IOException, XMLParserException, SQLException, InterruptedException {
//        获取warnings,报错生成时的警告信息
        ArrayList<String> warnings = new ArrayList<>();
//        获取configuration
        ConfigurationParser parser = new ConfigurationParser(warnings);
        //传入字节流或是文件流都行
        InputStream is = Test.class.getClassLoader().getResourceAsStream("generatorConfig.xml");
//        File file = new File("src/main/resources/generatorConfig.xml");
        Configuration configuration = parser.parseConfiguration(is);
//        获取sellCallback,overwrite如果有新内容是否覆盖
        ShellCallback shellCallback = new DefaultShellCallback(true);
        //核心
        MyBatisGenerator generator = new MyBatisGenerator(configuration, shellCallback, warnings);
//        参数置为null和new一个nullProgressCallback();都可以拿到
        generator.generate(null);
//        ProgressCallback progressCallback = new NullProgressCallback();
//        generator.generate(progressCallback);
    }
}
