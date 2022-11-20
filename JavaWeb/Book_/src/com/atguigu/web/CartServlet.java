package com.atguigu.web;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.Cart_Item;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class CartServlet extends BaseServlet {
    private BookService service=new BookServiceImpl();

    protected void addItemAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = service.queryById(id);
        // 把图书信息，转换成为CartItem商品项
        Cart_Item cartItem = new Cart_Item(book.getId(),book.getName(),1,new BigDecimal(book.getPrice()),new BigDecimal(book.getPrice()));
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);
        // 最后一个添加的商品名称
        request.getSession().setAttribute("lastName", cartItem.getName());

        //6、返回购物车总的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        response.getWriter().write(resultMapJsonString);

    }

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Book book = service.queryById(Integer.valueOf(id));
        Cart_Item item=new Cart_Item(book.getId(),book.getName(),1,new BigDecimal(book.getPrice()),new BigDecimal(book.getPrice()));


        Cart cart=(Cart)request.getSession().getAttribute("cart");

        if (cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(item);
        System.out.println(cart);


        request.getSession().setAttribute("lastName",item.getName());
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");

        Cart cart=(Cart) request.getSession().getAttribute("cart");

        if (cart!=null){
            cart.deleteItem(Integer.valueOf(id));
        }
        System.out.println(cart);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart=(Cart) request.getSession().getAttribute("cart");

        if (cart!=null){
            cart.clear();
        }
        System.out.println(cart);

        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int count=WebUtils.parseInt(request.getParameter("count"),1);

        Cart cart=(Cart) request.getSession().getAttribute("cart");

        if (cart!=null){
            cart.updateCount(id,count);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }
}
