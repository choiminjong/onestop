package com.nexon.onestop.controller.view.clip;

import com.nexon.onestop.domain.dto.DelegateDto;
import com.nexon.onestop.domain.entity.Delegate;
import com.nexon.onestop.service.impl.DelegateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clip")
public class DelegateController {

    @Autowired
    private DelegateServiceImpl delegateServiceImpl;

    @GetMapping(value="/delegate")
    public String getdelegates(Model model) throws Exception {

        List<Delegate> delegates = delegateServiceImpl.getDelegates();
        model.addAttribute("delegates", delegates);

        return "clip/admin/settings/delegate/list";
    }

    @GetMapping(value = "/delegate/{id}")
    public String getdelegate(@PathVariable(value = "id") Long id, Model model) {

        DelegateDto delegate = delegateServiceImpl.getDelegate(id);
        model.addAttribute("delegate", delegate);

        return "clip/admin/settings/delegate/detail";
    }


}
