package com.scand.adsense.controlers;

import com.scand.adsense.models.Campaign;
import com.scand.adsense.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/companies")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @ResponseBody
    @RequestMapping("/getAll")
    public Iterable<Campaign> get(){
        return campaignService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getBy")
    public Campaign getById(@RequestParam(value = "id") Long id){
        return campaignService.findById(id);
    }

    @RequestMapping("/del/{id}")
    public void delete(@PathParam("id") Long id){
        campaignService.deleteById(id);
    }

    @RequestMapping("/add")
    public void add(@RequestBody Campaign campaign){
        campaignService.save(campaign);
    }
}
