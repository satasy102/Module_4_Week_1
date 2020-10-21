package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class DictionaryController {
    private static final HashMap<String, String> vietnameseToEnglish=new HashMap<>();
    static {
        vietnameseToEnglish.put("xin chào","hello");
        vietnameseToEnglish.put("máy vi tính","computer");
        vietnameseToEnglish.put("điện thoại","mobile phone");
    }

    @GetMapping("/translate")
    public String convert(HttpServletRequest request) {
        try {
            String vietnamese = request.getParameter("vietnamese");
            if(vietnameseToEnglish.containsKey(vietnamese))
                request.setAttribute("english",vietnameseToEnglish.get(vietnamese));
            else request.setAttribute("english","Không có từ này");
            return "index";
        } catch (Exception e) {
            return "index";
        }
    }
}
