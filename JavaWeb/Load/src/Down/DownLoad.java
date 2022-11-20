package Down;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@SuppressWarnings("all")
public class DownLoad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取要下载的文件名
        String fileName="money.jpg";
//        String fileName="index.html";
        //2. 读取要下载的文件内容
        ServletContext servletContext = getServletContext();


                //4. 在回传前，通过响应头告诉客户端返回的数据类型
                    /**
                     * mimeType 文件类型
                     * response.setContentType 告诉返回的类型
                     */
                    String mimeType = servletContext.getMimeType("/images/" + fileName);
                    response.setContentType(mimeType);
                 //5. 还要告诉客户端收到的数据是用于下载的
                    /**
                    * Content-Disposition 表示收到的数据怎么处理
                    * attachment 表示附件
                    * filename 表示指定下载的文件名
                    * URLEncoder.encode() 编码 把汉字转换成 %XX%XX 的 格式
                    */

                    response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, StandardCharsets.UTF_8));



        //3. 把下载的文件回传到客户端
        InputStream resourceAsStream = servletContext.getResourceAsStream("/images/" + fileName);
        OutputStream outputStream=response.getOutputStream();
        IOUtils.copy(resourceAsStream,outputStream);

    }

}
