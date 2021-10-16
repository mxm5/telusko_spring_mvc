package io.mxm;

import io.mxm.service.AddService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddController {

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        int k = 0;

        ModelAndView mv = new ModelAndView();
        try {
            String n1 = request.getParameter("n1");
            System.out.println(n1);
            int i = Integer.parseInt(n1);
            String n2 = request.getParameter("n2");
            System.out.println(n2);
            int j = Integer.parseInt(n2);
            AddService addService = new AddService();
            k = addService.add(i, j);
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("error", e);
        }
        mv.addObject("result", k);
        mv.setViewName("display.jsp");
        return mv;
    }
}
